package jll.model.data_list;

import jll.model.InformationPrivided;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 主要技术设备
 * */
@Entity(name = "ent_main_technical_equipment")
public class MainTechnicalEquipment extends InformationPrivided {
    private String main_technical_equipment_id;//
    private String name;//设备名
    private Integer period;//年度
    private Integer amount;//数量（台）
    private Float original_price;//固定资产原价(元）
    private Float depreciation;//累计折旧（元）
    private Float value;//固定资产净值（元）

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getMain_technical_equipment_id() {
        return main_technical_equipment_id;
    }

    public void setMain_technical_equipment_id(String main_technical_equipment_id) {
        this.main_technical_equipment_id = main_technical_equipment_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Float getOriginal_price() {
        return original_price;
    }

    public void setOriginal_price(Float original_price) {
        this.original_price = original_price;
    }

    public Float getDepreciation() {
        return depreciation;
    }

    public void setDepreciation(Float depreciation) {
        this.depreciation = depreciation;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }
}
