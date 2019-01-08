package jll.model.basic_pnformation_submit;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 软件著作权
 */
@Entity(name = "ent_software_copyright")
public class SoftwareCopyright extends Base_Model {
    // 主键
    private String id;
    // 企业id
    private String ent_id;
    // 登记日期
    private Date record_date;
    // 软件全称
    private String software_full_name;
    // 软件简称
    private String software_abbreviation;
    // 登记号
    private String register_number;
    // 分类号
    private String class_number;
    // 版本号
    private String version_number;

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

    public Date getRecord_date() {
        return record_date;
    }

    public void setRecord_date(Date record_date) {
        this.record_date = record_date;
    }

    public String getSoftware_full_name() {
        return software_full_name;
    }

    public void setSoftware_full_name(String software_full_name) {
        this.software_full_name = software_full_name;
    }

    public String getSoftware_abbreviation() {
        return software_abbreviation;
    }

    public void setSoftware_abbreviation(String software_abbreviation) {
        this.software_abbreviation = software_abbreviation;
    }

    public String getRegister_number() {
        return register_number;
    }

    public void setRegister_number(String register_number) {
        this.register_number = register_number;
    }

    public String getClass_number() {
        return class_number;
    }

    public void setClass_number(String class_number) {
        this.class_number = class_number;
    }

    public String getVersion_number() {
        return version_number;
    }

    public void setVersion_number(String version_number) {
        this.version_number = version_number;
    }
}
