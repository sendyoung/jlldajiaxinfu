package jll.model.good_information;

import jll.model.InformationPrivided;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 表彰
 * */
@Entity(name="ent_honor")
public class Honor extends InformationPrivided {
    private String honor_id;//表彰ID
    private String national_awards;//国家奖项
    private String provincial_awards;//省级奖项
    private String municipal_awards;//市级奖项
    private String county_awards;//县级奖项
    private String activities;//活动

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getHonor_id() {
        return honor_id;
    }

    public void setHonor_id(String honor_id) {
        this.honor_id = honor_id;
    }

    public String getNational_awards() {
        return national_awards;
    }

    public void setNational_awards(String national_awards) {
        this.national_awards = national_awards;
    }

    public String getProvincial_awards() {
        return provincial_awards;
    }

    public void setProvincial_awards(String provincial_awards) {
        this.provincial_awards = provincial_awards;
    }

    public String getMunicipal_awards() {
        return municipal_awards;
    }

    public void setMunicipal_awards(String municipal_awards) {
        this.municipal_awards = municipal_awards;
    }

    public String getCounty_awards() {
        return county_awards;
    }

    public void setCounty_awards(String county_awards) {
        this.county_awards = county_awards;
    }

    public String getActivities() {
        return activities;
    }

    public void setActivities(String activities) {
        this.activities = activities;
    }
}
