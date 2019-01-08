package jll.model.basic_pnformation_submit;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 股东出资信息填报
 */
@Entity(name = "ent_shareholder_contribution")
public class ShareholderContributionInfo extends Base_Model{
    // 主键
    private String id;
    // 企业id
    private String ent_id;
    // 股东名称
    private String shareholder;
    // 持股比例
    private String shareholding_ratio;
    // 认缴出资额
    private String subscribed_capital_contribution;
    // 股东类型
    private String shareholder_type;
    //证件类型
    private String papers_type;
    // 护照/证件号码
    private String passport;
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

    public String getShareholder() {
        return shareholder;
    }

    public void setShareholder(String shareholder) {
        this.shareholder = shareholder;
    }

    public String getShareholding_ratio() {
        return shareholding_ratio;
    }

    public void setShareholding_ratio(String shareholding_ratio) {
        this.shareholding_ratio = shareholding_ratio;
    }

    public String getSubscribed_capital_contribution() {
        return subscribed_capital_contribution;
    }

    public void setSubscribed_capital_contribution(String subscribed_capital_contribution) {
        this.subscribed_capital_contribution = subscribed_capital_contribution;
    }

    public String getShareholder_type() {
        return shareholder_type;
    }

    public void setShareholder_type(String shareholder_type) {
        this.shareholder_type = shareholder_type;
    }

    public String getPapers_type() {
        return papers_type;
    }

    public void setPapers_type(String papers_type) {
        this.papers_type = papers_type;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }
}
