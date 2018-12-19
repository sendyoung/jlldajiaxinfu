package jll.message.service;

import jll.model.message.OrgReceiveMessage;
import jll.model.message.OrgSendMessage;
import jll.utils.XinfuResult;

public interface MessageService {
    //查看发件箱列表
    public Object findSendMessageList(String userId,int currentPage,int rows);
    //查看发件箱内容
    public OrgSendMessage findSendMessage(String sendMessageId);
    //查看收件箱列表
    public Object findReceiveMessageList(String id,int currentPage,int rows);
    //查看收件箱内容
    public OrgReceiveMessage findReceiveMessage(String receiveMessageId);
    //发送消息
    public XinfuResult sendReceiveMessage(String id);
}
