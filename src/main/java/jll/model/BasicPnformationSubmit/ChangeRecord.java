package jll.model.BasicPnformationSubmit;


import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 *  变更记录 填报
 */
@Entity(name = "ent_change_record")
public class ChangeRecord extends Base_Model{
    // 主键
    private String id;
    // 企业id
    private String ent_id;
    // 变更项目名称
    private String change_project_name;
    // 变更日期
    private Date change_Date;
    // 变更前内容
    private String before_content;
    // 变更后内容
    private String after_content;
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

    public String getChange_project_name() {
        return change_project_name;
    }

    public void setChange_project_name(String change_project_name) {
        this.change_project_name = change_project_name;
    }

    public Date getChange_Date() {
        return change_Date;
    }

    public void setChange_Date(Date change_Date) {
        this.change_Date = change_Date;
    }

    public String getBefore_content() {
        return before_content;
    }

    public void setBefore_content(String before_content) {
        this.before_content = before_content;
    }

    public String getAfter_content() {
        return after_content;
    }

    public void setAfter_content(String after_content) {
        this.after_content = after_content;
    }
}
