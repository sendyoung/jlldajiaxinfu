package jll.model.apply_evaluate;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 申请模块
 * */
@Entity(name="eva_apply_module")
public class ApplyModule extends Base_Model {
    private String apply_module_id;//申请模块ID
    private String status;//审核状态：审核未通过，审核通过
    private String auditor;//审核人
    private String remarks;//备注批语
    private String apply_permission_id;//申请权限ID
    private String apply_evaluate_id;//申请评价ID

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getApply_module_id() {
        return apply_module_id;
    }

    public void setApply_module_id(String apply_module_id) {
        this.apply_module_id = apply_module_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getApply_permission_id() {
        return apply_permission_id;
    }

    public void setApply_permission_id(String apply_permission_id) {
        this.apply_permission_id = apply_permission_id;
    }

    public String getApply_evaluate_id() {
        return apply_evaluate_id;
    }

    public void setApply_evaluate_id(String apply_evaluate_id) {
        this.apply_evaluate_id = apply_evaluate_id;
    }
}
