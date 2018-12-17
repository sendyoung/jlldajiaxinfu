package jll.model.apply_evaluate;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 红黑名单榜单
 * */
@Entity(name="eva_red_black_list")
public class RedBlackList extends Base_Model {
    private String red_black_list_id;//榜单ID
    private String list_name;//名单名称
    private String list_content;//名单说明
    private String org_id;//组织ID
    private String period;//年度

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getRed_black_list_id() {
        return red_black_list_id;
    }

    public void setRed_black_list_id(String red_black_list_id) {
        this.red_black_list_id = red_black_list_id;
    }

    public String getList_name() {
        return list_name;
    }

    public void setList_name(String list_name) {
        this.list_name = list_name;
    }

    public String getList_content() {
        return list_content;
    }

    public void setList_content(String list_content) {
        this.list_content = list_content;
    }

    public String getOrg_id() {
        return org_id;
    }

    public void setOrg_id(String org_id) {
        this.org_id = org_id;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }
}
