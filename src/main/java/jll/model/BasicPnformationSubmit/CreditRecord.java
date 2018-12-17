package jll.model.BasicPnformationSubmit;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 信用记录
 */
@Entity(name = "ent_credit_record")
public class CreditRecord extends Base_Model {

    // 主键
    private String id;
    // 企业id
    private String ent_id;
    //近3年最新信用评价记录
    private String recent_3_years;
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

    public String getRecent_3_years() {
        return recent_3_years;
    }

    public void setRecent_3_years(String recent_3_years) {
        this.recent_3_years = recent_3_years;
    }


}
