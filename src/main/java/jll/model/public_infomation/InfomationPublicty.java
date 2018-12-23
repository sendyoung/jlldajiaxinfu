package jll.model.public_infomation;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 信息公示表
 */
@Entity(name="org_infomation_publicty")
public class InfomationPublicty extends Base_Model {
    private String publicty_id;//信息公示主键id
    private String user_id;//用户ID
    private String title;//标题
    private String introduction;//简介
    private String publicty_type;//公示类型
    private Date start_time;//开始时间
    private Date end_time;//结束时间
    private String upload_data;//上传资料地址
    private String evaluate_list_id;//评价榜单id
    private String red_black_list_id;//红黑名单id

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getPublicty_id() {
        return publicty_id;
    }

    public void setPublicty_id(String publicty_id) {
        this.publicty_id = publicty_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getPublicty_type() {
        return publicty_type;
    }

    public void setPublicty_type(String publicty_type) {
        this.publicty_type = publicty_type;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public String getUpload_data() {
        return upload_data;
    }

    public void setUpload_data(String upload_data) {
        this.upload_data = upload_data;
    }

    public String getEvaluate_list_id() {
        return evaluate_list_id;
    }

    public void setEvaluate_list_id(String evaluate_list_id) {
        this.evaluate_list_id = evaluate_list_id;
    }

    public String getRed_black_list_id() {
        return red_black_list_id;
    }

    public void setRed_black_list_id(String red_black_list_id) {
        this.red_black_list_id = red_black_list_id;
    }
}
