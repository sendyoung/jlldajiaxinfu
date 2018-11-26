package jll.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "org_user_account")
public class User {


    /**主键id**/
    private int user_id;

    /**密码**/
    private String password;

    /**认证id**/
    private String authentication_id;

    /**认证类型
     0、企业
     1、组织
     **/
    private String authentication_type;

    /**用户详情外键**/
    private String user_detail_id;

    /**手机号**/
    private String iphone;

    /**昵称**/
    private String nickname;

    /**邮箱**/
    private String email;

    /**用户名**/
    private String username;

    /**省**/
    private int province_id;

    /**创建时间**/
    private Date create_time;

    /**性别**/
    private String sex;

    /**市**/
    private int city_id;

    /**区**/
    private int area_id;

    /**联系地址**/
    private String address;

    /**头像**/
    private String head_portrait_image;

    /**用户类型
     *  默认为0  未定义
     * 1 个人用户
     * 2 企业用户
     * 3 组织用户
     * **/
    private String org_user_role_middle;

    /**工作经历**/
    private String work_experience;

    /**自我介绍**/
    private String self_introduction;

    /**更新时间**/
    private Date update_time;

    /**是否删除**/
    private String isDelete;


    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthentication_id() {
        return authentication_id;
    }

    public void setAuthentication_id(String authentication_id) {
        this.authentication_id = authentication_id;
    }

    public String getAuthentication_type() {
        return authentication_type;
    }

    public void setAuthentication_type(String authentication_type) {
        this.authentication_type = authentication_type;
    }

    public String getUser_detail_id() {
        return user_detail_id;
    }

    public void setUser_detail_id(String user_detail_id) {
        this.user_detail_id = user_detail_id;
    }

    public String getIphone() {
        return iphone;
    }

    public void setIphone(String iphone) {
        this.iphone = iphone;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getProvince_id() {
        return province_id;
    }

    public void setProvince_id(int province_id) {
        this.province_id = province_id;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public int getArea_id() {
        return area_id;
    }

    public void setArea_id(int area_id) {
        this.area_id = area_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHead_portrait_image() {
        return head_portrait_image;
    }

    public void setHead_portrait_image(String head_portrait_image) {
        this.head_portrait_image = head_portrait_image;
    }

    public String getOrg_user_role_middle() {
        return org_user_role_middle;
    }

    public void setOrg_user_role_middle(String org_user_role_middle) {
        this.org_user_role_middle = org_user_role_middle;
    }

    public String getWork_experience() {
        return work_experience;
    }

    public void setWork_experience(String work_experience) {
        this.work_experience = work_experience;
    }

    public String getSelf_introduction() {
        return self_introduction;
    }

    public void setSelf_introduction(String self_introduction) {
        this.self_introduction = self_introduction;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    /**备注**/
    private String comment;



}
