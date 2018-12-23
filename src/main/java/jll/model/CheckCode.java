package jll.model;

import javax.persistence.Entity;

@Entity(name = "check_code")
public class CheckCode {

    private String code_id;//校验码id
    private String code_value;//校验码数据
    

    public String getCode_id() {
        return code_id;
    }

    public void setCode_id(String code_id) {
        this.code_id = code_id;
    }

    public String getCode_value() {
        return code_value;
    }

    public void setCode_value(String code_value) {
        this.code_value = code_value;
    }
}
