package jll.model.data_list;

import jll.model.InformationPrivided;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 研发投入
 * */
@Entity(name = "ent_research_input")
public class ResearchInput extends InformationPrivided {
    private String research_input_id;
    private Float research_input;//研发投入资金
    private Integer period;//年度
    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getResearch_input_id() {
        return research_input_id;
    }

    public void setResearch_input_id(String research_input_id) {
        this.research_input_id = research_input_id;
    }

    public Float getResearch_input() {
        return research_input;
    }

    public void setResearch_input(Float research_input) {
        this.research_input = research_input;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }
}
