package jll.model.OrgOrganization;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 职务信息
 */
@Entity(name = "org_position")
public class Position {
    // 主键
    private String post_id;
    //组织表id
    private String auth_org_id;
    // 职务
    private String post;
    // 创建时间  数据创建时间
    private Date create_time;
    // 更新时间
    private Date update_time;
    // 是否删除   1删除   0未删除   默认为0
    private String isDelete;
    // 备注
    private String comment;

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getPost_id() {
        return post_id;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
    }

    public String getAuth_org_id() {
        return auth_org_id;
    }

    public void setAuth_org_id(String auth_org_id) {
        this.auth_org_id = auth_org_id;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
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
