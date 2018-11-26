package jll.model.BasicPnformationSubmit;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 海关注册信息
 */
@Entity(name = "ent_customs_registration")
public class CustomsRegistrationInformation extends Base_Model {
    // 主键
    private String id;
    // 企业id
    private String ent_id;
    // 注册海关
    private String the_customs_registration;
    // 行政区划
    private String administrative_division;
    // 经营类别
    private String business_category;
    // 海关注销标志
    private String cancellation_mark;
    // 注册日期
    private String registration_date;
    // 行业种类
    private String industry_types;
    // 海关注册编码
    private String customs_registration_code;
    // 经济区划
    private String division_of_economic_zones;
    // 特殊贸易区域
    private String special_trade_area;
    // 年报情况
    private String the_annual_report_of;
    // 报关有效期
    private String validity_of_declaration;
    // 跨境贸易电子商务类型
    private String types_of_e_commerce;
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

    public String getThe_customs_registration() {
        return the_customs_registration;
    }

    public void setThe_customs_registration(String the_customs_registration) {
        this.the_customs_registration = the_customs_registration;
    }

    public String getAdministrative_division() {
        return administrative_division;
    }

    public void setAdministrative_division(String administrative_division) {
        this.administrative_division = administrative_division;
    }

    public String getBusiness_category() {
        return business_category;
    }

    public void setBusiness_category(String business_category) {
        this.business_category = business_category;
    }

    public String getCancellation_mark() {
        return cancellation_mark;
    }

    public void setCancellation_mark(String cancellation_mark) {
        this.cancellation_mark = cancellation_mark;
    }

    public String getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(String registration_date) {
        this.registration_date = registration_date;
    }

    public String getIndustry_types() {
        return industry_types;
    }

    public void setIndustry_types(String industry_types) {
        this.industry_types = industry_types;
    }

    public String getCustoms_registration_code() {
        return customs_registration_code;
    }

    public void setCustoms_registration_code(String customs_registration_code) {
        this.customs_registration_code = customs_registration_code;
    }

    public String getDivision_of_economic_zones() {
        return division_of_economic_zones;
    }

    public void setDivision_of_economic_zones(String division_of_economic_zones) {
        this.division_of_economic_zones = division_of_economic_zones;
    }

    public String getSpecial_trade_area() {
        return special_trade_area;
    }

    public void setSpecial_trade_area(String special_trade_area) {
        this.special_trade_area = special_trade_area;
    }

    public String getThe_annual_report_of() {
        return the_annual_report_of;
    }

    public void setThe_annual_report_of(String the_annual_report_of) {
        this.the_annual_report_of = the_annual_report_of;
    }

    public String getValidity_of_declaration() {
        return validity_of_declaration;
    }

    public void setValidity_of_declaration(String validity_of_declaration) {
        this.validity_of_declaration = validity_of_declaration;
    }

    public String getTypes_of_e_commerce() {
        return types_of_e_commerce;
    }

    public void setTypes_of_e_commerce(String types_of_e_commerce) {
        this.types_of_e_commerce = types_of_e_commerce;
    }
}
