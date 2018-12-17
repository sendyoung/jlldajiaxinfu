package jll.model.OrgOrganization;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 主办期刊
 */
@Entity(name = "org_hosting_journal")
public class HostingJournal {
    // 主键 id
    private String id;
    // 组织id
    private String org_id;
    // 主办期刊图片路径
    private String img_path;
    // 期刊期数
    private int number_of_periods;
    // 标题
    private String title;
    // 期刊简介
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

    public int getNumber_of_periods() {
        return number_of_periods;
    }

    public void setNumber_of_periods(int number_of_periods) {
        this.number_of_periods = number_of_periods;
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

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }
}
