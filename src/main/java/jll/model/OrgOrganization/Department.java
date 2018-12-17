package jll.model.OrgOrganization;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 部门信息
 */
@Entity(name = "org_department")
public class Department {
    // 部门id
    private String org_department_id;
    // 部门表id
    private String org_structure_id;
    // 部门
    private String department;
    // 部门电话
    private String tel;
    // 部门email
    private String email;
    // 部门传真
    private String fax;
    // 邮编
    private String zip_code;
    // 主要负责人
    private String principal_responsible_person;
    // 项目地址
    private String postal_address;
    // 主要职责
    private String main_responsibilities;
    // 创建时间
    private Date create_time;
    // 更新时间
    private Date update_time;
    // 是否删除 1删除 0未删除 默认为0
    private String isDelete;
    // 备注
    private String comment;

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getOrg_department_id() {
        return org_department_id;
    }

    public void setOrg_department_id(String org_department_id) {
        this.org_department_id = org_department_id;
    }

    public String getOrg_structure_id() {
        return org_structure_id;
    }

    public void setOrg_structure_id(String org_structure_id) {
        this.org_structure_id = org_structure_id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public String getPrincipal_responsible_person() {
        return principal_responsible_person;
    }

    public void setPrincipal_responsible_person(String principal_responsible_person) {
        this.principal_responsible_person = principal_responsible_person;
    }

    public String getPostal_address() {
        return postal_address;
    }

    public void setPostal_address(String postal_address) {
        this.postal_address = postal_address;
    }

    public String getMain_responsibilities() {
        return main_responsibilities;
    }

    public void setMain_responsibilities(String main_responsibilities) {
        this.main_responsibilities = main_responsibilities;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
