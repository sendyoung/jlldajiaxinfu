package jll.model.userdetail;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 用户家庭成员表
 */
@Entity(name="org_user_family_member")
public class UserFamily extends Base_Model {
    private String user_family_id;//  主键
    private String user_detail_id;//  用户详情表主键
    private String company_name;//     工作单位
    private String family_tel;// 		家庭联系人电话
    private String family_relationship;// 家庭成员关系
    private String family_name;//       家庭成员姓名

    @Id
    @GenericGenerator(name = "systemUUID", strategy = "uuid")
    @GeneratedValue(generator = "systemUUID")
    public String getUser_family_id() {
        return user_family_id;
    }

    public void setUser_family_id(String user_family_id) {
        this.user_family_id = user_family_id;
    }

    public String getUser_detail_id() {
        return user_detail_id;
    }

    public void setUser_detail_id(String user_detail_id) {
        this.user_detail_id = user_detail_id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getFamily_tel() {
        return family_tel;
    }

    public void setFamily_tel(String family_tel) {
        this.family_tel = family_tel;
    }

    public String getFamily_relationship() {
        return family_relationship;
    }

    public void setFamily_relationship(String family_relationship) {
        this.family_relationship = family_relationship;
    }

    public String getFamily_name() {
        return family_name;
    }

    public void setFamily_name(String family_name) {
        this.family_name = family_name;
    }
}
