package jll.model.userdetail;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 工作履历
 */
@Entity(name="org_user_workplace")
public class UserWorkPlace extends Base_Model {

    private String user_workplace_id;//主键
    private String user_detail_id;//用户详情表主键
    private int si_years;//司龄
    private int this_industry_years;//这个行业年限
    private String honor;//获取的荣誉
    private String company_name;//工作单位
    private String department;//所属部门
    private String position;//职位
    private String title;//职称
    private String superior_username;//上级姓名
    private int subordinate_team_num;//下属团队人数
    private double salary;//工资
    private int working_years;//工作年限
    private Date work_start_date;//工作开始时间
    private Date word_end_date;//工作结束时间

    @Id
    @GenericGenerator(name = "systemUUID", strategy = "uuid")
    @GeneratedValue(generator = "systemUUID")
    public String getUser_workplace_id() {
        return user_workplace_id;
    }

    public void setUser_workplace_id(String user_workplace_id) {
        this.user_workplace_id = user_workplace_id;
    }

    public String getUser_detail_id() {
        return user_detail_id;
    }

    public void setUser_detail_id(String user_detail_id) {
        this.user_detail_id = user_detail_id;
    }

    public int getSi_years() {
        return si_years;
    }

    public void setSi_years(int si_years) {
        this.si_years = si_years;
    }

    public int getThis_industry_years() {
        return this_industry_years;
    }

    public void setThis_industry_years(int this_industry_years) {
        this.this_industry_years = this_industry_years;
    }

    public String getHonor() {
        return honor;
    }

    public void setHonor(String honor) {
        this.honor = honor;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSuperior_username() {
        return superior_username;
    }

    public void setSuperior_username(String superior_username) {
        this.superior_username = superior_username;
    }

    public int getSubordinate_team_num() {
        return subordinate_team_num;
    }

    public void setSubordinate_team_num(int subordinate_team_num) {
        this.subordinate_team_num = subordinate_team_num;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getWorking_years() {
        return working_years;
    }

    public void setWorking_years(int working_years) {
        this.working_years = working_years;
    }

    public Date getWork_start_date() {
        return work_start_date;
    }

    public void setWork_start_date(Date work_start_date) {
        this.work_start_date = work_start_date;
    }

    public Date getWord_end_date() {
        return word_end_date;
    }

    public void setWord_end_date(Date word_end_date) {
        this.word_end_date = word_end_date;
    }
}
