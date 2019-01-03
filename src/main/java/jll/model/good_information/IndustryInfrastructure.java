package jll.model.good_information;

import jll.model.InformationPrivided;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 行业基础建设
 */
@Entity(name="ent_industry_infrastructure")
public class IndustryInfrastructure extends InformationPrivided {

    private String industry_infrastructure_id;
    private String editor_national;//主编国家技术标准
    private String cenbian_national;//参编国家技术标准
    private String editor_place;//主编地方技术标准
    private String cenbian_place;//参编地方技术标准
    private String editor_business;//主编业务
    private String cenbian_business;//参编业务
    private String core_journal;//核心期刊
    private String other_journal;//其他期刊

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getIndustry_infrastructure_id() {
        return industry_infrastructure_id;
    }

    public void setIndustry_infrastructure_id(String industry_infrastructure_id) {
        this.industry_infrastructure_id = industry_infrastructure_id;
    }

    public String getEditor_national() {
        return editor_national;
    }

    public void setEditor_national(String editor_national) {
        this.editor_national = editor_national;
    }

    public String getCenbian_national() {
        return cenbian_national;
    }

    public void setCenbian_national(String cenbian_national) {
        this.cenbian_national = cenbian_national;
    }

    public String getEditor_place() {
        return editor_place;
    }

    public void setEditor_place(String editor_place) {
        this.editor_place = editor_place;
    }

    public String getCenbian_place() {
        return cenbian_place;
    }

    public void setCenbian_place(String cenbian_place) {
        this.cenbian_place = cenbian_place;
    }

    public String getEditor_business() {
        return editor_business;
    }

    public void setEditor_business(String editor_business) {
        this.editor_business = editor_business;
    }

    public String getCenbian_business() {
        return cenbian_business;
    }

    public void setCenbian_business(String cenbian_business) {
        this.cenbian_business = cenbian_business;
    }

    public String getCore_journal() {
        return core_journal;
    }

    public void setCore_journal(String core_journal) {
        this.core_journal = core_journal;
    }

    public String getOther_journal() {
        return other_journal;
    }

    public void setOther_journal(String other_journal) {
        this.other_journal = other_journal;
    }
}
