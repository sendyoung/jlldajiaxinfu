package jll.model.bad_information;

import jll.model.InformationPrivided;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 失信被执行人
 * */
@Entity(name="ent_discredit_executor")
public class DiscreditExecutor extends InformationPrivided {
    private String discredit_executor_id;//ID
    private String case_no;//案号
    private String execute_court;//执行法院
    private String judge_court;//做出执行依据单位
    private Date publish_date;//发布时间
    private String execute_result;//被执行的履行情况
    private String legal_obligation;//生效法律文书确定的义务

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getDiscredit_executor_id() {
        return discredit_executor_id;
    }

    public void setDiscredit_executor_id(String discredit_executor_id) {
        this.discredit_executor_id = discredit_executor_id;
    }

    public String getCase_no() {
        return case_no;
    }

    public void setCase_no(String case_no) {
        this.case_no = case_no;
    }

    public String getExecute_court() {
        return execute_court;
    }

    public void setExecute_court(String execute_court) {
        this.execute_court = execute_court;
    }

    public String getJudge_court() {
        return judge_court;
    }

    public void setJudge_court(String judge_court) {
        this.judge_court = judge_court;
    }

    public Date getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(Date publish_date) {
        this.publish_date = publish_date;
    }

    public String getExecute_result() {
        return execute_result;
    }

    public void setExecute_result(String execute_result) {
        this.execute_result = execute_result;
    }

    public String getLegal_obligation() {
        return legal_obligation;
    }

    public void setLegal_obligation(String legal_obligation) {
        this.legal_obligation = legal_obligation;
    }
}
