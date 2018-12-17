package jll.model.data_list;

import jll.model.InformationPrivided;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 员工信息
 * */
@Entity(name="ent_employee")
public class Employee extends InformationPrivided {
    private String employee_id;
    private String name;//姓名
    private String gender;//性别：男，女
    private String nation;//民族
    private Float height;//身高cm
    private Float weight;//体重kg
    private String blood_type;//血型
    private Date birth_date;//出生日期
    private String political_status;//政治面貌
    private String social_group;//社会团体
    private String marital_status;//婚姻状况
    private String identity_card_no;//身份证号
    private String registered_residence;//户口所在地
    private String contact_tel;//联系电话
    private String email;//邮箱
    private String family_address;//家庭住址
    private String contact_address;//通讯地址
    private String contact_name;//紧急联系人
    private String contact_phone;//紧急联系人电话
    private String edu_background;//学历： 初中 高中 中专  大专 本科  硕士研究生 博士研究生
    private String edu_degree;//学位：学士 硕士 博士
    private String edu_graduate_school;//毕业学校
    private Date edu_graduate_date;//毕业时间
    private String edu_graduate_major;//主修专业
    private String language_ability;//语言水平
    private String other_language_ability;//其他语言水平
    private String computer_ability;//计算机能力
    private String others_certificate;//其他证书
    private String dept_name;//部门
    private String duty;//职务岗位
    private String professional_title;//职称：1、初级2、中级3、高级
    private String stype;//员工类型： 0、高管（其他高层管理者）1、普通员工2、企业负责人 3、技术负责人4、中层管理者
    private String superior;//直接上级领导
    private Float pay_annual_salary;//年薪（元）
    private Float pay_social_insurance;//社保（元）
    private Float pay_housing_fund;//公积金（元）
    private Float pay_commerce_insurance;//商业保险（元）
    private Float pay_annuity;//年金（元）
    private Date work_date;//参加工作时间
    private Integer work_industry_year;//本行业工作年限
    private Date join_date;//入司时间

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public String getBlood_type() {
        return blood_type;
    }

    public void setBlood_type(String blood_type) {
        this.blood_type = blood_type;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public String getPolitical_status() {
        return political_status;
    }

    public void setPolitical_status(String political_status) {
        this.political_status = political_status;
    }

    public String getSocial_group() {
        return social_group;
    }

    public void setSocial_group(String social_group) {
        this.social_group = social_group;
    }

    public String getMarital_status() {
        return marital_status;
    }

    public void setMarital_status(String marital_status) {
        this.marital_status = marital_status;
    }

    public String getIdentity_card_no() {
        return identity_card_no;
    }

    public void setIdentity_card_no(String identity_card_no) {
        this.identity_card_no = identity_card_no;
    }

    public String getRegistered_residence() {
        return registered_residence;
    }

    public void setRegistered_residence(String registered_residence) {
        this.registered_residence = registered_residence;
    }

    public String getContact_tel() {
        return contact_tel;
    }

    public void setContact_tel(String contact_tel) {
        this.contact_tel = contact_tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFamily_address() {
        return family_address;
    }

    public void setFamily_address(String family_address) {
        this.family_address = family_address;
    }

    public String getContact_address() {
        return contact_address;
    }

    public void setContact_address(String contact_address) {
        this.contact_address = contact_address;
    }

    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    public String getContact_phone() {
        return contact_phone;
    }

    public void setContact_phone(String contact_phone) {
        this.contact_phone = contact_phone;
    }

    public String getEdu_background() {
        return edu_background;
    }

    public void setEdu_background(String edu_background) {
        this.edu_background = edu_background;
    }

    public String getEdu_degree() {
        return edu_degree;
    }

    public void setEdu_degree(String edu_degree) {
        this.edu_degree = edu_degree;
    }

    public String getEdu_graduate_school() {
        return edu_graduate_school;
    }

    public void setEdu_graduate_school(String edu_graduate_school) {
        this.edu_graduate_school = edu_graduate_school;
    }

    public Date getEdu_graduate_date() {
        return edu_graduate_date;
    }

    public void setEdu_graduate_date(Date edu_graduate_date) {
        this.edu_graduate_date = edu_graduate_date;
    }

    public String getEdu_graduate_major() {
        return edu_graduate_major;
    }

    public void setEdu_graduate_major(String edu_graduate_major) {
        this.edu_graduate_major = edu_graduate_major;
    }

    public String getLanguage_ability() {
        return language_ability;
    }

    public void setLanguage_ability(String language_ability) {
        this.language_ability = language_ability;
    }

    public String getOther_language_ability() {
        return other_language_ability;
    }

    public void setOther_language_ability(String other_language_ability) {
        this.other_language_ability = other_language_ability;
    }

    public String getComputer_ability() {
        return computer_ability;
    }

    public void setComputer_ability(String computer_ability) {
        this.computer_ability = computer_ability;
    }

    public String getOthers_certificate() {
        return others_certificate;
    }

    public void setOthers_certificate(String others_certificate) {
        this.others_certificate = others_certificate;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getProfessional_title() {
        return professional_title;
    }

    public void setProfessional_title(String professional_title) {
        this.professional_title = professional_title;
    }

    public String getStype() {
        return stype;
    }

    public void setStype(String stype) {
        this.stype = stype;
    }

    public String getSuperior() {
        return superior;
    }

    public void setSuperior(String superior) {
        this.superior = superior;
    }

    public Float getPay_annual_salary() {
        return pay_annual_salary;
    }

    public void setPay_annual_salary(Float pay_annual_salary) {
        this.pay_annual_salary = pay_annual_salary;
    }

    public Float getPay_social_insurance() {
        return pay_social_insurance;
    }

    public void setPay_social_insurance(Float pay_social_insurance) {
        this.pay_social_insurance = pay_social_insurance;
    }

    public Float getPay_housing_fund() {
        return pay_housing_fund;
    }

    public void setPay_housing_fund(Float pay_housing_fund) {
        this.pay_housing_fund = pay_housing_fund;
    }

    public Float getPay_commerce_insurance() {
        return pay_commerce_insurance;
    }

    public void setPay_commerce_insurance(Float pay_commerce_insurance) {
        this.pay_commerce_insurance = pay_commerce_insurance;
    }

    public Float getPay_annuity() {
        return pay_annuity;
    }

    public void setPay_annuity(Float pay_annuity) {
        this.pay_annuity = pay_annuity;
    }

    public Date getWork_date() {
        return work_date;
    }

    public void setWork_date(Date work_date) {
        this.work_date = work_date;
    }

    public Integer getWork_industry_year() {
        return work_industry_year;
    }

    public void setWork_industry_year(Integer work_industry_year) {
        this.work_industry_year = work_industry_year;
    }

    public Date getJoin_date() {
        return join_date;
    }

    public void setJoin_date(Date join_date) {
        this.join_date = join_date;
    }
}
