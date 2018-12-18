package jll.model.enterprise;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 企业工商信息表
 */
@Entity(name="ent_basics")
public class EntBasics {
    private String ent_id;//主键(企业ID)
    private String company_introduce;//公司介绍
    private String business_scope;//经营范围
    private String product_sales_scope;//产品销售范围
    private String company_registration_address;//公司注册地址
    private Date approval_date;//核准日期
    private String registration_authority;//登记机关
    private String staff_num;//员工数量
    private Date date_of_establishment;//成立日期
    private String company_type;//公司类型
    private String industry;//所属行业
    private double registered_capital;//注册资本
    private double paid_in_capital;//实缴资本
    private String legal_representative;//法定代表人
    private String company_eng_name;//公司英文名称
    private String company_name;//公司名称
    private String unified_social_credit_code;//统一社会信用代码
    private String management_state;//经营状态

    @Id
    @GenericGenerator(name = "systemUUID", strategy = "uuid")
    @GeneratedValue(generator = "systemUUID")
    public String getEnt_id() {
        return ent_id;
    }

    public void setEnt_id(String ent_id) {
        this.ent_id = ent_id;
    }

    public String getCompany_introduce() {
        return company_introduce;
    }

    public void setCompany_introduce(String company_introduce) {
        this.company_introduce = company_introduce;
    }

    public String getBusiness_scope() {
        return business_scope;
    }

    public void setBusiness_scope(String business_scope) {
        this.business_scope = business_scope;
    }

    public String getProduct_sales_scope() {
        return product_sales_scope;
    }

    public void setProduct_sales_scope(String product_sales_scope) {
        this.product_sales_scope = product_sales_scope;
    }

    public String getCompany_registration_address() {
        return company_registration_address;
    }

    public void setCompany_registration_address(String company_registration_address) {
        this.company_registration_address = company_registration_address;
    }

    public Date getApproval_date() {
        return approval_date;
    }

    public void setApproval_date(Date approval_date) {
        this.approval_date = approval_date;
    }

    public String getRegistration_authority() {
        return registration_authority;
    }

    public void setRegistration_authority(String registration_authority) {
        this.registration_authority = registration_authority;
    }

    public String getStaff_num() {
        return staff_num;
    }

    public void setStaff_num(String staff_num) {
        this.staff_num = staff_num;
    }

    public Date getDate_of_establishment() {
        return date_of_establishment;
    }

    public void setDate_of_establishment(Date date_of_establishment) {
        this.date_of_establishment = date_of_establishment;
    }

    public String getCompany_type() {
        return company_type;
    }

    public void setCompany_type(String company_type) {
        this.company_type = company_type;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public double getRegistered_capital() {
        return registered_capital;
    }

    public void setRegistered_capital(double registered_capital) {
        this.registered_capital = registered_capital;
    }

    public double getPaid_in_capital() {
        return paid_in_capital;
    }

    public void setPaid_in_capital(double paid_in_capital) {
        this.paid_in_capital = paid_in_capital;
    }

    public String getLegal_representative() {
        return legal_representative;
    }

    public void setLegal_representative(String legal_representative) {
        this.legal_representative = legal_representative;
    }

    public String getCompany_eng_name() {
        return company_eng_name;
    }

    public void setCompany_eng_name(String company_eng_name) {
        this.company_eng_name = company_eng_name;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getUnified_social_credit_code() {
        return unified_social_credit_code;
    }

    public void setUnified_social_credit_code(String unified_social_credit_code) {
        this.unified_social_credit_code = unified_social_credit_code;
    }

    public String getManagement_state() {
        return management_state;
    }

    public void setManagement_state(String management_state) {
        this.management_state = management_state;
    }
}
