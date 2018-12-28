package jll.message.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import com.cn.zyzs.hibernate.util.Page;
import com.cn.zyzs.hibernate.util.PageContext;
import jll.model.message.OrgReceiveMessage;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class ReceiveMessageDao extends SimpleHibernateTemplate<OrgReceiveMessage> {

    /**
     * 根据接收id查询接受的所有类别的消息列表
     */
    public Page findReceiveMessageList(String receiverId) {
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT                                                                                      ");
        sql.append(" 	receiveMessage.receive_message_id,receiveMessage.sender_id,receiveMessage.sender_name,receiveMessage.receiver_id,receiveMessage.receiver_name,receiveMessage.message_title,receiveMessage.send_type,receiveMessage.message_status,receiveMessage.message_type,receiveMessage.create_time                                                                             ");
        sql.append(" FROM                                                                                        ");
        sql.append(" 	org_receive_message receiveMessage                                                                ");
        sql.append(" WHERE                                                                                       ");
        sql.append(" 1 = 1        ");
        sql.append(" AND receiveMessage.isDelete = '0'                                                                                      ");
        sql.append(" AND receiveMessage .receiver_id = '" + receiverId + "'                                                               ");
        sql.append(" ORDER BY create_time DESC ");

        return sqlqueryForpage1(sql.toString(), null, PageContext.getPageSize(), PageContext.getOffSet(), null);
    }

    /**
     * 根据消息id查看详情数据
     */
    public List findReceiveMessage(String receiveMessageId){
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT      ");
        sql.append("   receiveMessage.*     ");
        sql.append("  FROM    org_receive_message receiveMessage     ");
        sql.append(" WHERE      1=1         ");
        sql.append(" AND receiveMessage.isDelete = '0'  ");
        sql.append(" AND receiveMessage.receive_message_id = '" + receiveMessageId + "'   ");

        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }


    /**
     * 在收件箱中插入数据
     */
    public void addReceiveMessage(OrgReceiveMessage receiveMessage){
       // StringBuffer sql = new StringBuffer();
       // sql.append("INSERT INTO org_receive_message(receive_message_id,message_content,message_status,message_title,message_type,receiver_id,receiver_name,send_type,sender_id,sender_name,create_time) ");
        //sql.append("  VALUES('" + UUID.randomUUID().toString().replace("-","") + "','" + receiveMessage.getMessage_content() + "','" + receiveMessage.getMessage_status() + "','" + receiveMessage.getMessage_title() + "','" + receiveMessage.getMessage_type() + "','" + receiveMessage.getReceiver_id() + "','" + receiveMessage.getReceiver_name() + "','" + receiveMessage.getSend_type() + "','" + receiveMessage.getSender_id() + "','" + receiveMessage.getSender_name() + "',now()" );
        System.out.println("收件箱测试........................");
        this.getSession().save(receiveMessage);
    }

    /**
     * 更新收件箱消息状态
     */
    public int updateMessageStatus(String receive_message_id){
        StringBuffer sql = new StringBuffer();
        sql.append("UPDATE org_receive_message SET message_status = '1' WHERE receive_message_id = '" + receive_message_id + "' ");
        Query query = this.getSession().createSQLQuery(sql.toString());
        return query.executeUpdate();
    }

}
