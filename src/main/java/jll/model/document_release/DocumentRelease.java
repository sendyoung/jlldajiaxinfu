package jll.model.document_release;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 公文发布表
 */
@Entity(name="org_document_release")
public class DocumentRelease extends Base_Model {
    private String document_id;//公文主键
    private String auth_org_id;//组织认证id
    private String document_title;//公文标题
    private String document_content;//公文内容
    private String document_status;//公文状态 0草稿 1状态  2撤回

    @Id
    @GenericGenerator(name = "systemUUID", strategy = "uuid")
    @GeneratedValue(generator = "systemUUID")
    public String getDocument_id() {
        return document_id;
    }

    public void setDocument_id(String document_id) {
        this.document_id = document_id;
    }

    public String getAuth_org_id() {
        return auth_org_id;
    }

    public void setAuth_org_id(String auth_org_id) {
        this.auth_org_id = auth_org_id;
    }

    public String getDocument_title() {
        return document_title;
    }

    public void setDocument_title(String document_title) {
        this.document_title = document_title;
    }

    public String getDocument_content() {
        return document_content;
    }

    public void setDocument_content(String document_content) {
        this.document_content = document_content;
    }

    public String getDocument_status() {
        return document_status;
    }

    public void setDocument_status(String document_status) {
        this.document_status = document_status;
    }
}
