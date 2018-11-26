package jll.model.BasicPnformationSubmit;


import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 债权投资
 */
@Entity(name = "ent_creditor_rights_investment")
public class CreditorRightsInvestment extends Base_Model {
    // 主键
    private String id;
    // 企业id
    private String ent_id;
    // 购买时间
    private Date purchasing_date;
    // 发行时间
    private Date issue_date;
    // 债券名称
    private String name_bond;
    // 债券代码
    private String bond_code;
    // 发债主体
    private String issuance_subject;
    // 债券类型
    private String bond_type;
    // 最新评级
    private String latest_rating;
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

    public Date getPurchasing_date() {
        return purchasing_date;
    }

    public void setPurchasing_date(Date purchasing_date) {
        this.purchasing_date = purchasing_date;
    }

    public Date getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(Date issue_date) {
        this.issue_date = issue_date;
    }

    public String getName_bond() {
        return name_bond;
    }

    public void setName_bond(String name_bond) {
        this.name_bond = name_bond;
    }

    public String getBond_code() {
        return bond_code;
    }

    public void setBond_code(String bond_code) {
        this.bond_code = bond_code;
    }

    public String getIssuance_subject() {
        return issuance_subject;
    }

    public void setIssuance_subject(String issuance_subject) {
        this.issuance_subject = issuance_subject;
    }

    public String getBond_type() {
        return bond_type;
    }

    public void setBond_type(String bond_type) {
        this.bond_type = bond_type;
    }

    public String getLatest_rating() {
        return latest_rating;
    }

    public void setLatest_rating(String latest_rating) {
        this.latest_rating = latest_rating;
    }
}
