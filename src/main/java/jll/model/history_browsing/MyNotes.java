package jll.model.history_browsing;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 收信表
 */
@Entity(name="org_my_notes")
public class MyNotes extends Base_Model {
    private String note_id;//主键
    private String user_id;//用户id
    private String ent_id;//企业id


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
}
