package jll.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 角色与权限中间表
 */
@Entity(name = "org_group_permission_middle")
public class Group_Permission_Middle extends Base_Model {

    /**
     * 主键
     */
    private String group_permission_middle_id;

    /**
     * 权限表id
     */
    private String permission_id;

    /**
     * 角色id
     */
    private String role_id;

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getGroup_permission_middle_id() {
        return group_permission_middle_id;
    }

    public void setGroup_permission_middle_id(String group_permission_middle_id) {
        this.group_permission_middle_id = group_permission_middle_id;
    }

    public String getPermission_id() {
        return permission_id;
    }

    public void setPermission_id(String permission_id) {
        this.permission_id = permission_id;
    }

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }
}
