package jll.model.basic_pnformation_submit;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 自动化建设
 */
@Entity(name = "ent_automation_construction")
public class AutomationConstruction extends Base_Model {
    // 主键
    private String id;
    // 企业id
    private String ent_id;
    // 办公OA
    private String work_oa;
    // ERP系统软件
    private String erp_systems_software;

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

    public String getWork_oa() {
        return work_oa;
    }

    public void setWork_oa(String work_oa) {
        this.work_oa = work_oa;
    }

    public String getErp_systems_software() {
        return erp_systems_software;
    }

    public void setErp_systems_software(String erp_systems_software) {
        this.erp_systems_software = erp_systems_software;
    }
}
