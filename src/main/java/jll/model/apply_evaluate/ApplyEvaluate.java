package jll.model.apply_evaluate;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 申请评价
 * */
@Entity(name = "eva_apply_evaluate")
public class ApplyEvaluate {
    private String apply_evaluate_id;//申请评价ID
    private String auth_enterprise_id;//企业ID
    private String auth_org_id;//组织ID
    private String apply_status;//申请状态：
    private String audit_status;//审核状态
    private String appeal_status;//申诉状态 1、已申诉 2、已受理 3、已驳回 4、已完成
    private String title;//标题
    private String remarks;//备注批语

    private Date create_time;
    private Date update_time;
    private String isDelete;
    private String comment;

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getApply_evaluate_id() {
        return apply_evaluate_id;
    }

    public void setApply_evaluate_id(String apply_evaluate_id) {
        this.apply_evaluate_id = apply_evaluate_id;
    }

    public String getAuth_enterprise_id() {
        return auth_enterprise_id;
    }

    public void setAuth_enterprise_id(String auth_enterprise_id) {
        this.auth_enterprise_id = auth_enterprise_id;
    }

    public String getAuth_org_id() {
        return auth_org_id;
    }

    public void setAuth_org_id(String auth_org_id) {
        this.auth_org_id = auth_org_id;
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
