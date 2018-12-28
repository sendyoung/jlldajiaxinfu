package jll.model.data_list;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 企业填报材料文档记录
 * */
@Entity(name="ent_report_file")
public class ReportFile {
    private String report_file_id;
    private String ent_id;//企业ID
    private String file_url;//文档url
    private String file_name;//文档名称
    private String file_remark;//文档案备注
    private String file_type;//文档类型
    private String audit_status;//审核状态：0.未审核 1.审核通过，2.审核不通过

    private Date create_time;
    private Date update_time;
    private String isDelete;
    private String comment;

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getReport_file_id() {
        return report_file_id;
    }

    public void setReport_file_id(String report_file_id) {
        this.report_file_id = report_file_id;
    }

    public String getEnt_id() {
        return ent_id;
    }

    public void setEnt_id(String ent_id) {
        this.ent_id = ent_id;
    }

    public String getFile_url() {
        return file_url;
    }

    public void setFile_url(String file_url) {
        this.file_url = file_url;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getFile_remark() {
        return file_remark;
    }

    public void setFile_remark(String file_remark) {
        this.file_remark = file_remark;
    }

    public String getFile_type() {
        return file_type;
    }

    public void setFile_type(String file_type) {
        this.file_type = file_type;
    }

    public String getAudit_status() {
        return audit_status;
    }

    public void setAudit_status(String audit_status) {
        this.audit_status = audit_status;
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
