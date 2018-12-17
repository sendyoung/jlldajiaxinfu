package jll.model.BasicPnformationSubmit;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 网站备案 填报
 */
@Entity(name = "ent_website_records")
public class WebsiteRecords extends Base_Model {
    // 主键
    private String id;
    // 企业id
    private String ent_id;
    // 审核时间
    private Date review_time;
    // 网站名称
    private String site_name;
    // 网站首页
    private String website_homepage;
    // 域名
    private String domain_name;
    // 备案号
    private String put_on_records_num;
    // 状态
    private String status;

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEnt_id() {
        return ent_id;
    }

    public void setEnt_id(String ent_id) {
        this.ent_id = ent_id;
    }

    public Date getReview_time() {
        return review_time;
    }

    public void setReview_time(Date review_time) {
        this.review_time = review_time;
    }

    public String getSite_name() {
        return site_name;
    }

    public void setSite_name(String site_name) {
        this.site_name = site_name;
    }

    public String getWebsite_homepage() {
        return website_homepage;
    }

    public void setWebsite_homepage(String website_homepage) {
        this.website_homepage = website_homepage;
    }

    public String getDomain_name() {
        return domain_name;
    }

    public void setDomain_name(String domain_name) {
        this.domain_name = domain_name;
    }

    public String getPut_on_records_num() {
        return put_on_records_num;
    }

    public void setPut_on_records_num(String put_on_records_num) {
        this.put_on_records_num = put_on_records_num;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
