package jll.model.apply_evaluate;
/**
 * 获取黑榜中的请求Id
 * */
public class RedBlackEvaluate {
    private String apply_evaulate_id;//请求ID
    private String enterprise_name;//企业名称
    private Integer count;//数量

    public String getApply_evaulate_id() {
        return apply_evaulate_id;
    }

    public void setApply_evaulate_id(String apply_evaulate_id) {
        this.apply_evaulate_id = apply_evaulate_id;
    }

    public String getEnterprise_name() {
        return enterprise_name;
    }

    public void setEnterprise_name(String enterprise_name) {
        this.enterprise_name = enterprise_name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
