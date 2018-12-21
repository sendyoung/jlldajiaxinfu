package jll.message.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import com.cn.zyzs.hibernate.util.Page;
import com.cn.zyzs.hibernate.util.PageContext;
import jll.model.message.OrgSendMessage;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SendMessageDao extends SimpleHibernateTemplate<OrgSendMessage> {

    /**
     * 查询发送的所有类别的消息列表
     */
    public Page findSendMessageList(String senderId) {
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT                                                                                      ");
        sql.append(" 	sendMessage.send_message_id,sendMessage.send_id,sendMessage.sender_name,sendMessage.receiver_id,sendMessage.receiver_name,sendMessage.message_title,sendMessage.send_type,sendMessage.message_type,sendMessage.message_status,sendMessage.create_time                                                                             ");
        sql.append(" FROM                                                                                        ");
        sql.append(" 	org_send_message sendMessage                                                                ");
        sql.append(" WHERE                                                                                       ");
        sql.append(" 1 = 1        ");
        sql.append(" AND sendMessage.isDelete = '0'                                                                                      ");
        sql.append(" AND sendMessage .sender_id = '" + senderId + "'                                                               ");

        return sqlqueryForpage1(sql.toString(), null, PageContext.getPageSize(), PageContext.getOffSet(), null);
    }

    /**
     *根据消息ID查询消息详情
     */
    public List findSendMessage(String sendMessageId){
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT      ");
        sql.append("   sendMessage.*     ");
        sql.append("  FROM    org_send_message sendMessage     ");
        sql.append(" WHERE      1=1         ");
        sql.append(" AND sendMessage.isDelete = '0'  ");
        sql.append(" AND sendMessage.send_message_id = '" + sendMessageId + "'   ");

        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }


    /**
     * 在发件箱中插入数据
     */
    public void addSendMessage(OrgSendMessage sendMessage){
        this.getSession().save(sendMessage);
    }
}
