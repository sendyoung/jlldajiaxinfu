package jll.model.apply_evaluate;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 评分结果
 * */
@Entity(name="eva_score_result")
public class ScoreResult extends Base_Model {
    private String score_result_id;//评分结果ID
    private String score;//综合评分
    private String level;//评分等级
    private String apply_evaluate_id;//申请评价ID

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getScore_result_id() {
        return score_result_id;
    }

    public void setScore_result_id(String score_result_id) {
        this.score_result_id = score_result_id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getApply_evaluate_id() {
        return apply_evaluate_id;
    }

    public void setApply_evaluate_id(String apply_evaluate_id) {
        this.apply_evaluate_id = apply_evaluate_id;
    }
}
