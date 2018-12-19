package jll.message.service.impl;

import jll.message.dao.ReceiveMessageDao;
import jll.message.dao.SendMessageDao;
import jll.message.service.MessageService;
import jll.model.message.OrgReceiveMessage;
import jll.model.message.OrgSendMessage;
import jll.utils.HibernatePageUtil;
import jll.utils.MapTrunPojo;
import jll.utils.XinfuResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private ReceiveMessageDao receiveMessageDao;
    @Autowired
    private SendMessageDao sendMessageDao;

    //查看发件箱列表
    @Override
    public Object findSendMessageList(String userId,int currentPage,int rows) {
        return HibernatePageUtil.sqlPageUtil(sendMessageDao.findSendMessageList(userId),currentPage,rows);
    }

    //查看发件内容
    @Override
    public OrgSendMessage findSendMessage(String sendMessageId) {
        List list = sendMessageDao.findSendMessage(sendMessageId);
        if(list!=null&&list.size()>0){
            Map map = (Map) list.get(0);
            OrgSendMessage orgSendMessage = (OrgSendMessage)MapTrunPojo.map2Object(map, OrgSendMessage.class);
            return orgSendMessage;
        }
        return null;
    }

    //查看收件箱列表
    @Override
    public Object findReceiveMessageList(String userId,int currentPage,int rows) {
       return HibernatePageUtil.sqlPageUtil(receiveMessageDao.findReceiveMessageList(userId),currentPage,rows);
    }

    //查看收件详情
    @Override
    public OrgReceiveMessage findReceiveMessage(String receiveMessageId) {
       List list = receiveMessageDao.findReceiveMessage(receiveMessageId);
        if(list!=null&&list.size()>0){
            Map map = (Map) list.get(0);
            OrgReceiveMessage orgReceiveMessage = (OrgReceiveMessage)MapTrunPojo.map2Object(map, OrgReceiveMessage.class);
            return orgReceiveMessage;
        }
        return null;
    }

    //
    @Override
    public XinfuResult sendReceiveMessage(String id) {
        return null;
    }
}
