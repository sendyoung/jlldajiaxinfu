package jll.model.basic_pnformation_submit;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 实际控制人填报
 */
@Entity(name = "ent_actual_controller")
public class ActualController extends Base_Model {
    // 主键
    private String id;
    // 企业id
    private String ent_id;
    // 实际控制人
    private String contact_personnel;
    //股东类型
    private String shareholder_type;
    //证照/证件类型
    private int id_type;
    // 证照/证件号码
    private String id_number;

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

    public int getId_type() {
        return id_type;
    }

    public void setId_type(int id_type) {
        this.id_type = id_type;
    }

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }
}
