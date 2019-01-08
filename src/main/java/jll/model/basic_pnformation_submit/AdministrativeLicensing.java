package jll.model.basic_pnformation_submit;


import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 行政许可
 */
@Entity(name = "ent_administrative_licensing")
public class AdministrativeLicensing  extends Base_Model {
    // 主键
    private String id;
    // 企业id
    private String ent_id;
    // 许可文件序号
    private String license_file_number;
    // 许可文件名称
    private String license_file_name;
    // 有效期自
    private Date the_validity_of_the;
    // 有效期至
    private Date valid_until;
    // 许可机关
    private String licensing_authority;
    // 许可内容
    private String licensed_content;

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

    public String getLicense_file_number() {
        return license_file_number;
    }

    public void setLicense_file_number(String license_file_number) {
        this.license_file_number = license_file_number;
    }

    public String getLicense_file_name() {
        return license_file_name;
    }

    public void setLicense_file_name(String license_file_name) {
        this.license_file_name = license_file_name;
    }

    public Date getThe_validity_of_the() {
        return the_validity_of_the;
    }

    public void setThe_validity_of_the(Date the_validity_of_the) {
        this.the_validity_of_the = the_validity_of_the;
    }

    public Date getValid_until() {
        return valid_until;
    }

    public void setValid_until(Date valid_until) {
        this.valid_until = valid_until;
    }

    public String getLicensing_authority() {
        return licensing_authority;
    }

    public void setLicensing_authority(String licensing_authority) {
        this.licensing_authority = licensing_authority;
    }

    public String getLicensed_content() {
        return licensed_content;
    }

    public void setLicensed_content(String licensed_content) {
        this.licensed_content = licensed_content;
    }
}
