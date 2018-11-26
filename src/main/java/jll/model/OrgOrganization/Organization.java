package jll.model.OrgOrganization;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 组织信息
 */
@Entity(name = "org_organization")
public class Organization {
    // 主键id
    private String org_information_id;
    // 组织id
    private String org_id;
    // 所属行业
    private int industry;
    // 公益材料文件地址
    private String commonweal_material_imager;
    // 会员数量
    private int number_members;
    // private
    // 职责
    private String duty;
    //数据创建时间
    private Date create_time;
    // 数据更新时间
    private Date update_time;
    // 是否删除 1删除 0未删除 默认为0
    private String isDelete;
    // 备注
    private String comment;

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getOrg_information_id() {
        return org_information_id;
    }

    public void setOrg_information_id(String org_information_id) {
        this.org_information_id = org_information_id;
    }

    public int getIndustry() {
        return industry;
    }

    public void setIndustry(int industry) {
        this.industry = industry;
    }

    public String getCommonweal_material_imager() {
        return commonweal_material_imager;
    }

    public void setCommonweal_material_imager(String commonweal_material_imager) {
        this.commonweal_material_imager = commonweal_material_imager;
    }

    public int getNumber_members() {
        return number_members;
    }

    public void setNumber_members(int number_members) {
        this.number_members = number_members;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getOrg_id() {
        return org_id;
    }

    public void setOrg_id(String org_id) {
        this.org_id = org_id;
    }
}
