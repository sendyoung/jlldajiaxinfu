package jll.model.basic_pnformation_submit;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 招投标信息
 */
@Entity(name = "ent_Bidding")
public class Bidding extends Base_Model {
    // 主键
    private String id;
    // 企业id
    private String ent_id;
    // 发布时间
    private Date release_time;
    // 标题
    private String title;
    // 采购人
    private String purchasing_agent;

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

    public Date getRelease_time() {
        return release_time;
    }

    public void setRelease_time(Date release_time) {
        this.release_time = release_time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPurchasing_agent() {
        return purchasing_agent;
    }

    public void setPurchasing_agent(String purchasing_agent) {
        this.purchasing_agent = purchasing_agent;
    }
}
