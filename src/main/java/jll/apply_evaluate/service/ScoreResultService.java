package jll.apply_evaluate.service;

public interface ScoreResultService {

    /**
     * 保存评分结果
     * */
    public void editScoreResult(String authOrgId,String applyEvaluateId,Double score);
    /**
     * 组织评分结果数
     * */
    public Object findScoreResultForCount(String authOrgId,String level);
    /**
     * 查询组织所有某个等级的企业
     * */
    public Object findScoreResultByLevel(String authOrgId, String level,Integer page,Integer rows);
}
