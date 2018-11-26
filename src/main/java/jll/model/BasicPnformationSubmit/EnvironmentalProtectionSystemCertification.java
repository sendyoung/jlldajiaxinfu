package jll.model.BasicPnformationSubmit;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 环保体系认证
 */
@Entity(name = "ent_system_certification")
public class EnvironmentalProtectionSystemCertification extends Base_Model {
    // 主键
    private String id;
    // 企业id
    private String ent_id;
    //  证书编号
    private String certificate_number;
    // 发证日期
    private Date date_of_issue;
    // 截止日期
    private Date expiration_date;
    // 认证机构
    private String certification_body;
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

    public String getCertificate_number() {
        return certificate_number;
    }

    public void setCertificate_number(String certificate_number) {
        this.certificate_number = certificate_number;
    }

    public Date getDate_of_issue() {
        return date_of_issue;
    }

    public void setDate_of_issue(Date date_of_issue) {
        this.date_of_issue = date_of_issue;
    }

    public Date getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(Date expiration_date) {
        this.expiration_date = expiration_date;
    }

    public String getCertification_body() {
        return certification_body;
    }

    public void setCertification_body(String certification_body) {
        this.certification_body = certification_body;
    }
}
