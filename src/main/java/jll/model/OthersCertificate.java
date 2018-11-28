package jll.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
/**
 *
 * 其他证书
 * */
@Entity(name = "ent_others_certificate")
public class OthersCertificate extends InformationPrivided {


    private String certificate_id;//主键
    private String certificate_no;//证书编号
    private String administration;//认证机关
    private String publish_unit;//发证机关
    private String certificate_status;//证书状态
    private Date start_date;//发证日期
    private Date end_date;//有效日期

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getCertificate_id() {
        return certificate_id;
    }

    public void setCertificate_id(String certificate_id) {
        this.certificate_id = certificate_id;
    }

    public String getCertificate_no() {
        return certificate_no;
    }

    public void setCertificate_no(String certificate_no) {
        this.certificate_no = certificate_no;
    }

    public String getAdministration() {
        return administration;
    }

    public void setAdministration(String administration) {
        this.administration = administration;
    }

    public String getPublish_unit() {
        return publish_unit;
    }

    public void setPublish_unit(String publish_unit) {
        this.publish_unit = publish_unit;
    }

    public String getCertificate_status() {
        return certificate_status;
    }

    public void setCertificate_status(String certificate_status) {
        this.certificate_status = certificate_status;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }



}
