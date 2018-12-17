package jll.model.bad_information;

import jll.model.InformationPrivided;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 被执行人
 * */
@Entity(name="ent_executor")
public class Executor extends InformationPrivided {
    private String executor_id;//ID
    private String name;//被执行人名称
    private Date filling_time;//立案时间
    private String case_no;//案号
    private String execute_court;//执行法院
    private String subject_matter;//执行标的

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getExecutor_id() {
        return executor_id;
    }

    public void setExecutor_id(String executor_id) {
        this.executor_id = executor_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getFilling_time() {
        return filling_time;
    }

    public void setFilling_time(Date filling_time) {
        this.filling_time = filling_time;
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

    public String getSubject_matter() {
        return subject_matter;
    }

    public void setSubject_matter(String subject_matter) {
        this.subject_matter = subject_matter;
    }
}
