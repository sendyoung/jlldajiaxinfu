package jll.message.dao.service.impl;

import jll.apply_evaluate.dao.ApplyModuleDao;
import jll.message.dao.service.ApplyModuleService;
import jll.model.apply_evaluate.ApplyModule;
import jll.utils.MapTrunPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("applyModuleService")
@Transactional
public class ApplyModuleServiceImpl implements ApplyModuleService {

    @Autowired
    private ApplyModuleDao applyModuleDao;//申请评价模块

    @Autowired
    private ApplyEvaluateDao applyEvaluateDao;//申请评价


    @Override
    public List findApplyModuleByApplyEvaluateId(String applyEvaluateId) {
        return applyModuleDao.queryApplyModuleByApplyEvaluateId(applyEvaluateId);
    }

    @Override
    public void editApplyModuleForStatus(String applyModuleId,String remarks) {
        //模块审核通过
        applyModuleDao.updateApplyModuleForStatus(applyModuleId,"1",remarks);
        //查询请求下的所有模块
        List list=applyModuleDao.queryApplyModuleByApplyModuleId(applyModuleId);
        Integer result=0;
        String applyEvaluateId=null;
        for (int i=0;i<list.size();i++){
            ApplyModule am=(ApplyModule)MapTrunPojo.map2Object((Map)list.get(i),ApplyModule.class);
            applyEvaluateId=am.getApply_evaluate_id();
            //判断模块是否所有审核通过
            if(am.getStatus()==null||am.getStatus().equals("2")){
                result=1;
                break;
            }
        }
        //改变请求审核状态
        if(result==0){
            //审核通过
            //申请的审核状态变为3(待评价)申请状态变为4(已完成)
            applyEvaluateDao.updateApplyEvaluateForAuditStatus(applyEvaluateId,"4","3");
        }else{
            //审核中
            //申请的审核状态变为2(审核中)申请状态变为4(已完成)
            applyEvaluateDao.updateApplyEvaluateForAuditStatus(applyEvaluateId,"4","2");
        }
    }

    @Override
    public void editApplyModuleForStatusToNot(String applyModuleId) {
        //模块审核不通过
        applyModuleDao.updateApplyModuleForStatus(applyModuleId,"2","");
        ApplyModule am=applyModuleDao.queryApplyModuleDetailByApplyModuleId(applyModuleId);
        //申请的审核状态变为2(审核中)申请状态变为4(已完成)
        applyEvaluateDao.updateApplyEvaluateForAuditStatus(am.getApply_evaluate_id(),"4","2");
    }

    @Override
    public void editApplyModuleForStatusByAll(String applyEvaluateId) {
        List list=applyModuleDao.queryApplyModuleByApplyEvaluateIdForAll(applyEvaluateId);
        for (int i=0;i<list.size();i++){
            ApplyModule am=(ApplyModule)MapTrunPojo.map2Object((Map)list.get(i),ApplyModule.class);
            //模块审核通过
            applyModuleDao.updateApplyModuleForStatus(am.getApply_module_id(),"1","");
        }
    }
}
