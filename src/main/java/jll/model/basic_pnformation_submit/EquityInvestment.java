package jll.model.basic_pnformation_submit;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 股权投资
 */
@Entity(name = "ent_equity_investment")
public class EquityInvestment extends Base_Model {
    // 主键
    private String id;
    // 企业id
    private String ent_id;
    // 被投资企业名称
    private String by_name_invested_enterprise;
    // 被投资企业法定代表人
    private String by_legal_representative_investment_enterprise;
    // 注册资本
    private String registered_capital;
    // 出资比例
    private String ratio_of_investments;
    // 成立时间
    private Date date_establishment;
    // 是否并表
    private String whether_and_table;


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

    public String getBy_name_invested_enterprise() {
        return by_name_invested_enterprise;
    }

    public void setBy_name_invested_enterprise(String by_name_invested_enterprise) {
        this.by_name_invested_enterprise = by_name_invested_enterprise;
    }

    public String getBy_legal_representative_investment_enterprise() {
        return by_legal_representative_investment_enterprise;
    }

    public void setBy_legal_representative_investment_enterprise(String by_legal_representative_investment_enterprise) {
        this.by_legal_representative_investment_enterprise = by_legal_representative_investment_enterprise;
    }

    public String getRegistered_capital() {
        return registered_capital;
    }

    public void setRegistered_capital(String registered_capital) {
        this.registered_capital = registered_capital;
    }

    public String getRatio_of_investments() {
        return ratio_of_investments;
    }

    public void setRatio_of_investments(String ratio_of_investments) {
        this.ratio_of_investments = ratio_of_investments;
    }

    public Date getDate_establishment() {
        return date_establishment;
    }

    public void setDate_establishment(Date date_establishment) {
        this.date_establishment = date_establishment;
    }

    public String getWhether_and_table() {
        return whether_and_table;
    }

    public void setWhether_and_table(String whether_and_table) {
        this.whether_and_table = whether_and_table;
    }
}
