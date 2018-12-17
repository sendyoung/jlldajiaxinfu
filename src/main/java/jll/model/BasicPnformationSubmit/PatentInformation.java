package jll.model.BasicPnformationSubmit;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 专利信息
 */
@Entity(name = "ent_patent_information")
public class PatentInformation extends Base_Model {
    // 主键
    private String id;
    // 企业id
    private String ent_id;
    // 专利申请日
    private String date_of_application;
    // 专利名称
    private String patents_name;
    // 专利号
    private String patents_num;
    // 专利类型
    private String patents_type;
    // 状态
    private String status;

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

    public String getDate_of_application() {
        return date_of_application;
    }

    public void setDate_of_application(String date_of_application) {
        this.date_of_application = date_of_application;
    }

    public String getPatents_name() {
        return patents_name;
    }

    public void setPatents_name(String patents_name) {
        this.patents_name = patents_name;
    }

    public String getPatents_num() {
        return patents_num;
    }

    public void setPatents_num(String patents_num) {
        this.patents_num = patents_num;
    }

    public String getPatents_type() {
        return patents_type;
    }

    public void setPatents_type(String patents_type) {
        this.patents_type = patents_type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
