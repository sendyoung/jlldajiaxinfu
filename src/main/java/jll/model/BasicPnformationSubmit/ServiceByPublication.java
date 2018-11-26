package jll.model.BasicPnformationSubmit;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 公示催告
 */
@Entity(name = "ent_service_by_publication")
public class ServiceByPublication extends Base_Model {
    // 主键
    private String id;
    // 企业id
    private String ent_id;
    // 票据号
    private String bill_no;
    // 发布机构
    private String release_mechanism;
    // 公告日期
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

    public String getBill_no() {
        return bill_no;
    }

    public void setBill_no(String bill_no) {
        this.bill_no = bill_no;
    }

    public String getRelease_mechanism() {
        return release_mechanism;
    }

    public void setRelease_mechanism(String release_mechanism) {
        this.release_mechanism = release_mechanism;
    }

    public Date getPublic_date() {
        return public_date;
    }

    public void setPublic_date(Date public_date) {
        this.public_date = public_date;
    }
}
