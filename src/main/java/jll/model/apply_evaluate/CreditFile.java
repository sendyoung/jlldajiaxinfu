package jll.model.apply_evaluate;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 企业信用档案
 * */
@Entity(name="eva_credit_file")
public class CreditFile extends Base_Model {
    private String credit_file_id;
    private String auth_enterprise_id;//企业ID
    private String doc_url;//档案url
    private String doc_name;//档案名称
    private String doc_remark;//档案备注

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getCredit_file_id() {
        return credit_file_id;
    }

    public void setCredit_file_id(String credit_file_id) {
        this.credit_file_id = credit_file_id;
    }

    public String getAuth_enterprise_id() {
        return auth_enterprise_id;
    }

    public void setAuth_enterprise_id(String auth_enterprise_id) {
        this.auth_enterprise_id = auth_enterprise_id;
    }

    public String getDoc_url() {
        return doc_url;
    }

    public void setDoc_url(String doc_url) {
        this.doc_url = doc_url;
    }

    public String getDoc_name() {
        return doc_name;
    }

    public void setDoc_name(String doc_name) {
        this.doc_name = doc_name;
    }

    public String getDoc_remark() {
        return doc_remark;
    }

    public void setDoc_remark(String doc_remark) {
        this.doc_remark = doc_remark;
    }
}
