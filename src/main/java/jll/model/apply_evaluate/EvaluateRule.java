package jll.model.apply_evaluate;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 评分规则
 * */
@Entity(name="eva_evaluate_rule")
public class EvaluateRule extends Base_Model {
    private String rule_id;//规则ID
    private String standard_id;//评分标准ID
    private String referrence;//评分规则描述
    private Double top_limit;//取值上限
    private Double bottom_limit;//取值下限
    private Double score;//单项评分

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getRule_id() {
        return rule_id;
    }

    public void setRule_id(String rule_id) {
        this.rule_id = rule_id;
    }

    public String getStandard_id() {
        return standard_id;
    }

    public void setStandard_id(String standard_id) {
        this.standard_id = standard_id;
    }

    public String getReferrence() {
        return referrence;
    }

    public void setReferrence(String referrence) {
        this.referrence = referrence;
    }

    public Double getTop_limit() {
        return top_limit;
    }

    public void setTop_limit(Double top_limit) {
        this.top_limit = top_limit;
    }

    public Double getBottom_limit() {
        return bottom_limit;
    }

    public void setBottom_limit(Double bottom_limit) {
        this.bottom_limit = bottom_limit;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
