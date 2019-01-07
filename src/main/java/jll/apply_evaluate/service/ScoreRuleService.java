package jll.apply_evaluate.service;

import java.util.List;

public interface ScoreRuleService {

    /**
     * 查询评分规则
     * */
    public List findScoreRule(String authOrgId,String applyEvaluateId);
}
