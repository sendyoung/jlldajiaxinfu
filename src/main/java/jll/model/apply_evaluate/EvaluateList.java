package jll.model.apply_evaluate;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 评价榜单
 * */
@Entity(name="eva_evaluate_list")
public class EvaluateList extends Base_Model {
    private String evaluate_list_id;//评价榜单ID
    private String title;//标题
    private String content;//内容
    private String org_id;//组织ID

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getEvaluate_list_id() {
        return evaluate_list_id;
    }

    public void setEvaluate_list_id(String evaluate_list_id) {
        this.evaluate_list_id = evaluate_list_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOrg_id() {
        return org_id;
    }

    public void setOrg_id(String org_id) {
        this.org_id = org_id;
    }
}
