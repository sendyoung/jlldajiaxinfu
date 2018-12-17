package jll.model.bad_information;

import jll.model.InformationPrivided;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 环保处罚
 * */
@Entity(name="ent_environment_punishment")
public class EnvironmentPunishment extends InformationPrivided {
    private String environment_punishment_id;//环保处罚ID
    private String doc_no;//决定文书号
    private String stype;//违法类型
    private String administration;//决定机关
    private Date punish_date;//决定处罚日期
    private String punish_basis;//处罚依据
    private String punish_result;//处罚结果（内容）
    private String punish_cause;//处罚事由
    private String execution;//执行情况

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getEnvironment_punishment_id() {
        return environment_punishment_id;
    }

    public void setEnvironment_punishment_id(String environment_punishment_id) {
        this.environment_punishment_id = environment_punishment_id;
    }

    public String getDoc_no() {
        return doc_no;
    }

    public void setDoc_no(String doc_no) {
        this.doc_no = doc_no;
    }

    public String getStype() {
        return stype;
    }

    public void setStype(String stype) {
        this.stype = stype;
    }

    public String getAdministration() {
        return administration;
    }

    public void setAdministration(String administration) {
        this.administration = administration;
    }

    public Date getPunish_date() {
        return punish_date;
    }

    public void setPunish_date(Date punish_date) {
        this.punish_date = punish_date;
    }

    public String getPunish_basis() {
        return punish_basis;
    }

    public void setPunish_basis(String punish_basis) {
        this.punish_basis = punish_basis;
    }

    public String getPunish_result() {
        return punish_result;
    }

    public void setPunish_result(String punish_result) {
        this.punish_result = punish_result;
    }

    public String getPunish_cause() {
        return punish_cause;
    }

    public void setPunish_cause(String punish_cause) {
        this.punish_cause = punish_cause;
    }

    public String getExecution() {
        return execution;
    }

    public void setExecution(String execution) {
        this.execution = execution;
    }
}
