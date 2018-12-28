package jll.model.userdetail;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 教育经历
 */
@Entity(name="org_user_education")
public class UserEducation extends Base_Model {
    private String user_education_id;//主键
    private String user_id;//用户主键
    private String languages;//语言种类
    private String languages_level;//语言水平
    private String computer_level;// 计算机水平
    private String certificate;// 证书
    private String education;// 学历
    private String school_name;// 学校名称
    private Date graduation_date;// 毕业时间
    private String main_major;//主修专业
    private String auxiliary_major;//辅修专业

    @Id
    @GenericGenerator(name = "systemUUID", strategy = "uuid")
    @GeneratedValue(generator = "systemUUID")
    public String getUser_education_id() {
        return user_education_id;
    }

    public void setUser_education_id(String user_education_id) {
        this.user_education_id = user_education_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getLanguages_level() {
        return languages_level;
    }

    public void setLanguages_level(String languages_level) {
        this.languages_level = languages_level;
    }

    public String getComputer_level() {
        return computer_level;
    }

    public void setComputer_level(String computer_level) {
        this.computer_level = computer_level;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public Date getGraduation_date() {
        return graduation_date;
    }

    public void setGraduation_date(Date graduation_date) {
        this.graduation_date = graduation_date;
    }

    public String getMain_major() {
        return main_major;
    }

    public void setMain_major(String main_major) {
        this.main_major = main_major;
    }

    public String getAuxiliary_major() {
        return auxiliary_major;
    }

    public void setAuxiliary_major(String auxiliary_major) {
        this.auxiliary_major = auxiliary_major;
    }
}
