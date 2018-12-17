package jll.model.BasicPnformationSubmit;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 社保方面
 */
@Entity(name = "ent_social_security")
public class SocialSecurity extends Base_Model {
    // 主键
    private String id;
    // 企业id
    private String ent_id;
    // 类型
    private String type;
    // 年份
    private String year;
    // 城镇职工基本养老保险
    private String basic_endowment_insurance;
    // 职工基本医疗保险
    private String medical_insurance;
    // 生育保险
    private String birth_insurance;
    // 工伤保险
    private String inductrial_injury_insurance;
    // 失业保险
    private String unemployment_insurance;
    // 合计
    private String combined;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getBasic_endowment_insurance() {
        return basic_endowment_insurance;
    }

    public void setBasic_endowment_insurance(String basic_endowment_insurance) {
        this.basic_endowment_insurance = basic_endowment_insurance;
    }

    public String getMedical_insurance() {
        return medical_insurance;
    }

    public void setMedical_insurance(String medical_insurance) {
        this.medical_insurance = medical_insurance;
    }

    public String getBirth_insurance() {
        return birth_insurance;
    }

    public void setBirth_insurance(String birth_insurance) {
        this.birth_insurance = birth_insurance;
    }

    public String getInductrial_injury_insurance() {
        return inductrial_injury_insurance;
    }

    public void setInductrial_injury_insurance(String inductrial_injury_insurance) {
        this.inductrial_injury_insurance = inductrial_injury_insurance;
    }

    public String getUnemployment_insurance() {
        return unemployment_insurance;
    }

    public void setUnemployment_insurance(String unemployment_insurance) {
        this.unemployment_insurance = unemployment_insurance;
    }

    public String getCombined() {
        return combined;
    }

    public void setCombined(String combined) {
        this.combined = combined;
    }
}