package jll.model.message;

import jll.model.Base_Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 收信表
 */
@Entity(name="org_receive_message")
public class OrgReceiveMessage extends Base_Model {

    private String receive_message_id;//收件主键
    private String sender_id;//发送者ID
    private String sender_name;//发送者名称
    private String receiver_id;//接收者ID
    private String receiver_name;//接收者名称
    private String message_title;//消息标题
    private String message_content;//消息内容
    private String send_type;//发送类型(1组织对企业,2企业对组织,3群发等)
    private String message_status;//(消息状态0未读,1已读)
    private String message_type;//消息类型1申请评价2评价申诉3评价审核4消息提醒5会内通知6历史评价0系统消息

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getReceive_message_id() {
        return receive_message_id;
    }

    public void setReceive_message_id(String receive_message_id) {
        this.receive_message_id = receive_message_id;
    }

    public String getSender_id() {
        return sender_id;
    }

    public void setSender_id(String sender_id) {
        this.sender_id = sender_id;
    }

    public String getSender_name() {
        return sender_name;
    }

    public void setSender_name(String sender_name) {
        this.sender_name = sender_name;
    }

    public String getReceiver_id() {
        return receiver_id;
    }

    public void setReceiver_id(String receiver_id) {
        this.receiver_id = receiver_id;
    }

    public String getReceiver_name() {
        return receiver_name;
    }

    public void setReceiver_name(String receiver_name) {
        this.receiver_name = receiver_name;
    }

    public String getMessage_title() {
        return message_title;
    }

    public void setMessage_title(String message_title) {
        this.message_title = message_title;
    }

    public String getMessage_content() {
        return message_content;
    }

    public void setMessage_content(String message_content) {
        this.message_content = message_content;
    }

    public String getSend_type() {
        return send_type;
    }

    public void setSend_type(String send_type) {
        this.send_type = send_type;
    }

    public String getMessage_status() {
        return message_status;
    }

    public void setMessage_status(String message_status) {
        this.message_status = message_status;
    }

    public String getMessage_type() {
        return message_type;
    }

    public void setMessage_type(String message_type) {
        this.message_type = message_type;
    }
}
