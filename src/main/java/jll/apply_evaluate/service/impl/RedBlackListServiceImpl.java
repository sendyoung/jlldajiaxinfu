package jll.apply_evaluate.service.impl;

import jll.apply_evaluate.dao.EnterprisesPunishmentDao;
import jll.apply_evaluate.dao.RedBlackListDao;
import jll.apply_evaluate.dao.RedBlackListDetailsDao;
import jll.apply_evaluate.service.RedBlackListService;
import jll.model.apply_evaluate.RedBlackEvaluate;
import jll.model.apply_evaluate.RedBlackList;
import jll.model.apply_evaluate.RedBlackListDetails;
import jll.utils.MapTrunPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("redBlackListService")
@Transactional
public class RedBlackListServiceImpl implements RedBlackListService {

   @Autowired
    private RedBlackListDao redBlackListDao;//红黑榜

    @Autowired
    private EnterprisesPunishmentDao enterprisesPunishmentDao;//黑榜

    @Autowired
    private RedBlackListDetailsDao redBlackListDetailsDao;//红黑榜详情

    @Override
    public void editRedBlackList(RedBlackList redBlackList) {
        Calendar cale = null;
        cale = Calendar.getInstance();
        int year = cale.get(Calendar.YEAR);
        //根据组织Id年度查看未作废的榜单
        RedBlackList rbl=redBlackListDao.queryRedBlackListForStatus(redBlackList.getAuth_org_id(),"1",null,year+"");
        if(rbl!=null){
            //存在榜单，需作废
            rbl.setStatus("2");
            redBlackListDao.saveRedBlackList(rbl);
        }
        //生成榜单
        String redBlackListId=redBlackListDao.saveRedBlackList(redBlackList);
        //查询组织下的所有已完成请求
        //红榜
        if(redBlackList.getType().equals("1")){
            List list=redBlackListDao.queryRedBlackListForRedList(redBlackList.getAuth_org_id());
            for(int i=0;i<list.size();i++){
                RedBlackEvaluate rbe=(RedBlackEvaluate)MapTrunPojo.map2Object((Map)list.get(i),RedBlackEvaluate.class);
                //生成黑榜详情
                RedBlackListDetails rbld=new RedBlackListDetails();
                rbld.setCreate_time(new Date());
                rbld.setRed_black_list_id(redBlackListId);
                rbld.setApply_evaluate_id(rbe.getApply_evaulate_id());
                redBlackListDetailsDao.saveRedBlackListDetails(rbld);
            }
        }
        //黑榜
        if(redBlackList.getType().equals("2")){
            //查询所有黑榜申请Id
            List list=enterprisesPunishmentDao.EnterprisesPunishmentByAuthOrgIdForApplyEvaluateId(redBlackList.getAuth_org_id());
            for(int i=0;i<list.size();i++){
                RedBlackEvaluate rbe=(RedBlackEvaluate)MapTrunPojo.map2Object((Map)list.get(i),RedBlackEvaluate.class);
                //生成黑榜详情
                RedBlackListDetails rbld=new RedBlackListDetails();
                rbld.setCreate_time(new Date());
                rbld.setRed_black_list_id(redBlackListId);
                rbld.setApply_evaluate_id(rbe.getApply_evaulate_id());
                redBlackListDetailsDao.saveRedBlackListDetails(rbld);
            }
        }

    }
}
