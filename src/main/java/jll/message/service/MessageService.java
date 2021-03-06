package jll.message.service;

import com.cn.zyzs.utils.utils.PageView;
import jll.model.message.OrgReceiveMessage;
import jll.model.message.OrgSendMessage;
import jll.utils.XinfuResult;

import java.util.List;

public interface MessageService {
    //查看发件箱列表
    public PageView findSendMessageList(String userId,String messageType, int currentPage, int rows);
    //查看发件箱内容
    public OrgSendMessage findSendMessage(String sendMessageId);
    //查看收件箱列表
    public PageView findReceiveMessageList(String id,int currentPage,int rows);
    //查看收件箱内容
    public OrgReceiveMessage findReceiveMessage(String receiveMessageId);

    /**
     * 申请评价(关联)
     * 评价申诉
     * 历史评价
     * 以上两类消息是企业给组织发消息
     */
    public XinfuResult entToOrgMessage(String userId, String sendAuthId, String receiveAuthId,String messagetitle,String messagecontent,String messagetype);

    /**
     * 评价审核
     * 消息提醒
     * 以上两类消息是组织给企业发送消息
     */
    public XinfuResult orgToEntMessage(String userId, String sendAuthId, String receiveAuthId,String messagetitle,String messagecontent,String messagetype);

    /**
     * 会内通知
     * 会内通知是组织给成员企业群发消息
     */
    public XinfuResult orgToAllMember(String userId, String sendAuthId, String messagetitle,String messagecontent,String messagetype);

    //查询组织下所有成员的名称和ID
    public List findOrgEntMember(String auth_org_id);

    /**
     * 审核认证通过或不通过后发一条消息
     */
    public XinfuResult sendExaminedMessage(String userId,String receiveUserId,String receivename,String messagetitle,String messagecontent);

}
