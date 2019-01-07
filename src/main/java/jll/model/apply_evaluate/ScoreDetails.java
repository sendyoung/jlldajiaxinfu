package jll.model.apply_evaluate;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 评分记录详情
 * */
@Entity(name = "eva_score_details")
public class ScoreDetails extends Base_Model {
    private String score_details_id;
    private String score_rule_id;//评分规则ID
    private String apply_evaluate_id;//申请Id
    private Double score;//分数

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getScore_details_id() {
        return score_details_id;
    }

    public void setScore_details_id(String score_details_id) {
        this.score_details_id = score_details_id;
    }

    public String getScore_rule_id() {
        return score_rule_id;
    }

    public void setScore_rule_id(String score_rule_id) {
        this.score_rule_id = score_rule_id;
    }

    public String getApply_evaluate_id() {
        return apply_evaluate_id;
    }

    public void setApply_evaluate_id(String apply_evaluate_id) {
        this.apply_evaluate_id = apply_evaluate_id;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
