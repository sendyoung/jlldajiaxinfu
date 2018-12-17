package jll.model.data_list;

import jll.model.InformationPrivided;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 财务费用明细
 * */
@Entity(name="ent_financial_expenses")
public class FinancialExpenses extends InformationPrivided {
    private String financial_expenses_id;//
    private Integer period;//年度
    private Float interest_expense;//利息支出
    private Float service_charge;//手续费
    private Float other_charge;//其他费用

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getFinancial_expenses_id() {
        return financial_expenses_id;
    }

    public void setFinancial_expenses_id(String financial_expenses_id) {
        this.financial_expenses_id = financial_expenses_id;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Float getInterest_expense() {
        return interest_expense;
    }

    public void setInterest_expense(Float interest_expense) {
        this.interest_expense = interest_expense;
    }

    public Float getService_charge() {
        return service_charge;
    }

    public void setService_charge(Float service_charge) {
        this.service_charge = service_charge;
    }

    public Float getOther_charge() {
        return other_charge;
    }

    public void setOther_charge(Float other_charge) {
        this.other_charge = other_charge;
    }
}
