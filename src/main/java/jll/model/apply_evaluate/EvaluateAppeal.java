package jll.model.apply_evaluate;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 评价申诉
 * */
@Entity(name="eva_evaluate_appeal")
public class EvaluateAppeal extends Base_Model {
    private String evaluate_appeal_id;//评价申诉ID
    private String apply_evaluate_id;//申请评价ID
    private String stype;//申诉类型  1 资料有误 2 补全信息 3 恶意诋毁 4 其他
    private String status;//申诉状态
    private Date date;//申诉时间
    private String details;//申诉详情
    private String evidence;//证据
    private String appeal_title;//申诉标题
    private String objection_title;//异议标题
    private String handler;//处理人
    private String handle_material;//处理材料
    private String handle_content;//处理批语

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getEvaluate_appeal_id() {
        return evaluate_appeal_id;
    }

    public void setEvaluate_appeal_id(String evaluate_appeal_id) {
        this.evaluate_appeal_id = evaluate_appeal_id;
    }

    public String getApply_evaluate_id() {
        return apply_evaluate_id;
    }

    public void setApply_evaluate_id(String apply_evaluate_id) {
        this.apply_evaluate_id = apply_evaluate_id;
    }

    public String getStype() {
        return stype;
    }

    public void setStype(String stype) {
        this.stype = stype;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getEvidence() {
        return evidence;
    }

    public void setEvidence(String evidence) {
        this.evidence = evidence;
    }

    public String getAppeal_title() {
        return appeal_title;
    }

    public void setAppeal_title(String appeal_title) {
        this.appeal_title = appeal_title;
    }

    public String getObjection_title() {
        return objection_title;
    }

    public void setObjection_title(String objection_title) {
        this.objection_title = objection_title;
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    public String getHandle_material() {
        return handle_material;
    }

    public void setHandle_material(String handle_material) {
        this.handle_material = handle_material;
    }

    public String getHandle_content() {
        return handle_content;
    }

    public void setHandle_content(String handle_content) {
        this.handle_content = handle_content;
    }
}
