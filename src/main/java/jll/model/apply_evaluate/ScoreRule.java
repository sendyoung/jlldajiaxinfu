package jll.model.apply_evaluate;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 评分规则
 * */
@Entity(name = "eva_score_rule")
public class ScoreRule extends Base_Model {
    private String score_rule_id;
    private String rule_name;//评分名称
    private Double score;//记录分数
    private String auth_org_id;//组织Id

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getScore_rule_id() {
        return score_rule_id;
    }

    public void setScore_rule_id(String score_rule_id) {
        this.score_rule_id = score_rule_id;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getAuth_org_id() {
        return auth_org_id;
    }

    public void setAuth_org_id(String auth_org_id) {
        this.auth_org_id = auth_org_id;
    }

    public String getRule_name() {
        return rule_name;
    }

    public void setRule_name(String rule_name) {
        this.rule_name = rule_name;
    }
}
