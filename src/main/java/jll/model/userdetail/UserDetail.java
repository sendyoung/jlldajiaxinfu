package jll.model.userdetail;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 用户详情信息表
 */
@Entity(name="org_user_detail")
public class UserDetail extends Base_Model {

    private String user_detail_id;//主键

    private String  corresponding_address;//通讯地址
    private String  emergency_contact;//紧急联系人
    private String home_address;//家庭住址
    private String emergency_contact_tel;//紧急联系人电话
    private String registered_residence_address;//户口地址
    private String marriage;//婚姻
    private String political_outlook;//政治面貌
    private String social_groups;//社会团体
    private int weight;//体重
    private int height;//身高
    private String blood_type;//血型
    private String nation;//民族
    private Date birthday;//生日
    //private String realname;//真实姓名
    //private String idcard;//身份证号

    @Id
    @GenericGenerator(name = "systemUUID", strategy = "uuid")
    @GeneratedValue(generator = "systemUUID")
    public String getUser_detail_id() {
        return user_detail_id;
    }

    public void setUser_detail_id(String user_detail_id) {
        this.user_detail_id = user_detail_id;
    }

    public String getCorresponding_address() {
        return corresponding_address;
    }

    public void setCorresponding_address(String corresponding_address) {
        this.corresponding_address = corresponding_address;
    }

    public String getEmergency_contact() {
        return emergency_contact;
    }

    public void setEmergency_contact(String emergency_contact) {
        this.emergency_contact = emergency_contact;
    }

    public String getHome_address() {
        return home_address;
    }

    public void setHome_address(String home_address) {
        this.home_address = home_address;
    }

    public String getEmergency_contact_tel() {
        return emergency_contact_tel;
    }

    public void setEmergency_contact_tel(String emergency_contact_tel) {
        this.emergency_contact_tel = emergency_contact_tel;
    }

    public String getRegistered_residence_address() {
        return registered_residence_address;
    }

    public void setRegistered_residence_address(String registered_residence_address) {
        this.registered_residence_address = registered_residence_address;
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    public String getPolitical_outlook() {
        return political_outlook;
    }

    public void setPolitical_outlook(String political_outlook) {
        this.political_outlook = political_outlook;
    }

    public String getSocial_groups() {
        return social_groups;
    }

    public void setSocial_groups(String social_groups) {
        this.social_groups = social_groups;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getBlood_type() {
        return blood_type;
    }

    public void setBlood_type(String blood_type) {
        this.blood_type = blood_type;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

}