package jll.model.data_list;

import jll.model.InformationPrivided;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 利润
 * */
@Entity(name = "ent_income_statement")
public class IncomeStatement extends InformationPrivided {
    private String income_statement_id;
    private String account_name;//科目名称
    private String account_code;//科目代码
    private Double account_value;//值
    private String period;//年度

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getIncome_statement_id() {
        return income_statement_id;
    }

    public void setIncome_statement_id(String income_statement_id) {
        this.income_statement_id = income_statement_id;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public String getAccount_code() {
        return account_code;
    }

    public void setAccount_code(String account_code) {
        this.account_code = account_code;
    }

    public Double getAccount_value() {
        return account_value;
    }

    public void setAccount_value(Double account_value) {
        this.account_value = account_value;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }
}
