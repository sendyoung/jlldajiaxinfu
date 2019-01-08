package jll.model.org_organization;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 职务信息详情
 */
@Entity(name = "org_position_detail")
public class PositionDetail {
    //主键
    private String post_detail_id;
    // 职务id
    private String post_id;
    // 职务
    private String post;
    // 证件照
    private String id_photo_imager;
    // 任职单位
    private String tenure_unit;
    // 职务姓名
    private String post_name;
    // 组织职务
    private String org_post;
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
    public String getPost_detail_id() {
        return post_detail_id;
    }

    public void setPost_detail_id(String post_detail_id) {
        this.post_detail_id = post_detail_id;
    }

    public String getPost_id() {
        return post_id;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getId_photo_imager() {
        return id_photo_imager;
    }

    public void setId_photo_imager(String id_photo_imager) {
        this.id_photo_imager = id_photo_imager;
    }

    public String getTenure_unit() {
        return tenure_unit;
    }

    public void setTenure_unit(String tenure_unit) {
        this.tenure_unit = tenure_unit;
    }

    public String getPost_name() {
        return post_name;
    }

    public void setPost_name(String post_name) {
        this.post_name = post_name;
    }

    public String getOrg_post() {
        return org_post;
    }

    public void setOrg_post(String org_post) {
        this.org_post = org_post;
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
