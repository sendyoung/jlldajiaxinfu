package jll.model.BasicPnformationSubmit;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 对外担保信息
 */
@Entity(name = "ent_external_guarantee")
public class ExternalGuaranteeInformation extends Base_Model {

    // 主键
    private String id;
    // 企业id
    private String ent_id;
    //被担保方
    private String secured_party;
    //担保方式
    private String guaranty_style;
    //担保金额
    private String amount_guaranteed;
    //与被担保方关系
    private String relationship_guaranteed_party;
    //担保时间
    private Date guarantee_time;
    //状态
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

    public String getSecured_party() {
        return secured_party;
    }

    public void setSecured_party(String secured_party) {
        this.secured_party = secured_party;
    }

    public String getGuaranty_style() {
        return guaranty_style;
    }

    public void setGuaranty_style(String guaranty_style) {
        this.guaranty_style = guaranty_style;
    }

    public String getAmount_guaranteed() {
        return amount_guaranteed;
    }

    public void setAmount_guaranteed(String amount_guaranteed) {
        this.amount_guaranteed = amount_guaranteed;
    }

    public String getRelationship_guaranteed_party() {
        return relationship_guaranteed_party;
    }

    public void setRelationship_guaranteed_party(String relationship_guaranteed_party) {
        this.relationship_guaranteed_party = relationship_guaranteed_party;
    }

    public Date getGuarantee_time() {
        return guarantee_time;
    }

    public void setGuarantee_time(Date guarantee_time) {
        this.guarantee_time = guarantee_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
