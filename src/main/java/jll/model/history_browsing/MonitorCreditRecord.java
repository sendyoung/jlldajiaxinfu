package jll.model.history_browsing;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="org_monitor_credit_record")
public class MonitorCreditRecord extends Base_Model {

    private String monitor_id;//主键
    private String ent_id;//企业Id
//    private String monitor_table_id;//监控的表的数据ID
//    private String monitor_table_name;//监控的表的名称
    private String new_dynamic;//最新动态
    private String behavior_classification;//行为分类 1良好信用记录 2,不良信用记录 3.新闻舆情

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getMonitor_id() {
        return monitor_id;
    }

    public void setMonitor_id(String monitor_id) {
        this.monitor_id = monitor_id;
    }

    public String getEnt_id() {
        return ent_id;
    }

    public void setEnt_id(String ent_id) {
        this.ent_id = ent_id;
    }

    public String getNew_dynamic() {
        return new_dynamic;
    }

    public void setNew_dynamic(String new_dynamic) {
        this.new_dynamic = new_dynamic;
    }

    public String getBehavior_classification() {
        return behavior_classification;
    }

    public void setBehavior_classification(String behavior_classification) {
        this.behavior_classification = behavior_classification;
    }
}
