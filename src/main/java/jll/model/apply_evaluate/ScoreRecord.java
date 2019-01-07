package jll.model.apply_evaluate;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 评分记录
 * */
@Entity(name="eva_score_record")
public class ScoreRecord extends Base_Model {
    private String score_record_id;//评分记录ID
    private String standard_id;//评分标准ID
    private String apply_evaluate_id;//申请评价ID
    private String index_item;//指标项
    private Double score;//指标项得分

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getScore_record_id() {
        return score_record_id;
    }

    public void setScore_record_id(String score_record_id) {
        this.score_record_id = score_record_id;
    }

    public String getStandard_id() {
        return standard_id;
    }

    public void setStandard_id(String standard_id) {
        this.standard_id = standard_id;
    }

    public String getApply_evaluate_id() {
        return apply_evaluate_id;
    }

    public void setApply_evaluate_id(String apply_evaluate_id) {
        this.apply_evaluate_id = apply_evaluate_id;
    }

    public String getIndex_item() {
        return index_item;
    }

    public void setIndex_item(String index_item) {
        this.index_item = index_item;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
