package jll.model.basic_pnformation_submit;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 抽查检查信息
 */
@Entity(name = "ent_check")
public class Check extends Base_Model {
    // 主键
    private String id;
    // 企业id
    private String ent_id;
    // 检查实施机关
    private String inspection_implementation_authority;
    // 类型
    private String type;
    // 日期
    private Date date;
    // 结果
    private String result;

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

    public String getInspection_implementation_authority() {
        return inspection_implementation_authority;
    }

    public void setInspection_implementation_authority(String inspection_implementation_authority) {
        this.inspection_implementation_authority = inspection_implementation_authority;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
