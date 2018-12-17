package jll.model.BasicPnformationSubmit;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 联系人员填报
 */
@Entity(name = "ent_contact_personnel")
public class ContactPersonnel extends Base_Model {
    // 主键
    private String id;
    // 企业id
    private String ent_id;
    //姓名
    private String name;
    // 职务
    private String contact_personnel;
    //电话
    private String shareholder_type;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact_personnel() {
        return contact_personnel;
    }

    public void setContact_personnel(String contact_personnel) {
        this.contact_personnel = contact_personnel;
    }

    public String getShareholder_type() {
        return shareholder_type;
    }

    public void setShareholder_type(String shareholder_type) {
        this.shareholder_type = shareholder_type;
    }
}
