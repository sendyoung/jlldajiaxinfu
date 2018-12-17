package jll.model.BasicPnformationSubmit;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 知识产权出质信息
 */
@Entity(name = "ent_intellectual_property")
public class IntellectualProperty extends Base_Model {
    // 主键
    private String id;
    // 企业id
    private String ent_id;
    // 知识产权登记证号
    private String property_right;
    // 名称
    private String name;
    // 种类
    private String kind;
    // 出质人名称
    private String pledgor_name;
    // 质权人名称
    private String pawnee_name;
    // 质权登记期限
    private String pledge_registration;
    // 状态
    private String status;
    // 公示日期
    private Date public_date;
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

    public String getProperty_right() {
        return property_right;
    }

    public void setProperty_right(String property_right) {
        this.property_right = property_right;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getPledgor_name() {
        return pledgor_name;
    }

    public void setPledgor_name(String pledgor_name) {
        this.pledgor_name = pledgor_name;
    }

    public String getPawnee_name() {
        return pawnee_name;
    }

    public void setPawnee_name(String pawnee_name) {
        this.pawnee_name = pawnee_name;
    }

    public String getPledge_registration() {
        return pledge_registration;
    }

    public void setPledge_registration(String pledge_registration) {
        this.pledge_registration = pledge_registration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getPublic_date() {
        return public_date;
    }

    public void setPublic_date(Date public_date) {
        this.public_date = public_date;
    }
}
