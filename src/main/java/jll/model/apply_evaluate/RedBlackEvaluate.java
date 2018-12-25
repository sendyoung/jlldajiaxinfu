package jll.model.apply_evaluate;
/**
 * 获取黑榜中的请求Id
 * */
public class RedBlackEvaluate {
    private String apply_evaluate_id;//请求ID
    private String enterprise_name;//企业名称
    private Integer count;//数量



    public String getEnterprise_name() {
        return enterprise_name;
    }

    public void setEnterprise_name(String enterprise_name) {
        this.enterprise_name = enterprise_name;
    }

    public String getApply_evaluate_id() {
        return apply_evaluate_id;
    }

    public void setApply_evaluate_id(String apply_evaluate_id) {
        this.apply_evaluate_id = apply_evaluate_id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
