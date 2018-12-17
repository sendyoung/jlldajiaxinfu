package jll.model.bad_information;

import jll.model.InformationPrivided;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 经营异常
 * */
@Entity(name="ent_unusual_business_list")
public class UnusualBusinessList extends InformationPrivided {
    private String unusual_business_list_id;//经营异常ID
    private Date publish_date;//列入日期
    private String administration;//做出决定机关
    private Date remove_date;//移除日期
    private String remove_office;//移除机关
    private String reason;//列入异常原因
    private String remove_the_cause;//移除原因

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getUnusual_business_list_id() {
        return unusual_business_list_id;
    }

    public void setUnusual_business_list_id(String unusual_business_list_id) {
        this.unusual_business_list_id = unusual_business_list_id;
    }

    public Date getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(Date publish_date) {
        this.publish_date = publish_date;
    }

    public String getAdministration() {
        return administration;
    }

    public void setAdministration(String administration) {
        this.administration = administration;
    }

    public Date getRemove_date() {
        return remove_date;
    }

    public void setRemove_date(Date remove_date) {
        this.remove_date = remove_date;
    }

    public String getRemove_office() {
        return remove_office;
    }

    public void setRemove_office(String remove_office) {
        this.remove_office = remove_office;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRemove_the_cause() {
        return remove_the_cause;
    }

    public void setRemove_the_cause(String remove_the_cause) {
        this.remove_the_cause = remove_the_cause;
    }
}
