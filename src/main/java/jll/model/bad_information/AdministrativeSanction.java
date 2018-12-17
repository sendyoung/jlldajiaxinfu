package jll.model.bad_information;

import jll.model.InformationPrivided;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 海关行政处罚
 * */
@Entity(name="ent_administrative_sanction")
public class AdministrativeSanction extends InformationPrivided {
    private String administrative_sanction_id;//海关行政处罚ID
    private String document_number;//海关行政处罚文书编号
    private String party;//当事人
    private Date publish_date;//处罚日期
    private String case_nature;//处罚性质

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getAdministrative_sanction_id() {
        return administrative_sanction_id;
    }

    public void setAdministrative_sanction_id(String administrative_sanction_id) {
        this.administrative_sanction_id = administrative_sanction_id;
    }

    public String getDocument_number() {
        return document_number;
    }

    public void setDocument_number(String document_number) {
        this.document_number = document_number;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public Date getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(Date publish_date) {
        this.publish_date = publish_date;
    }

    public String getCase_nature() {
        return case_nature;
    }

    public void setCase_nature(String case_nature) {
        this.case_nature = case_nature;
    }
}
