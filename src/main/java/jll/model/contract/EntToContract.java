package jll.model.contract;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 企业跟组织签订合同
 * */
@Entity(name = "ent_to_contract")
public class EntToContract extends Base_Model {
    private String to_contract_id;
    private String contract_id;//平台合同ID
    private String auth_enterprise_id;//企业认证Id

    @Id
    @GenericGenerator(name = "systemUUID", strategy = "uuid")
    @GeneratedValue(generator = "systemUUID")
    public String getTo_contract_id() {
        return to_contract_id;
    }

    public void setTo_contract_id(String to_contract_id) {
        this.to_contract_id = to_contract_id;
    }

    public String getContract_id() {
        return contract_id;
    }

    public void setContract_id(String contract_id) {
        this.contract_id = contract_id;
    }

    public String getAuth_enterprise_id() {
        return auth_enterprise_id;
    }

    public void setAuth_enterprise_id(String auth_enterprise_id) {
        this.auth_enterprise_id = auth_enterprise_id;
    }
}
