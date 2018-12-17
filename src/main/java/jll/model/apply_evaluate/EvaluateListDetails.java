package jll.model.apply_evaluate;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 评价榜单结果（申请跟榜单中间表）
 * */
@Entity(name="eva_evaluate_list_details")
public class EvaluateListDetails extends Base_Model {
    private String evaluate_list_details_id;//评价榜单结果ID
    private String evaluate_list_id;//评价榜单ID
    private String apply_evaluate_id;//申请评价ID

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getEvaluate_list_details_id() {
        return evaluate_list_details_id;
    }

    public void setEvaluate_list_details_id(String evaluate_list_details_id) {
        this.evaluate_list_details_id = evaluate_list_details_id;
    }

    public String getEvaluate_list_id() {
        return evaluate_list_id;
    }

    public void setEvaluate_list_id(String evaluate_list_id) {
        this.evaluate_list_id = evaluate_list_id;
    }

    public String getApply_evaluate_id() {
        return apply_evaluate_id;
    }

    public void setApply_evaluate_id(String apply_evaluate_id) {
        this.apply_evaluate_id = apply_evaluate_id;
    }
}
