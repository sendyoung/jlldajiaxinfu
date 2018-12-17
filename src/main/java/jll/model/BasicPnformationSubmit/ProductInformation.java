package jll.model.BasicPnformationSubmit;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 产品信息
 */
@Entity(name = "ent_product")
public class ProductInformation extends Base_Model {

    // 主键
    private String id;
    // 企业id
    private String ent_id;
    // 产品名称
    private String product_name;
    // 产品简称
    private String product_for_short;
    // 产品分类
    private String product_classification;
    // 领域
    private String domain;
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

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_for_short() {
        return product_for_short;
    }

    public void setProduct_for_short(String product_for_short) {
        this.product_for_short = product_for_short;
    }

    public String getProduct_classification() {
        return product_classification;
    }

    public void setProduct_classification(String product_classification) {
        this.product_classification = product_classification;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
