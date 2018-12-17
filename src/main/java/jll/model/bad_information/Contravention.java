package jll.model.bad_information;

import jll.model.InformationPrivided;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 欠税公告
 * */
@Entity(name="ent_contravention")
public class Contravention extends InformationPrivided {
    private String contravention_id;//ID
    private String reference;//纳税识别号
    private String name;//纳税人名称
    private String representative;//法定代表人
    private String stype;//欠税税种:1、企业所得税2、增值税3、教育费附加4、地方教育附加 5、其他政府性基金收入6、营业税7、城建税 8、土地增值税9、土地使用税10、契税11、房产税12、印花税 13、个人所得税
    private Float amount;//税额

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getContravention_id() {
        return contravention_id;
    }

    public void setContravention_id(String contravention_id) {
        this.contravention_id = contravention_id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRepresentative() {
        return representative;
    }

    public void setRepresentative(String representative) {
        this.representative = representative;
    }

    public String getStype() {
        return stype;
    }

    public void setStype(String stype) {
        this.stype = stype;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }
}
