package jll.model.basic_pnformation_submit;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 主体信用评价
 */
@Entity(name = "ent_subjectCredit_evaluation")
public class SubjectCreditEvaluation extends Base_Model {

    // 主键
    private String id;
    // 企业id
    private String ent_id;
    // 发布日期
    private String release_date;
    // 评级年度
    private String rating_year;
    //评级公司
    private String rating_firms;
    //评级结果
    private String rating_results;
    // 评级展望
    private String outlook;
    //信用级别是否调整
    private int credit_rating_adjusted;

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEnt_id() {
        return ent_id;
    }

    public void setEnt_id(String ent_id) {
        this.ent_id = ent_id;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getRating_year() {
        return rating_year;
    }

    public void setRating_year(String rating_year) {
        this.rating_year = rating_year;
    }

    public String getRating_firms() {
        return rating_firms;
    }

    public void setRating_firms(String rating_firms) {
        this.rating_firms = rating_firms;
    }

    public String getRating_results() {
        return rating_results;
    }

    public void setRating_results(String rating_results) {
        this.rating_results = rating_results;
    }

    public String getOutlook() {
        return outlook;
    }

    public void setOutlook(String outlook) {
        this.outlook = outlook;
    }

    public int getCredit_rating_adjusted() {
        return credit_rating_adjusted;
    }

    public void setCredit_rating_adjusted(int credit_rating_adjusted) {
        this.credit_rating_adjusted = credit_rating_adjusted;
    }
}
