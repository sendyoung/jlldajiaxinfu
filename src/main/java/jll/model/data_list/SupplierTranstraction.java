package jll.model.data_list;

import jll.model.InformationPrivided;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 供应商年度交易信息
 * */
@Entity(name = "ent_supplier_transtraction")
public class SupplierTranstraction extends InformationPrivided {
    private String supplier_transtraction_id;
    private String supplier_id;//供应商信息
    private String commodity;//商品名称
    private Float quantity;//商品数量
    private String unit;//单位
    private Integer period;//年度
    private Float average_price;//均价
    private Float amount;//商品额
    private String payment_method;//付款方式

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getSupplier_transtraction_id() {
        return supplier_transtraction_id;
    }

    public void setSupplier_transtraction_id(String supplier_transtraction_id) {
        this.supplier_transtraction_id = supplier_transtraction_id;
    }

    public String getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(String supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getCommodity() {
        return commodity;
    }

    public void setCommodity(String commodity) {
        this.commodity = commodity;
    }

    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Float getAverage_price() {
        return average_price;
    }

    public void setAverage_price(Float average_price) {
        this.average_price = average_price;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }
}
