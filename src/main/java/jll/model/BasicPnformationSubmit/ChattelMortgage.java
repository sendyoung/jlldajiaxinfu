package jll.model.BasicPnformationSubmit;


import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 动产抵押
 */
@Entity(name = "ent_chattel_mortgage")
public class ChattelMortgage extends Base_Model {
    // 主键
    private String id;
    // 企业id
    private String ent_id;
    // 登记编号
    private String registration_number;
    // 登记日期
    private Date record_date;
    // 登记机关
    private String record_office;
    // 被担保债权数额
    private String amount_claims_secured;
    // 状态
    private String status;

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEnt_id() {
        return ent_id;
    }

    public void setEnt_id(String ent_id) {
        this.ent_id = ent_id;
    }

    public String getRegistration_number() {
        return registration_number;
    }

    public void setRegistration_number(String registration_number) {
        this.registration_number = registration_number;
    }

    public Date getRecord_date() {
        return record_date;
    }

    public void setRecord_date(Date record_date) {
        this.record_date = record_date;
    }

    public String getRecord_office() {
        return record_office;
    }

    public void setRecord_office(String record_office) {
        this.record_office = record_office;
    }

    public String getAmount_claims_secured() {
        return amount_claims_secured;
    }

    public void setAmount_claims_secured(String amount_claims_secured) {
        this.amount_claims_secured = amount_claims_secured;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
