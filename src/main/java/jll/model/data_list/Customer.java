package jll.model.data_list;

import jll.model.InformationPrivided;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 客户信息
 * */
@Entity(name = "ent_customer")
public class Customer extends InformationPrivided {
    private String customer_id;
    private String name;//企业名称
    private String redit_no;//社会统一信用代码
    private String representative;//法定代表人
    private Float register_capital;//注册资本
    private Float paid_capital;//实缴资本
    private Date publish_date;//成立日期
    private String stype;//公司类型：1股份有限公司2有限责任公司3其他有限责任公司4其他股份有限公司
    private String industry_code;//所属行业代码
    private Date approve_date;//核准日期
    private String administration;//登记机关
    private Integer claff_sum;//人员规模
    private String registered_address;//注册地址
    private String business_scope;//经营范围
    private Date start_date;//起始日期
    private Date end_date;//结束日期

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getCustomer_id() {
        return customer_id;
    }
    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRedit_no() {
        return redit_no;
    }

    public void setRedit_no(String redit_no) {
        this.redit_no = redit_no;
    }

    public String getRepresentative() {
        return representative;
    }

    public void setRepresentative(String representative) {
        this.representative = representative;
    }

    public Float getRegister_capital() {
        return register_capital;
    }

    public void setRegister_capital(Float register_capital) {
        this.register_capital = register_capital;
    }

    public Float getPaid_capital() {
        return paid_capital;
    }

    public void setPaid_capital(Float paid_capital) {
        this.paid_capital = paid_capital;
    }

    public Date getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(Date publish_date) {
        this.publish_date = publish_date;
    }

    public String getStype() {
        return stype;
    }

    public void setStype(String stype) {
        this.stype = stype;
    }

    public String getIndustry_code() {
        return industry_code;
    }

    public void setIndustry_code(String industry_code) {
        this.industry_code = industry_code;
    }

    public Date getApprove_date() {
        return approve_date;
    }

    public void setApprove_date(Date approve_date) {
        this.approve_date = approve_date;
    }

    public String getAdministration() {
        return administration;
    }

    public void setAdministration(String administration) {
        this.administration = administration;
    }

    public Integer getClaff_sum() {
        return claff_sum;
    }

    public void setClaff_sum(Integer claff_sum) {
        this.claff_sum = claff_sum;
    }

    public String getRegistered_address() {
        return registered_address;
    }

    public void setRegistered_address(String registered_address) {
        this.registered_address = registered_address;
    }

    public String getBusiness_scope() {
        return business_scope;
    }

    public void setBusiness_scope(String business_scope) {
        this.business_scope = business_scope;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }
}
