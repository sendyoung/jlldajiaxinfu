package jll.model.apply_evaluate;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 组织评级规则
 * */
@Entity(name="eva_rate_rule")
public class RateRule extends Base_Model {
    private String rate_rule_id;
    private String auth_org_id;//组织ID
    private String rank_code;//等级名称
    private Double score_bottom;//分值下限
    private Double score_top;//分值上限

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getRate_rule_id() {
        return rate_rule_id;
    }

    public void setRate_rule_id(String rate_rule_id) {
        this.rate_rule_id = rate_rule_id;
    }

    public String getAuth_org_id() {
        return auth_org_id;
    }

    public void setAuth_org_id(String auth_org_id) {
        this.auth_org_id = auth_org_id;
    }

    public String getRank_code() {
        return rank_code;
    }

    public void setRank_code(String rank_code) {
        this.rank_code = rank_code;
    }

    public Double getScore_bottom() {
        return score_bottom;
    }

    public void setScore_bottom(Double score_bottom) {
        this.score_bottom = score_bottom;
    }

    public Double getScore_top() {
        return score_top;
    }

    public void setScore_top(Double score_top) {
        this.score_top = score_top;
    }
}
