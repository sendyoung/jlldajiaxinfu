package jll.model.apply_evaluate;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 红黑名单榜单
 * */
@Entity(name="eva_red_black_list")
public class RedBlackList{
    private String red_black_list_id;//榜单ID
    private String type;//名单类型，1 红名单，2 黑名单
    private String list_name;//名单名称
    private String list_content;//名单说明
    private String auth_org_id;//组织ID
    private String period;//年度
    private String status;//是否作废 1 未作废 2 已作废
    private String public_status;//是否公示 1 已公示 2 未公示

    private Date create_time;
    private Date update_time;
    private String isDelete;
    private String comment;

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getRed_black_list_id() {
        return red_black_list_id;
    }

    public void setRed_black_list_id(String red_black_list_id) {
        this.red_black_list_id = red_black_list_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getList_name() {
        return list_name;
    }

    public void setList_name(String list_name) {
        this.list_name = list_name;
    }

    public String getList_content() {
        return list_content;
    }

    public void setList_content(String list_content) {
        this.list_content = list_content;
    }

    public String getAuth_org_id() {
        return auth_org_id;
    }

    public void setAuth_org_id(String auth_org_id) {
        this.auth_org_id = auth_org_id;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
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
