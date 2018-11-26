package jll.model.BasicPnformationSubmit;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 创新能力
 */
@Entity(name = "ent_innovation_ability")
public class InnovationAbility extends Base_Model{
    // 主键
    private String id;
    // 企业id
    private String ent_id;
    // 近三年获得专利, 软件, 著作权数量
    private String general;
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

    public String getGeneral() {
        return general;
    }

    public void setGeneral(String general) {
        this.general = general;
    }
}
