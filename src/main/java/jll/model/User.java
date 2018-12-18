package jll.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 用户表
 */
@Entity(name = "org_user_account")
public class User extends Base_Model {

    /**
     * 主键id
     **/
    private String user_id;

    /**
     * 真实姓名
     */
    private String realname;

    /**
     * 身份证号码
     */
    private String idcard;

    /**
     * 密码
     **/
    private String password;

    /**
     * 认证id
     **/
    private String authentication_id;

    /**
     * 认证类型
     * 0、未认证
     * 1、企业认证审核中
     * 2、企业已认证
     * 3、组织认证审核中
     * 4、组织已认证
     **/
    private String authentication_type;

    /**
     * 用户详情外键
     **/
    private String user_detail_id;

    /**
     * 手机号
     **/
    private String iphone;

    /**
     * 昵称
     **/
    private String nickname;

    /**
     * 邮箱
     **/
    private String email;

    /**
     * 用户名
     **/
    private String username;

    /**
     * 省
     **/
    private int province_id;

    /**
     * 性别
     **/
    private String sex;

    /**
     * 市
     **/
    private int city_id;

    /**
     * 区
     **/
    private int area_id;

    /**
     * 联系地址
     **/
    private String address;

    /**
     * 头像
     **/
    private String head_portrait_image;

    /**
     * 用户类型
     * 默认为1
     * 1 个人用户
     * 2 企业用户
     * 3 组织用户
     **/
    private String org_user_role_middle;

    /**
     * 工作经历
     **/
    private String work_experience;

    /**
     * 自我介绍
     **/
    private String self_introduction;

    /**
     * 个人签名
     */
    private String personalSignature;


    @Id
    @GenericGenerator(name = "systemUUID", strategy = "uuid")
    @GeneratedValue(generator = "systemUUID")
    public String getUser_id() {
        return user_id;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public void setUser_id(String user_id) {
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

    public String getPersonalSignature() {
        return personalSignature;
    }

    public void setPersonalSignature(String personalSignature) {
        this.personalSignature = personalSignature;
    }


}
