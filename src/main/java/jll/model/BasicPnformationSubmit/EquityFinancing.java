package jll.model.BasicPnformationSubmit;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 股权融资
 */
@Entity(name = "ent_equity_financing")
public class EquityFinancing extends Base_Model {
    // 主键
    private String id;
    // 企业id
    private String ent_id;
    // 融资轮次
    private String financing_rounds;
    // 融资金额
    private String financing_amount;
    // 投资方
    private String investor;
    // 投资日期
    private Date date_investment;
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

    public String getFinancing_rounds() {
        return financing_rounds;
    }

    public void setFinancing_rounds(String financing_rounds) {
        this.financing_rounds = financing_rounds;
    }

    public String getFinancing_amount() {
        return financing_amount;
    }

    public void setFinancing_amount(String financing_amount) {
        this.financing_amount = financing_amount;
    }

    public String getInvestor() {
        return investor;
    }

    public void setInvestor(String investor) {
        this.investor = investor;
    }

    public Date getDate_investment() {
        return date_investment;
    }

    public void setDate_investment(Date date_investment) {
        this.date_investment = date_investment;
    }
}
