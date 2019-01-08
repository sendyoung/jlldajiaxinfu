package jll.model.basic_pnformation_submit;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 资质认证
 */
@Entity(name = "ent_aptitudes_authentication")
public class QualificationAuthentication extends Base_Model {
    // 主键
    private String id;
    // 企业id
    private String ent_id;
    // 证书编号
    private String certificate_number;
    // 认证机构
    private String certification_body ;
    // 发证机关
    private String licence_issuing_authority;
    // 证书状态
    private String status_of_certificate;
    // 发证日期
    private Date date_of_issue;
    // 有效日期
    private Date effective_date;
    // 认证类别
    private String certification_category;
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

    public String getCertification_body() {
        return certification_body;
    }

    public void setCertification_body(String certification_body) {
        this.certification_body = certification_body;
    }

    public String getLicence_issuing_authority() {
        return licence_issuing_authority;
    }

    public void setLicence_issuing_authority(String licence_issuing_authority) {
        this.licence_issuing_authority = licence_issuing_authority;
    }

    public String getStatus_of_certificate() {
        return status_of_certificate;
    }

    public void setStatus_of_certificate(String status_of_certificate) {
        this.status_of_certificate = status_of_certificate;
    }

    public Date getDate_of_issue() {
        return date_of_issue;
    }

    public void setDate_of_issue(Date date_of_issue) {
        this.date_of_issue = date_of_issue;
    }

    public Date getEffective_date() {
        return effective_date;
    }

    public void setEffective_date(Date effective_date) {
        this.effective_date = effective_date;
    }

    public String getCertification_category() {
        return certification_category;
    }

    public void setCertification_category(String certification_category) {
        this.certification_category = certification_category;
    }
}
