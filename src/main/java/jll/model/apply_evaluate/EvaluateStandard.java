package jll.model.apply_evaluate;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 评分标准
 * */
@Entity(name="eva_evaluate_standard")
public class EvaluateStandard extends Base_Model {
    private String standard_id;//标准ID
    private String standard_name;//标准名称
    private String weight;//权重
    private String parent_id;//父级ID
    private String is_son;//有无子节点
    private String stype;//类型：定量，定性
    private String auth_org_id;//组织ID
    private String operation_type;//性质类型，-1扣分项，1加分项
    private String calculate_type;//计算类型：1 区间型 ，2 判断型，3 计算型，4 其他型
    private String seq;//排列顺序

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getStandard_id() {
        return standard_id;
    }

    public void setStandard_id(String standard_id) {
        this.standard_id = standard_id;
    }

    public String getStandard_name() {
        return standard_name;
    }

    public void setStandard_name(String standard_name) {
        this.standard_name = standard_name;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public String getIs_son() {
        return is_son;
    }

    public void setIs_son(String is_son) {
        this.is_son = is_son;
    }

    public String getStype() {
        return stype;
    }

    public void setStype(String stype) {
        this.stype = stype;
    }

    public String getAuth_org_id() {
        return auth_org_id;
    }

    public void setAuth_org_id(String auth_org_id) {
        this.auth_org_id = auth_org_id;
    }

    public String getOperation_type() {
        return operation_type;
    }

    public void setOperation_type(String operation_type) {
        this.operation_type = operation_type;
    }

    public String getCalculate_type() {
        return calculate_type;
    }

    public void setCalculate_type(String calculate_type) {
        this.calculate_type = calculate_type;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }
}
