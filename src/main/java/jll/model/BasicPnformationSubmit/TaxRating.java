package jll.model.BasicPnformationSubmit;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 纳税评级
 */
@Entity(name = "ent_tax_rating")
public class TaxRating extends Base_Model {

    // 主键
    private String id;
    // 企业id
    private String ent_id;
    // 纳税评级
    private String tax_rating;
    // 类型
    private String type;
    // 纳税人识别号
    private String tax_num;
    // 评价单位
    private String the_evaluation_unit;

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

    public String getTax_rating() {
        return tax_rating;
    }

    public void setTax_rating(String tax_rating) {
        this.tax_rating = tax_rating;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTax_num() {
        return tax_num;
    }

    public void setTax_num(String tax_num) {
        this.tax_num = tax_num;
    }

    public String getThe_evaluation_unit() {
        return the_evaluation_unit;
    }

    public void setThe_evaluation_unit(String the_evaluation_unit) {
        this.the_evaluation_unit = the_evaluation_unit;
    }
}
