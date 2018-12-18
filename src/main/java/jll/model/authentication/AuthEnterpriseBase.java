package jll.model.authentication;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 企业认证
 */
@Entity(name="auth_enterprise_base")
public class AuthEnterpriseBase extends Base_Model {
    private String auth_enterprise_id;//主键
    private String enterprise_logo;//企业logo
    private String enterprise_address;//企业地址
    private String enterprise_website;//网址
    private String enterprise_tel;//企业电话
    private String enterprise_email;//企业邮箱
    private String enterprise_introduction;//企业介绍
    private String business_scope;//经营范围
    private String business_license_imager;//营业执照照片
    private String just_idcard_imager;// 身份证照片正面
    private String back_idcard_imager;// 身份证照片背面
    private String legal_idcard;// 法定代表人身份证号
    private String registration_authority;//登记机关
    private String residence;//住所
    private Date end_date;// 有效截止日期
    private Date level_registration_start_date;//登记注册日期
    private int types_enterprises;// 企业类型
    private Date date_establishment;//成立日期
    private double registered_capital;//注册资本
    private String legal_representative;//法定代表人
    private String enterprise_name;//企业名称
    private String social_credit_code;//社会信用代码

    @Id
    @GenericGenerator(name = "systemUUID", strategy = "uuid")
    @GeneratedValue(generator = "systemUUID")
    public String getAuth_enterprise_id() {
        return auth_enterprise_id;
    }

    public void setAuth_enterprise_id(String auth_enterprise_id) {
        this.auth_enterprise_id = auth_enterprise_id;
    }

    public String getEnterprise_logo() {
        return enterprise_logo;
    }

    public void setEnterprise_logo(String enterprise_logo) {
        this.enterprise_logo = enterprise_logo;
    }

    public String getEnterprise_address() {
        return enterprise_address;
    }

    public void setEnterprise_address(String enterprise_address) {
        this.enterprise_address = enterprise_address;
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

    public String getEnterprise_email() {
        return enterprise_email;
    }

    public void setEnterprise_email(String enterprise_email) {
        this.enterprise_email = enterprise_email;
    }

    public String getEnterprise_introduction() {
        return enterprise_introduction;
    }

    public void setEnterprise_introduction(String enterprise_introduction) {
        this.enterprise_introduction = enterprise_introduction;
    }

    public String getBusiness_scope() {
        return business_scope;
    }

    public void setBusiness_scope(String business_scope) {
        this.business_scope = business_scope;
    }

    public String getBusiness_license_imager() {
        return business_license_imager;
    }

    public void setBusiness_license_imager(String business_license_imager) {
        this.business_license_imager = business_license_imager;
    }

    public String getJust_idcard_imager() {
        return just_idcard_imager;
    }

    public void setJust_idcard_imager(String just_idcard_imager) {
        this.just_idcard_imager = just_idcard_imager;
    }

    public String getBack_idcard_imager() {
        return back_idcard_imager;
    }

    public void setBack_idcard_imager(String back_idcard_imager) {
        this.back_idcard_imager = back_idcard_imager;
    }

    public String getLegal_idcard() {
        return legal_idcard;
    }

    public void setLegal_idcard(String legal_idcard) {
        this.legal_idcard = legal_idcard;
    }

    public String getRegistration_authority() {
        return registration_authority;
    }

    public void setRegistration_authority(String registration_authority) {
        this.registration_authority = registration_authority;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public Date getLevel_registration_start_date() {
        return level_registration_start_date;
    }

    public void setLevel_registration_start_date(Date level_registration_start_date) {
        this.level_registration_start_date = level_registration_start_date;
    }

    public int getTypes_enterprises() {
        return types_enterprises;
    }

    public void setTypes_enterprises(int types_enterprises) {
        this.types_enterprises = types_enterprises;
    }

    public Date getDate_establishment() {
        return date_establishment;
    }

    public void setDate_establishment(Date date_establishment) {
        this.date_establishment = date_establishment;
    }

    public double getRegistered_capital() {
        return registered_capital;
    }

    public void setRegistered_capital(double registered_capital) {
        this.registered_capital = registered_capital;
    }

    public String getLegal_representative() {
        return legal_representative;
    }

    public void setLegal_representative(String legal_representative) {
        this.legal_representative = legal_representative;
    }

    public String getEnterprise_name() {
        return enterprise_name;
    }

    public void setEnterprise_name(String enterprise_name) {
        this.enterprise_name = enterprise_name;
    }

    public String getSocial_credit_code() {
        return social_credit_code;
    }

    public void setSocial_credit_code(String social_credit_code) {
        this.social_credit_code = social_credit_code;
    }
}
