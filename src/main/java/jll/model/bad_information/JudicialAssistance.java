package jll.model.bad_information;

import jll.model.InformationPrivided;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 司法协助
 * */
@Entity(name="ent_judicial_assistance")
public class JudicialAssistance extends InformationPrivided {
    private String judicial_assistance_id;//ID
    private String executor;//被执行人
    private Float amount;//股权数额
    private String execute_court;//执行法院
    private String notice_no;//执行通知书文号
    private String status;//类型状态

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")

    public String getJudicial_assistance_id() {
        return judicial_assistance_id;
    }

    public void setJudicial_assistance_id(String judicial_assistance_id) {
        this.judicial_assistance_id = judicial_assistance_id;
    }

    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public String getExecute_court() {
        return execute_court;
    }

    public void setExecute_court(String execute_court) {
        this.execute_court = execute_court;
    }

    public String getNotice_no() {
        return notice_no;
    }

    public void setNotice_no(String notice_no) {
        this.notice_no = notice_no;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
