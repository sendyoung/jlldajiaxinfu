package jll.model;

import java.util.List;

/**
 * 区域
 * */
public class Area {
    private String code;//地区代码
    private String full_name;//区域名称
    private List<Area> area;//附属区域

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public List<Area> getArea() {
        return area;
    }

    public void setArea(List<Area> area) {
        this.area = area;
    }
}
