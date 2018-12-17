package jll.model.data_list;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 家庭成员
 * */
@Entity(name="ent_family_info")
public class FamilyInfo extends Base_Model {
    private String family_info_id;//id
    private String employee_id;//员工ID
    private String relation;//关系
    private String duty;//职务
    private String phone;//电话

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getFamily_info_id() {
        return family_info_id;
    }

    public void setFamily_info_id(String family_info_id) {
        this.family_info_id = family_info_id;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }
}
