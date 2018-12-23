package jll.model.history_browsing;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 监控关注表
 */
@Entity(name="org_monitoring_concern_list")
public class MonitoringConcern {

    private String monitoring_concern_id;//主键ID
    private String user_id;//用户ID
    private String ent_id;//企业ID
    private String type;//类型  1监控  2 关注

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getMonitoring_concern_id() {
        return monitoring_concern_id;
    }

    public void setMonitoring_concern_id(String monitoring_concern_id) {
        this.monitoring_concern_id = monitoring_concern_id;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
