package jll.model.OrgOrganization;


import org.hibernate.annotations.GenericGenerator;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 组织机构
 */
@Entity(name = "org_structure")
public class Structure {
    // 主键
    private String org_structure_id;
    // 组织认证信息id
    private String auth_org_id;
    // 创建时间
    private Date create_time;
    // 职能层级
    private String pid;
    // 联系电话
    private String iphone;
    // 主要负责人
    private String principal_pesponsible_person;
    // 主要职责
    private String main_responsibilities;
    // 职能名称
    private String name;
    // 更新时间
    private String update_time;
    // 是否删除   1删除   0未删除   默认为0
    private String is_delete;
    // 备注
    private String comment;

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getOrg_structure_id() {
        return org_structure_id;
    }

    public void setOrg_structure_id(String org_structure_id) {
        this.org_structure_id = org_structure_id;
    }

    public String getAuth_org_id() {
        return auth_org_id;
    }

    public void setAuth_org_id(String auth_org_id) {
        this.auth_org_id = auth_org_id;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getIphone() {
        return iphone;
    }

    public void setIphone(String iphone) {
        this.iphone = iphone;
    }

    public String getPrincipal_pesponsible_person() {
        return principal_pesponsible_person;
    }

    public void setPrincipal_pesponsible_person(String principal_pesponsible_person) {
        this.principal_pesponsible_person = principal_pesponsible_person;
    }

    public String getMain_responsibilities() {
        return main_responsibilities;
    }

    public void setMain_responsibilities(String main_responsibilities) {
        this.main_responsibilities = main_responsibilities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public String getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(String is_delete) {
        this.is_delete = is_delete;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
