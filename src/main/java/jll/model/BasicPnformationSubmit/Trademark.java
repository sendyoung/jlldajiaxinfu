package jll.model.BasicPnformationSubmit;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 商标信息
 */
@Entity(name = "ent_trademark")
public class Trademark extends Base_Model {
    // 主键
    private String id;
    // 企业id
    private String ent_id;
    // 申请日期
    private Date application_date;
    // 商标
    private String trademark;
    // 商标名称
    private String trademark_name;
    // 注册号
    private String registration_number;
    // 类别
    private String category;
    // 流程状态
    private String process_state;
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

    public Date getApplication_date() {
        return application_date;
    }

    public void setApplication_date(Date application_date) {
        this.application_date = application_date;
    }

    public String getTrademark() {
        return trademark;
    }

    public void setTrademark(String trademark) {
        this.trademark = trademark;
    }

    public String getTrademark_name() {
        return trademark_name;
    }

    public void setTrademark_name(String trademark_name) {
        this.trademark_name = trademark_name;
    }

    public String getRegistration_number() {
        return registration_number;
    }

    public void setRegistration_number(String registration_number) {
        this.registration_number = registration_number;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProcess_state() {
        return process_state;
    }

    public void setProcess_state(String process_state) {
        this.process_state = process_state;
    }
}
