package jll.model.OrgOrganization;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 组织活动
 */
@Entity(name = "org_organize_activity")
public class OrganizeActivity {
    // 主键 id
    private String id;
    // 组织id
    private String org_id;
    // 期刊封面图片路径
    private String img_path;
    // 名称
    private String title;
    // 期数
    private String number_of_periods;
    // 内容
    private String content;
    // 上传文件路径
    private String file_path;

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrg_id() {
        return org_id;
    }

    public void setOrg_id(String org_id) {
        this.org_id = org_id;
    }

    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNumber_of_periods() {
        return number_of_periods;
    }

    public void setNumber_of_periods(String number_of_periods) {
        this.number_of_periods = number_of_periods;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

}
