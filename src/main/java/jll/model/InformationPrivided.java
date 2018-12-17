package jll.model;

import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * 抽象出来的信息填报基础表
 */
@MappedSuperclass
public abstract class InformationPrivided {

    /**权限表主键**/
    public Date create_time;

    /**权限表主键**/
    public Date update_time;

    /**权限表主键**/
    public String isDelete;

    /**权限表主键**/
    public String comment;
    public String ent_id;//企业ID


    public String getEnt_id() {
        return ent_id;
    }

    public void setEnt_id(String ent_id) {
        this.ent_id = ent_id;
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
