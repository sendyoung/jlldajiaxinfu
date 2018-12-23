package jll.model.history_browsing;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 历史浏览
 */
@Entity(name="org_history_browse_records")
public class HistoryBrowsing extends Base_Model {

    private String browse_id;//主键id
    private String user_id;//用户id
    private String ent_id;//企业id
    private String ent_name;//企业名称

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getBrowse_id() {
        return browse_id;
    }

    public void setBrowse_id(String browse_id) {
        this.browse_id = browse_id;
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
}
