package jll.apply_evaluate.service;

import java.util.List;

public interface ApplyModuleService {
    /**
     * 根据请求ID查询模块
     * */
    public List findApplyModuleByApplyEvaluateId(String applyEvaluateId);
    /**
     * 审核通过
     * */
    public void editApplyModuleForStatus(String applyModuleId,String remarks);
    /**
     * 审核不通过
     * */
    public void editApplyModuleForStatusToNot(String applyModuleId);
    /**
     * 审核全部通过
     * */
    public void editApplyModuleForStatusByAll(String applyEvaluateId);
}
