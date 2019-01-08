package jll.model.basic_pnformation_submit;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 债权融资
 */
@Entity(name = "ent_bond_financing")
public class BondFinancing extends Base_Model {
    // 主键
    private String id;
    // 企业id
    private String ent_id;
    // 机构名称
    private String organization_names ;
    // 机构类型
    private String institutional_type;
    // 抵押/信用贷款
    private String mortgage_credit;
    // 借贷金额
    private String borrowing_amount;

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

    public String getOrganization_names() {
        return organization_names;
    }

    public void setOrganization_names(String organization_names) {
        this.organization_names = organization_names;
    }

    public String getInstitutional_type() {
        return institutional_type;
    }

    public void setInstitutional_type(String institutional_type) {
        this.institutional_type = institutional_type;
    }

    public String getMortgage_credit() {
        return mortgage_credit;
    }

    public void setMortgage_credit(String mortgage_credit) {
        this.mortgage_credit = mortgage_credit;
    }

    public String getBorrowing_amount() {
        return borrowing_amount;
    }

    public void setBorrowing_amount(String borrowing_amount) {
        this.borrowing_amount = borrowing_amount;
    }
}
