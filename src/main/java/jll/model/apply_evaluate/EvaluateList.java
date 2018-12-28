package jll.model.apply_evaluate;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 评价榜单
 * */
@Entity(name="eva_evaluate_list")
public class EvaluateList {
    private String evaluate_list_id;//评价榜单ID
    private String title;//标题
    private String content;//内容
    private String auth_org_id;//组织ID
    private String status;//是否作废 1 未作废 2 已作废
    private String public_status;//是否公示 1 已公示 2 未公示

    private Date create_time;
    private Date update_time;
    private String isDelete;
    private String comment;

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getEvaluate_list_id() {
        return evaluate_list_id;
    }

    public void setEvaluate_list_id(String evaluate_list_id) {
        this.evaluate_list_id = evaluate_list_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuth_org_id() {
        return auth_org_id;
    }

    public void setAuth_org_id(String auth_org_id) {
        this.auth_org_id = auth_org_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPublic_status() {
        return public_status;
    }

    public void setPublic_status(String public_status) {
        this.public_status = public_status;
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
