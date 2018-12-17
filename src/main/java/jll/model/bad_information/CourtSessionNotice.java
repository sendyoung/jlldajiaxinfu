package jll.model.bad_information;

import jll.model.InformationPrivided;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 开庭公告
 * */
@Entity(name="ent_court_session_notice")
public class CourtSessionNotice extends InformationPrivided {
    private String court_session_notice_id;//ID
    private String case_no;//案号
    private Date session_date;//开庭日期
    private String action_cause;//案由
    private String appellant;//上诉人 原告
    private String appellee;//被上诉人 被告

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getCourt_session_notice_id() {
        return court_session_notice_id;
    }

    public void setCourt_session_notice_id(String court_session_notice_id) {
        this.court_session_notice_id = court_session_notice_id;
    }

    public String getCase_no() {
        return case_no;
    }

    public void setCase_no(String case_no) {
        this.case_no = case_no;
    }

    public Date getSession_date() {
        return session_date;
    }

    public void setSession_date(Date session_date) {
        this.session_date = session_date;
    }

    public String getAction_cause() {
        return action_cause;
    }

    public void setAction_cause(String action_cause) {
        this.action_cause = action_cause;
    }

    public String getAppellant() {
        return appellant;
    }

    public void setAppellant(String appellant) {
        this.appellant = appellant;
    }

    public String getAppellee() {
        return appellee;
    }

    public void setAppellee(String appellee) {
        this.appellee = appellee;
    }
}
