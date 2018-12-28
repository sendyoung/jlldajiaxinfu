package jll.model.apply_evaluate;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 评分结果
 * */
@Entity(name="eva_score_result")
public class ScoreResult{
    private String score_result_id;//评分结果ID
    private Float score;//综合评分
    private String level;//评分等级
    private String apply_evaluate_id;//申请评价ID
    private Date create_time;
    private Date update_time;
    private String isDelete;
    private String comment;

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getScore_result_id() {
        return score_result_id;
    }

    public void setScore_result_id(String score_result_id) {
        this.score_result_id = score_result_id;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
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

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
