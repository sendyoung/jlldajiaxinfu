package jll.model.data_list;


import jll.model.InformationPrivided;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 子公司
 * */
@Entity(name = "ent_subsidiary_company")
public class SubsidiaryCompany extends InformationPrivided {
    private String subsidiary_company_id;
    private String branch_name;//子公司名称
    private String industry_code;//所属行业代码
    private String regin_code;//所属区域代码
    private Date register_date;//成立日期
    private String representative;//法定代表人
    private String shares;//股份份额
    private Float taking;//营业收入
    private String taking_ratio;//分公司营业收入占公司总营业收入比例
    private Float net_margin;//净利润
    private String net_margin_ratio;//分公司净利润占公司总净利润比例
    private Integer claff_sum;//员工数
    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getSubsidiary_company_id() {
        return subsidiary_company_id;
    }

    public void setSubsidiary_company_id(String subsidiary_company_id) {
        this.subsidiary_company_id = subsidiary_company_id;
    }

    public String getBranch_name() {
        return branch_name;
    }

    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }

    public String getIndustry_code() {
        return industry_code;
    }

    public void setIndustry_code(String industry_code) {
        this.industry_code = industry_code;
    }

    public String getRegin_code() {
        return regin_code;
    }

    public void setRegin_code(String regin_code) {
        this.regin_code = regin_code;
    }

    public Date getRegister_date() {
        return register_date;
    }

    public void setRegister_date(Date register_date) {
        this.register_date = register_date;
    }

    public String getRepresentative() {
        return representative;
    }

    public void setRepresentative(String representative) {
        this.representative = representative;
    }

    public String getShares() {
        return shares;
    }

    public void setShares(String shares) {
        this.shares = shares;
    }

    public Float getTaking() {
        return taking;
    }

    public void setTaking(Float taking) {
        this.taking = taking;
    }

    public String getTaking_ratio() {
        return taking_ratio;
    }

    public void setTaking_ratio(String taking_ratio) {
        this.taking_ratio = taking_ratio;
    }

    public Float getNet_margin() {
        return net_margin;
    }

    public void setNet_margin(Float net_margin) {
        this.net_margin = net_margin;
    }

    public String getNet_margin_ratio() {
        return net_margin_ratio;
    }

    public void setNet_margin_ratio(String net_margin_ratio) {
        this.net_margin_ratio = net_margin_ratio;
    }

    public Integer getClaff_sum() {
        return claff_sum;
    }

    public void setClaff_sum(Integer claff_sum) {
        this.claff_sum = claff_sum;
    }
}
