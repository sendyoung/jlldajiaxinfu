package jll.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 权限组表
 */
@Entity(name = "org_user_permission_group")
public class User_Permission_Group extends
        Base_Model {

    /**
     * 主键id
     */
    private String permission_grpup_id;

    /**
     * 权限组名称
     */
    private String group_name;

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getPermission_grpup_id() {
        return permission_grpup_id;
    }

    public void setPermission_grpup_id(String permission_grpup_id) {
        this.permission_grpup_id = permission_grpup_id;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }
}
