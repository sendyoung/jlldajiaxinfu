package jll.model.bad_information;

import jll.model.InformationPrivided;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 行政处罚
 * */
@Entity(name="ent_administrative_publishment")
public class AdministrativePublishment extends InformationPrivided {
    private String administrative_publishment_id;//行政处罚ID
    private String doc_no;//决定文书号
    private String stype;//违法行为类型
    private String administration;//决定机关名称
    private Date punish_date;//处罚决定日期
    private String punish_result;//处罚内容

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getAdministrative_publishment_id() {
        return administrative_publishment_id;
    }

    public void setAdministrative_publishment_id(String administrative_publishment_id) {
        this.administrative_publishment_id = administrative_publishment_id;
    }

    public String getDoc_no() {
        return doc_no;
    }

    public void setDoc_no(String doc_no) {
        this.doc_no = doc_no;
    }

    public String getStype() {
        return stype;
    }

    public void setStype(String stype) {
        this.stype = stype;
    }

    public String getAdministration() {
        return administration;
    }

    public void setAdministration(String administration) {
        this.administration = administration;
    }

    public Date getPunish_date() {
        return punish_date;
    }

    public void setPunish_date(Date punish_date) {
        this.punish_date = punish_date;
    }

    public String getPunish_result() {
        return punish_result;
    }

    public void setPunish_result(String punish_result) {
        this.punish_result = punish_result;
    }
}
