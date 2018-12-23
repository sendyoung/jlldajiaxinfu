package jll.apply_evaluate.service;

public interface ScoreRecordService {

    /**
     * 查询评分记录返回总评分
     * */
    public Float findScoreRecord(String applyEvaluateId);
}
