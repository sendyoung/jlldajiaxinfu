package jll.model.apply_evaluate;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 企业处罚
 * */
@Entity(name = "ent_enterprises_punishment")
public class EnterprisesPunishment extends Base_Model {
    private String enterprises_punishment_id;//企业处罚ID
    private String ent_id;//工商Id
    private String punish_date;//处罚日期
    private String content;//处罚内容
    private String status;//处罚类型：1行政处罚，2 环保处罚，3 失信处罚，4 安全处罚，5 税收处罚

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getEnterprises_punishment_id() {
        return enterprises_punishment_id;
    }

    public void setEnterprises_punishment_id(String enterprises_punishment_id) {
        this.enterprises_punishment_id = enterprises_punishment_id;
    }

    public String getEnt_id() {
        return ent_id;
    }

    public void setEnt_id(String ent_id) {
        this.ent_id = ent_id;
    }

    public String getPunish_date() {
        return punish_date;
    }

    public void setPunish_date(String punish_date) {
        this.punish_date = punish_date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
