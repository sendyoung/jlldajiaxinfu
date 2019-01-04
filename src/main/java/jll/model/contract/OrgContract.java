package jll.model.contract;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 组织合同
 * */
@Entity(name = "ent_org_contract")
public class OrgContract {
    private String org_contract_id;//组织合同ID
    private String auth_org_id;//组织ID
    private String content;//合同内容
    private String type;//合同类型  1 申请评价合同
    private String url;//合同材料

    @Id
    @GenericGenerator(name = "systemUUID", strategy = "uuid")
    @GeneratedValue(generator = "systemUUID")
    public String getOrg_contract_id() {
        return org_contract_id;
    }

    public void setOrg_contract_id(String org_contract_id) {
        this.org_contract_id = org_contract_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuth_org_id() {
        return auth_org_id;
    }

    public void setAuth_org_id(String auth_org_id) {
        this.auth_org_id = auth_org_id;
    }

    public String getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setType(String type) {
        this.type = type;
    }
}
