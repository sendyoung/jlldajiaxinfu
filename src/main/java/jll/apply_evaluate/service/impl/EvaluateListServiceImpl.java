package jll.apply_evaluate.service.impl;

import com.cn.zyzs.hibernate.util.Page;
import com.cn.zyzs.utils.utils.PageContext;
import com.cn.zyzs.utils.utils.PageView;
import jll.apply_evaluate.dao.ApplyEvaluateDao;
import jll.apply_evaluate.dao.EvaluateListDao;
import jll.apply_evaluate.dao.EvaluateListDetailsDao;
import jll.apply_evaluate.service.EvaluateListService;
import jll.model.apply_evaluate.ApplyEvaluate;
import jll.model.apply_evaluate.EvaluateList;
import jll.model.apply_evaluate.EvaluateListDetails;
import jll.utils.MapTrunPojo;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("evaluateListService")
@Transactional
public class EvaluateListServiceImpl implements EvaluateListService {

    @Autowired
    private EvaluateListDao evaluateListDao;//评价榜单

    @Autowired
    private ApplyEvaluateDao applyEvaluateDao;//请求评价

    @Autowired
    private EvaluateListDetailsDao evaluateListDetailsDao;//评价榜单结果

    @Override
    public void editEvaluateList(String authOrgId, String title, String content) {
        Calendar cale = null;
        cale = Calendar.getInstance();
        int year = cale.get(Calendar.YEAR);
        //根据组织Id年度查看未作废的榜单
        EvaluateList el=evaluateListDao.queryEvaluateListForStatus(authOrgId,"1",null,year+"");
        if(el!=null){
            //存在榜单，需作废
            el.setStatus("2");
            evaluateListDao.saveEvaluateList(el);
        }
        //生成榜单
        EvaluateList evaluateList=new EvaluateList();
        evaluateList.setAuth_org_id(authOrgId);
        evaluateList.setContent(content);
        evaluateList.setTitle(title);
        evaluateList.setCreate_time(new Date());
        evaluateList.setStatus("1");
        //evaluateList.setPublic_status("2");
        String evaluateListId=evaluateListDao.saveEvaluateList(evaluateList);
        //查询组织下的所有已完成请求
        List list=applyEvaluateDao.queryApplyEvaluateByAuthOrgId(authOrgId);
        for(int i=0;i<list.size();i++){
            ApplyEvaluate ae=(ApplyEvaluate)MapTrunPojo.map2Object((Map)list.get(i),ApplyEvaluate.class);
            EvaluateListDetails eld=new EvaluateListDetails();
            eld.setApply_evaluate_id(ae.getApply_evaluate_id());
            eld.setEvaluate_list_id(evaluateListId);
            evaluateListDetailsDao.saveEvaluateListDetails(eld);
        }

    }

    @Override
    public Object findEvaluateListByDate(String authOrgId, String date, Integer page, Integer rows) {
        //年度榜单
        EvaluateList el=evaluateListDao.queryEvaluateListForStatus(authOrgId,"1",null,date);
        if(el==null){
            return "暂未生成榜单";
        }
        String evaluateListId=el.getEvaluate_list_id();
        //根据榜单ID查询详情
        try {
            Map param = new HashedMap();
            PageContext.setOffSet(page);
            PageContext.setPageSize(rows);
            Page pages=evaluateListDetailsDao.queryEvaluateListDetailsByEvaluateListId(evaluateListId);
            PageView pageView = new PageView(PageContext.getPageSize(), PageContext.getOffSet());
            pageView.setTotalpage(pages.getTotal());
            pageView.setRecords(pages.getItems());
            return pageView;
        } catch (Exception e) {
            e.printStackTrace();
            return "500";
        }
    }
}
