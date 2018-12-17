package jll.model.BasicPnformationSubmit;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 海关信用信息
 */
@Entity(name = "ent_customs_credit")
public class CustomsCreditInformation extends Base_Model {
    // 主键
    private String id;
    // 企业id
    private String ent_id;
    // 认证证书编码
    private String certificate_code;
    // 认证时间
    private Date certification_date;
    // 信用等级
    private String credit_rating;
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

    public String getCertificate_code() {
        return certificate_code;
    }

    public void setCertificate_code(String certificate_code) {
        this.certificate_code = certificate_code;
    }


    public Date getCertification_date() {
        return certification_date;
    }

    public void setCertification_date(Date certification_date) {
        this.certification_date = certification_date;
    }

    public String getCredit_rating() {
        return credit_rating;
    }

    public void setCredit_rating(String credit_rating) {
        this.credit_rating = credit_rating;
    }
}
