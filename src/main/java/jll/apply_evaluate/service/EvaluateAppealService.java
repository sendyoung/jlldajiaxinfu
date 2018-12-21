package jll.apply_evaluate.service;

import jll.model.apply_evaluate.EvaluateAppeal;

public interface EvaluateAppealService {
    /**
     * 添加评价申诉
     * */
    public void editEvaluateAppeal(EvaluateAppeal evaluateAppeal);
    /**
     * 查询历史申诉
     * */
    public Object findEvaluateAppealHistory(String applyEvaluateId,String appealStype,String appealCreateTime, String appealStatus,Integer page,Integer rows);
    /**
     * 历史申诉详情
     * */
    public Object findEvaluateAppealByApplyEvaluateId(String applyEvaluateId);
    /**
     * 组织的所有申诉
     * */
    public Object findEvaluateAppealByAuthOrgId(String authOrgId,String stype,String appealTime,String appealStatus,String name,Integer page,Integer rows);
}
