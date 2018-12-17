package jll.model.bad_information;

import jll.model.InformationPrivided;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 裁判文书
 * */
@Entity(name="ent_adjudicative_document")
public class AdjudicativeDocument extends InformationPrivided {
    private String adjudicative_document_id;//ID
    private String case_name;//案件名称
    private String case_no;//案件编号
    private String case_cause;//案由
    private Date publish_date;//发布时间
    private String executive_court;//执行法院
    private String locus_standi;//诉讼地位
    private String subject_matter;//执行标的

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getAdjudicative_document_id() {
        return adjudicative_document_id;
    }

    public void setAdjudicative_document_id(String adjudicative_document_id) {
        this.adjudicative_document_id = adjudicative_document_id;
    }

    public String getCase_name() {
        return case_name;
    }

    public void setCase_name(String case_name) {
        this.case_name = case_name;
    }

    public String getCase_no() {
        return case_no;
    }

    public void setCase_no(String case_no) {
        this.case_no = case_no;
    }

    public String getCase_cause() {
        return case_cause;
    }

    public void setCase_cause(String case_cause) {
        this.case_cause = case_cause;
    }

    public Date getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(Date publish_date) {
        this.publish_date = publish_date;
    }

    public String getExecutive_court() {
        return executive_court;
    }

    public void setExecutive_court(String executive_court) {
        this.executive_court = executive_court;
    }

    public String getLocus_standi() {
        return locus_standi;
    }

    public void setLocus_standi(String locus_standi) {
        this.locus_standi = locus_standi;
    }

    public String getSubject_matter() {
        return subject_matter;
    }

    public void setSubject_matter(String subject_matter) {
        this.subject_matter = subject_matter;
    }
}
