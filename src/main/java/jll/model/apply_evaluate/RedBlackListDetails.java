package jll.model.apply_evaluate;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 红黑名单基础信息
 * */
@Entity(name="eva_red_black_list_details")
public class RedBlackListDetails extends Base_Model {
    private String red_black_list_details_id;
    private String red_black_list_id;//红黑榜单ID
    private String apply_evaluate_id;//申请评价ID

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getRed_black_list_details_id() {
        return red_black_list_details_id;
    }

    public void setRed_black_list_details_id(String red_black_list_details_id) {
        this.red_black_list_details_id = red_black_list_details_id;
    }

    public String getRed_black_list_id() {
        return red_black_list_id;
    }

    public void setRed_black_list_id(String red_black_list_id) {
        this.red_black_list_id = red_black_list_id;
    }

    public String getApply_evaluate_id() {
        return apply_evaluate_id;
    }

    public void setApply_evaluate_id(String apply_evaluate_id) {
        this.apply_evaluate_id = apply_evaluate_id;
    }
}
