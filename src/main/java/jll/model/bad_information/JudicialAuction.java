package jll.model.bad_information;

import jll.model.InformationPrivided;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 司法拍卖
 * */
@Entity(name="ent_judicial_auction")
public class JudicialAuction extends InformationPrivided {
    private String judicial_auction_id;//ID
    private String name;//名称
    private Float money;//起拍价
    private Date publish_date;//拍卖时间
    private String execute_court;//委托法院

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getJudicial_auction_id() {
        return judicial_auction_id;
    }

    public void setJudicial_auction_id(String judicial_auction_id) {
        this.judicial_auction_id = judicial_auction_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public Date getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(Date publish_date) {
        this.publish_date = publish_date;
    }

    public String getExecute_court() {
        return execute_court;
    }

    public void setExecute_court(String execute_court) {
        this.execute_court = execute_court;
    }
}
