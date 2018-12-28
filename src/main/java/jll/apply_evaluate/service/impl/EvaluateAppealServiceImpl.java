package jll.apply_evaluate.service.impl;

import com.cn.zyzs.hibernate.util.Page;
import com.cn.zyzs.utils.utils.PageContext;
import com.cn.zyzs.utils.utils.PageView;
import jll.apply_evaluate.dao.*;
import jll.apply_evaluate.service.EvaluateAppealService;
import jll.model.apply_evaluate.ApplyModule;
import jll.model.apply_evaluate.EvaluateAppeal;
import jll.model.apply_evaluate.RedBlackList;
import jll.model.apply_evaluate.RedBlackListDetails;
import jll.utils.MapTrunPojo;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

@Service("evaluateAppealService")
@Transactional
public class EvaluateAppealServiceImpl implements EvaluateAppealService {

    @Autowired
    private EvaluateAppealDao evaluateAppealDao;//评价申诉

    @Autowired
    private ApplyEvaluateDao applyEvaluateDao;//申请评价

    @Autowired
    private ApplyModuleDao applyModuleDao;//申请评价模块

    @Autowired
    private RedBlackListDao redBlackListDao;//红黑榜

    @Autowired
    private RedBlackListDetailsDao redBlackListDetailsDao;//红黑榜单详情

    @Override
    public void editEvaluateAppeal(EvaluateAppeal evaluateAppeal) {
        //添加申诉
        evaluateAppealDao.saveEvaluateAppeal(evaluateAppeal);
        //请求评价申诉状态为已申诉
        applyEvaluateDao.updateApplyEvaluateForAppealStatus(evaluateAppeal.getApply_evaluate_id(),"1");
    }

    @Override
    public Object findEvaluateAppealHistory(String authEnterpriseId, String appealStype, String appealCreateTime, String appealStatus, Integer page, Integer rows) {
        try {
            Map param = new HashedMap();
            PageContext.setOffSet(page);
            PageContext.setPageSize(rows);
            Page pages=evaluateAppealDao.queryEvaluateAppealHistory(authEnterpriseId,appealStype,appealCreateTime,appealStatus);
            PageView pageView = new PageView(PageContext.getPageSize(), PageContext.getOffSet());
            pageView.setTotalpage(pages.getTotal());
            pageView.setRecords(pages.getItems());
            return pageView;
        } catch (Exception e) {
            e.printStackTrace();
            return "500";
        }
    }

    @Override
    public Object findEvaluateAppealByApplyEvaluateId(String applyEvaluateId) {
        return evaluateAppealDao.queryEvaluateAppealByApplyEvaluateId(applyEvaluateId);
    }

    @Override
    public Object findEvaluateAppealByAuthOrgId(String authOrgId, String stype, String appealTime, String appealStatus, String name, Integer page, Integer rows) {
        try {
            Map param = new HashedMap();
            PageContext.setOffSet(page);
            PageContext.setPageSize(rows);
            Page pages=evaluateAppealDao.queryEvaluateAppealByAuthOrgId(authOrgId,stype,appealTime,appealStatus,name);
            PageView pageView = new PageView(PageContext.getPageSize(), PageContext.getOffSet());
            pageView.setTotalpage(pages.getTotal());
            pageView.setRecords(pages.getItems());
            return pageView;
        } catch (Exception e) {
            e.printStackTrace();
            return "500";
        }
    }

    @Override
    public Object findEvaluateAppealDetailsForApplyEvaluateId(String evaluateAppealId) {
        return evaluateAppealDao.queryEvaluateAppealDetailsForApplyEvaluateId(evaluateAppealId);
    }

    @Override
    public EvaluateAppeal findEvaluateAppeal(String evaluateAppealId) {
        return evaluateAppealDao.queryEvaluateAppeal(evaluateAppealId);
    }

    @Override
    public void editEvaluateAppealForAuthOrgId(String authOrgId,EvaluateAppeal evaluateAppeal,String appealStatus) {
        //修改申诉信息
        evaluateAppealDao.saveEvaluateAppeal(evaluateAppeal);
        if(appealStatus!=null&&!appealStatus.equals("")){
            //请求评价申诉状态为已申诉
            applyEvaluateDao.updateApplyEvaluateForAppealStatus(evaluateAppeal.getApply_evaluate_id(),appealStatus);
            //如果申诉受理
            if(appealStatus.equals("2")){
                    //查询所有的请求模块
                    List list=applyModuleDao.queryApplyModuleByApplyEvaluateIdForAll(evaluateAppeal.getApply_evaluate_id());
                    for (int i=0;i<list.size();i++){
                        ApplyModule am=(ApplyModule)MapTrunPojo.map2Object((Map)list.get(i),ApplyModule.class);
                        //模块审核为待审核
                        applyModuleDao.updateApplyModuleForStatus(am.getApply_module_id(),"",null);
                    }
                    //申请的审核状态变为3(待评价)申请状态变为4(已完成)
                    applyEvaluateDao.updateApplyEvaluateForAuditStatus(evaluateAppeal.getApply_evaluate_id(),"4","1");
                    //红黑榜Id作废
                    Calendar cale = null;
                    cale = Calendar.getInstance();
                    int year = cale.get(Calendar.YEAR);
                    //根据组织Id年度查看未作废的榜单
                    //红榜
                    RedBlackList rbl=redBlackListDao.queryRedBlackListForStatus(authOrgId,"1",null,year+"","1");
                    //根据榜单ID跟申请评价ID查询榜单详情
                    RedBlackListDetails rbld=redBlackListDetailsDao.queryRedBlackListDetails(rbl.getRed_black_list_id(),evaluateAppeal.getApply_evaluate_id());
                    if(rbld!=null){
                        rbld.setIsDelete("1");
                        redBlackListDetailsDao.saveRedBlackListDetails(rbld);
                    }
                    //黑榜
                    RedBlackList rbl2=redBlackListDao.queryRedBlackListForStatus(authOrgId,"1",null,year+"","2");
                //根据榜单ID跟申请评价ID查询榜单详情
                RedBlackListDetails rbld2=redBlackListDetailsDao.queryRedBlackListDetails(rbl2.getRed_black_list_id(),evaluateAppeal.getApply_evaluate_id());
                if(rbld2!=null){
                    rbld2.setIsDelete("1");
                    redBlackListDetailsDao.saveRedBlackListDetails(rbld2);
                }
                //重新评分

            }
        }
    }
}
