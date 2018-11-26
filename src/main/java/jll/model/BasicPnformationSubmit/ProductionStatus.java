package jll.model.BasicPnformationSubmit;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *  生产情况
 */
@Entity(name = "ent_production_status")
public class ProductionStatus  extends Base_Model {

    // 主键
    private String id;
    // 企业id
    private String ent_id;
    // 最大年产量
    private String maximum_annual_output;
    // 市场占有率
    private String market_share;
    // 产品种类
    private String type_of_production;
    // 万元产值废弃物COD排放量
    private String cod_emission_per_output_value;
    // 吨产品平均取水量
    private String average_water_withdrawal;
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

    public String getMaximum_annual_output() {
        return maximum_annual_output;
    }

    public void setMaximum_annual_output(String maximum_annual_output) {
        this.maximum_annual_output = maximum_annual_output;
    }

    public String getMarket_share() {
        return market_share;
    }

    public void setMarket_share(String market_share) {
        this.market_share = market_share;
    }

    public String getType_of_production() {
        return type_of_production;
    }

    public void setType_of_production(String type_of_production) {
        this.type_of_production = type_of_production;
    }

    public String getCod_emission_per_output_value() {
        return cod_emission_per_output_value;
    }

    public void setCod_emission_per_output_value(String cod_emission_per_output_value) {
        this.cod_emission_per_output_value = cod_emission_per_output_value;
    }

    public String getAverage_water_withdrawal() {
        return average_water_withdrawal;
    }

    public void setAverage_water_withdrawal(String average_water_withdrawal) {
        this.average_water_withdrawal = average_water_withdrawal;
    }
}
