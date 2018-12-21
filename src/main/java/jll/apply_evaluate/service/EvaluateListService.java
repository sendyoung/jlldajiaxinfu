package jll.apply_evaluate.service;

public interface EvaluateListService {
    /**
     * 添加评价榜单
     * */
    public void editEvaluateList(String authOrgId,String title,String content);
    /**
     * 查询年度榜单
     * */
    public Object findEvaluateListByDate(String authOrgId,String date,Integer page,Integer rows);
}
