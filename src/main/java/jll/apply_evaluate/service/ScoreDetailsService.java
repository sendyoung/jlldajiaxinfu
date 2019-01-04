package jll.apply_evaluate.service;

import jll.model.apply_evaluate.ScoreRule;

import java.util.List;

public interface ScoreDetailsService {

    /**
     * 保存评分
     * */
    public Double findScoreRule(List<ScoreRule> sdList, String applyEvaluateId);
}
