package jll.model.apply_evaluate;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 申请评价权限
 * */
@Entity(name="eva_apply_permission")
public class ApplyPermission extends Base_Model {
    private String apply_permission_id;
    private String name;//名称
    private String parent_id;//父级ID

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getApply_permission_id() {
        return apply_permission_id;
    }

    public void setApply_permission_id(String apply_permission_id) {
        this.apply_permission_id = apply_permission_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }
}
