package jll.model.contract;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 企业跟组织签订合同
 * */
@Entity(name = "ent_to_org_contract")
public class EntToOrgContract extends Base_Model {
    private String to_org_contract_id;
    private String org_contract_id;//组织合同ID
    private String auth_enterprise_id;//企业认证Id

    @Id
    @GenericGenerator(name = "systemUUID", strategy = "uuid")
    @GeneratedValue(generator = "systemUUID")
    public String getTo_org_contract_id() {
        return to_org_contract_id;
    }

    public void setTo_org_contract_id(String to_org_contract_id) {
        this.to_org_contract_id = to_org_contract_id;
    }


    public String getOrg_contract_id() {
        return org_contract_id;
    }

    public void setOrg_contract_id(String org_contract_id) {
        this.org_contract_id = org_contract_id;
    }

    public String getAuth_enterprise_id() {
        return auth_enterprise_id;
    }

    public void setAuth_enterprise_id(String auth_enterprise_id) {
        this.auth_enterprise_id = auth_enterprise_id;
    }
}
