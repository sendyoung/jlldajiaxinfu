package jll.model.apply_evaluate;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 申请评价
 * */
@Entity(name = "eva_apply_evaluate")
public class ApplyEvaluate extends Base_Model {
    private String apply_evaluate_id;//申请评价ID
    private String ent_id;//企业ID
    private String org_id;//组织ID
    private String apply_status;//申请状态：
    private String audit_status;//审核状态
    private String appeal_status;//申诉状态
    private String title;//标题
    private String remarks;//备注批语

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getApply_evaluate_id() {
        return apply_evaluate_id;
    }

    public void setApply_evaluate_id(String apply_evaluate_id) {
        this.apply_evaluate_id = apply_evaluate_id;
    }

    public String getEnt_id() {
        return ent_id;
    }

    public void setEnt_id(String ent_id) {
        this.ent_id = ent_id;
    }

    public String getOrg_id() {
        return org_id;
    }

    public void setOrg_id(String org_id) {
        this.org_id = org_id;
    }

    public String getApply_status() {
        return apply_status;
    }

    public void setApply_status(String apply_status) {
        this.apply_status = apply_status;
    }

    public String getAudit_status() {
        return audit_status;
    }

    public void setAudit_status(String audit_status) {
        this.audit_status = audit_status;
    }

    public String getAppeal_status() {
        return appeal_status;
    }

    public void setAppeal_status(String appeal_status) {
        this.appeal_status = appeal_status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
