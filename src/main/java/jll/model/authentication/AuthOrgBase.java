package jll.model.authentication;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 组织认证表
 */
@Entity(name="auth_org_base ")
public class AuthOrgBase extends Base_Model {
    private String auth_org_id;//主键
    private Date rule_date;//审核时间规则期限
    private String org_information_id;//     组织id
    private String enterprise_introduction;//企业介绍
    private String enterprise_email;//       企业邮箱
    private String enterprise_website;//     企业网址
    private String enterprise_tel;//         企业电话
    private String enterprise_address;//     企业地址
    private String scope_business;//         业务范围
    private String residence;//              住所
    private String legal_idcard_just_imager;//法定身份证正面
    private String legal_idcard_back_imager;//法定身份证反面
    private String legal_repersentative_idcard;//法定代表人登记证书
    private String registration_certificate_imarge;//  登记证书
    private String certification_authority;//   发证机关
    private String organization_name;//     组织名称
    private String social_credit_code;//    社会信用代码
    private String legal_representative;//  法定代表人
    private double registered_capital;//    注册资本
    private Date issue_date;//          发证日期
    private String activity_area;//       活动区域
    private Date validity_start_date;// 有效期开始时间
    private Date validity_end_date;//   有效期结束时间

    @Id
    @GenericGenerator(name = "systemUUID", strategy = "uuid")
    @GeneratedValue(generator = "systemUUID")
    public String getAuth_org_id() {
        return auth_org_id;
    }

    public void setAuth_org_id(String auth_org_id) {
        this.auth_org_id = auth_org_id;
    }

    public Date getRule_date() {
        return rule_date;
    }

    public void setRule_date(Date rule_date) {
        this.rule_date = rule_date;
    }

    public String getOrg_information_id() {
        return org_information_id;
    }

    public void setOrg_information_id(String org_information_id) {
        this.org_information_id = org_information_id;
    }

    public String getEnterprise_introduction() {
        return enterprise_introduction;
    }

    public void setEnterprise_introduction(String enterprise_introduction) {
        this.enterprise_introduction = enterprise_introduction;
    }

    public String getEnterprise_email() {
        return enterprise_email;
    }

    public void setEnterprise_email(String enterprise_email) {
        this.enterprise_email = enterprise_email;
    }

    public String getEnterprise_website() {
        return enterprise_website;
    }

    public void setEnterprise_website(String enterprise_website) {
        this.enterprise_website = enterprise_website;
    }

    public String getEnterprise_tel() {
        return enterprise_tel;
    }

    public void setEnterprise_tel(String enterprise_tel) {
        this.enterprise_tel = enterprise_tel;
    }

    public String getEnterprise_address() {
        return enterprise_address;
    }

    public void setEnterprise_address(String enterprise_address) {
        this.enterprise_address = enterprise_address;
    }

    public String getScope_business() {
        return scope_business;
    }

    public void setScope_business(String scope_business) {
        this.scope_business = scope_business;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getLegal_idcard_just_imager() {
        return legal_idcard_just_imager;
    }

    public void setLegal_idcard_just_imager(String legal_idcard_just_imager) {
        this.legal_idcard_just_imager = legal_idcard_just_imager;
    }

    public String getLegal_idcard_back_imager() {
        return legal_idcard_back_imager;
    }

    public void setLegal_idcard_back_imager(String legal_idcard_back_imager) {
        this.legal_idcard_back_imager = legal_idcard_back_imager;
    }

    public String getLegal_repersentative_idcard() {
        return legal_repersentative_idcard;
    }

    public void setLegal_repersentative_idcard(String legal_repersentative_idcard) {
        this.legal_repersentative_idcard = legal_repersentative_idcard;
    }

    public String getRegistration_certificate_imarge() {
        return registration_certificate_imarge;
    }

    public void setRegistration_certificate_imarge(String registration_certificate_imarge) {
        this.registration_certificate_imarge = registration_certificate_imarge;
    }

    public String getCertification_authority() {
        return certification_authority;
    }

    public void setCertification_authority(String certification_authority) {
        this.certification_authority = certification_authority;
    }

    public String getOrganization_name() {
        return organization_name;
    }

    public void setOrganization_name(String organization_name) {
        this.organization_name = organization_name;
    }

    public String getSocial_credit_code() {
        return social_credit_code;
    }

    public void setSocial_credit_code(String social_credit_code) {
        this.social_credit_code = social_credit_code;
    }

    public String getLegal_representative() {
        return legal_representative;
    }

    public void setLegal_representative(String legal_representative) {
        this.legal_representative = legal_representative;
    }

    public double getRegistered_capital() {
        return registered_capital;
    }

    public void setRegistered_capital(double registered_capital) {
        this.registered_capital = registered_capital;
    }

    public Date getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(Date issue_date) {
        this.issue_date = issue_date;
    }

    public String getActivity_area() {
        return activity_area;
    }

    public void setActivity_area(String activity_area) {
        this.activity_area = activity_area;
    }

    public Date getValidity_start_date() {
        return validity_start_date;
    }

    public void setValidity_start_date(Date validity_start_date) {
        this.validity_start_date = validity_start_date;
    }

    public Date getValidity_end_date() {
        return validity_end_date;
    }

    public void setValidity_end_date(Date validity_end_date) {
        this.validity_end_date = validity_end_date;
    }
}
