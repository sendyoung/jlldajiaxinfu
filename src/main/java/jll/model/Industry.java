package jll.model;

import java.util.List;

/**
 * 行业
 * */
public class Industry {
    private	String code;//行业编码
    private String description;//行业名称
    private List<Industry> industry;//附属行业

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Industry> getIndustry() {
        return industry;
    }

    public void setIndustry(List<Industry> industry) {
        this.industry = industry;
    }
}
