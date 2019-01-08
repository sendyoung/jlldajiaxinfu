package jll.model.basic_pnformation_submit;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 股权出质登记信息
 */
@Entity(name = "ent_share_pledge_registration")
public class SharePledgeRegistration extends Base_Model {
    // 主键
    private String id;
    // 企业id
    private String ent_id;
    // 登记序号
    private String registration_number;
    // 出质人
    private String pledgor;
    // 出质人 证照/证件号码
    private String pledgor_id_number;
    // 出质股权数额
    private String amount_of_pledged_shares;
    // 质权人
    private String pledgee;
    // 质权人 证照/证件号码
    private String pledgee_id_number;
    // 状态
    private String status;
    // 公示日期
    private Date public_date;

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

    public String getRegistration_number() {
        return registration_number;
    }

    public void setRegistration_number(String registration_number) {
        this.registration_number = registration_number;
    }

    public String getPledgor() {
        return pledgor;
    }

    public void setPledgor(String pledgor) {
        this.pledgor = pledgor;
    }

    public String getPledgor_id_number() {
        return pledgor_id_number;
    }

    public void setPledgor_id_number(String pledgor_id_number) {
        this.pledgor_id_number = pledgor_id_number;
    }

    public String getAmount_of_pledged_shares() {
        return amount_of_pledged_shares;
    }

    public void setAmount_of_pledged_shares(String amount_of_pledged_shares) {
        this.amount_of_pledged_shares = amount_of_pledged_shares;
    }

    public String getPledgee() {
        return pledgee;
    }

    public void setPledgee(String pledgee) {
        this.pledgee = pledgee;
    }

    public String getPledgee_id_number() {
        return pledgee_id_number;
    }

    public void setPledgee_id_number(String pledgee_id_number) {
        this.pledgee_id_number = pledgee_id_number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getPublic_date() {
        return public_date;
    }

    public void setPublic_date(Date public_date) {
        this.public_date = public_date;
    }
}
