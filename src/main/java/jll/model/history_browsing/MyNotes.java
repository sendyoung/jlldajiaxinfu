package jll.model.history_browsing;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 收信表
 */
//@Entity(name="org_my_notes")
public class MyNotes extends Base_Model {
    private String note_id;//主键
    private String user_id;//用户id
    private String ent_id;//企业id
    private String ent_name;//企业名称
    private String ent_credit;//企业社会信用统一代码
    private String ent_representative;//企业法定代表人
    private String note_content;//笔记内容

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getNote_id() {
        return note_id;
    }

    public void setNote_id(String note_id) {
        this.note_id = note_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getEnt_id() {
        return ent_id;
    }

    public void setEnt_id(String ent_id) {
        this.ent_id = ent_id;
    }

    public String getEnt_name() {
        return ent_name;
    }

    public void setEnt_name(String ent_name) {
        this.ent_name = ent_name;
    }

    public String getEnt_credit() {
        return ent_credit;
    }

    public void setEnt_credit(String ent_credit) {
        this.ent_credit = ent_credit;
    }

    public String getEnt_representative() {
        return ent_representative;
    }

    public void setEnt_representative(String ent_representative) {
        this.ent_representative = ent_representative;
    }

    public String getNote_content() {
        return note_content;
    }

    public void setNote_content(String note_content) {
        this.note_content = note_content;
    }
}
