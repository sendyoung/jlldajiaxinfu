package jll.message.service.impl;

import com.cn.zyzs.utils.utils.PageView;
import jll.account_authentication.dao.AuthEnterpriseBaseDao;
import jll.account_authentication.dao.AuthOrgBaseDao;
import jll.apply_evaluate.dao.ApplyEvaluateDao;
import jll.message.dao.OrgEntMemberDao;
import jll.message.dao.ReceiveMessageDao;
import jll.message.dao.SendMessageDao;
import jll.message.service.MessageService;
import jll.model.message.OrgReceiveMessage;
import jll.model.message.OrgSendMessage;
import jll.user.dao.UserDao;
import jll.utils.HibernatePageUtil;
import jll.utils.MapTrunPojo;
import jll.utils.XinfuResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("messageService")
@Transactional
public class MessageServiceImpl implements MessageService {

    @Autowired
    private ReceiveMessageDao receiveMessageDao;
    @Autowired
    private SendMessageDao sendMessageDao;
    @Autowired
    private AuthEnterpriseBaseDao authEnterpriseBaseDao;
    @Autowired
    private AuthOrgBaseDao authOrgBaseDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private ApplyEvaluateDao applyEvaluateDao;
    @Autowired
    private OrgEntMemberDao orgEntMemberDao;

    //查看发件箱列表
    @Override
    public PageView findSendMessageList(String userId,String messageType, int currentPage, int rows) {
        return HibernatePageUtil.sqlPageUtil(sendMessageDao.findSendMessageList(userId,messageType),currentPage,rows);
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
    public PageView findReceiveMessageList(String userId,int currentPage,int rows) {
       return HibernatePageUtil.sqlPageUtil(receiveMessageDao.findReceiveMessageList(userId),currentPage,rows);
    }

    //查看收件详情
    @Override
    public OrgReceiveMessage findReceiveMessage(String receiveMessageId) {
        List list = receiveMessageDao.findReceiveMessage(receiveMessageId);
        //查看消息后将消息状态修改为已读
        receiveMessageDao.updateMessageStatus(receiveMessageId);
        if(list!=null&&list.size()>0){
            Map map = (Map) list.get(0);
            OrgReceiveMessage orgReceiveMessage = (OrgReceiveMessage)MapTrunPojo.map2Object(map, OrgReceiveMessage.class);
            return orgReceiveMessage;
        }
        return null;
    }

    /**
     * 申请评价(关联)
     * 评价申诉
     * 以上两类消息是企业给组织发消息
     */
    @Override
    public XinfuResult entToOrgMessage(String userId, String sendAuthId, String receiveAuthId,String messagetitle,String messagecontent,String messagetype) {

        OrgSendMessage sendMessage = new OrgSendMessage();
        OrgReceiveMessage receiveMessage = new OrgReceiveMessage();
        try {
            //发送方企业名称
            List list1 = authEnterpriseBaseDao.findEnterpriseNameByAuthId(sendAuthId);
            String senderName = sqlToListToMapToString(list1,"enterprise_name");
            //接收方组织用户ID
            List list2 = userDao.findUserIdByAuthId(receiveAuthId);
            String receiveUserId = sqlToListToMapToString(list2,"user_id");
            //接收方组织名称
            List list3 = authOrgBaseDao.findOrgNameByAuthId(receiveAuthId);
            String receiveOrgName = sqlToListToMapToString(list3,"organization_name");
            //当前时间
            Date date = new Date();
            //发件箱
            sendMessage.setSender_id(userId);
            sendMessage.setSender_name(senderName);
            sendMessage.setReceiver_id(receiveUserId);
            sendMessage.setReceiver_name(receiveOrgName);
            sendMessage.setMessage_title(messagetitle);
            sendMessage.setMessage_content(messagecontent);
            sendMessage.setMessage_type(messagetype);
            sendMessage.setMessage_status("1");//这里写死的,1代表已发送   0草稿 1已发送
            sendMessage.setIsDelete("0");//默认未删除
            sendMessage.setSend_type("2");//1组织对企业 2 企业对组织 3群发
            sendMessage.setCreate_time(date);
            //收件箱
            receiveMessage.setSender_id(userId);
            receiveMessage.setSender_name(senderName);
            receiveMessage.setReceiver_id(receiveUserId);
            receiveMessage.setReceiver_name(receiveOrgName);
            receiveMessage.setMessage_title(messagetitle);
            receiveMessage.setMessage_content(messagecontent);
            receiveMessage.setMessage_type(messagetype);
            receiveMessage.setMessage_status("0");//默认未读   0未读 1已读
            receiveMessage.setIsDelete("0");//默认未删除
            receiveMessage.setSend_type("2");// 1组织对企业  2企业对组织  3群发
            receiveMessage.setCreate_time(date);

            sendMessageDao.addSendMessage(sendMessage);
            receiveMessageDao.addReceiveMessage(receiveMessage);
            return XinfuResult.build(200,"企业对组织发送消息成功");
        } catch (Exception e) {
            e.printStackTrace();
            return XinfuResult.build(400,"企业对组织发送消息失败,请联系管理员");
        }
    }

    /**
     * 评价审核
     * 消息提醒
     * 以上两类消息是组织给企业发送消息
     */
    @Override
    public XinfuResult orgToEntMessage(String userId, String sendAuthId, String receiveAuthId,String messagetitle,String messagecontent,String messagetype) {

        OrgSendMessage sendMessage = new OrgSendMessage();
        OrgReceiveMessage receiveMessage = new OrgReceiveMessage();
        try {
            //发送方组织名称
            List list1 = authOrgBaseDao.findOrgNameByAuthId(sendAuthId);
            String senderName = sqlToListToMapToString(list1,"organization_name");
            //接收方企业用户ID
            List list2 = userDao.findUserIdByAuthId(receiveAuthId);
            String receiveUserId = sqlToListToMapToString(list2,"user_id");
            //接收方企业名称
            List list3 = authEnterpriseBaseDao.findEnterpriseNameByAuthId(receiveAuthId);
            String receiveOrgName = sqlToListToMapToString(list3,"enterprise_name");
            //当前时间
            Date date = new Date();
            //发件箱
            sendMessage.setSender_id(userId);
            sendMessage.setSender_name(senderName);
            sendMessage.setReceiver_id(receiveUserId);
            sendMessage.setReceiver_name(receiveOrgName);
            sendMessage.setMessage_title(messagetitle);
            sendMessage.setMessage_content(messagecontent);
            sendMessage.setMessage_type(messagetype);
            sendMessage.setMessage_status("1");//这里写死的,1代表已发送   0草稿 1已发送
            sendMessage.setIsDelete("0");//默认未删除
            sendMessage.setSend_type("1");//1组织对企业 2 企业对组织 3群发
            sendMessage.setCreate_time(date);
            //收件箱
            receiveMessage.setSender_id(userId);
            receiveMessage.setSender_name(senderName);
            receiveMessage.setReceiver_id(receiveUserId);
            receiveMessage.setReceiver_name(receiveOrgName);
            receiveMessage.setMessage_title(messagetitle);
            receiveMessage.setMessage_content(messagecontent);
            receiveMessage.setMessage_type(messagetype);
            receiveMessage.setMessage_status("0");//默认未读   0未读 1已读
            receiveMessage.setIsDelete("0");//默认未删除
            receiveMessage.setSend_type("1");// 1组织对企业  2企业对组织  3群发
            receiveMessage.setCreate_time(date);

            sendMessageDao.addSendMessage(sendMessage);
            receiveMessageDao.addReceiveMessage(receiveMessage);
            return XinfuResult.build(200,"组织对企业发送消息成功");
        } catch (Exception e) {
            e.printStackTrace();
            return XinfuResult.build(400,"组织对企业发送消息失败,请联系管理员");
        }
    }

    /**
     * 会内通知
     * 会内通知是组织给成员企业群发消息
     */
    @Override
    public XinfuResult orgToAllMember(String userId, String sendAuthId, String messagetitle,String messagecontent,String messagetype) {
        OrgSendMessage sendMessage = new OrgSendMessage();
        OrgReceiveMessage receiveMessage = new OrgReceiveMessage();
        Date date = new Date();
        try {
            //发送方组织名称
            List list1 = authOrgBaseDao.findOrgNameByAuthId(sendAuthId);
            String senderName = sqlToListToMapToString(list1,"organization_name");
            //查询组织下所有关联企业认证ID
            List memberList = applyEvaluateDao.findEntAuthIdByOrgAuthId(sendAuthId);

            //创建一个集合接收所有成员企业用户ID集合
            List<String> receiveUserIdList = new ArrayList();
            //创建一个集合接收所有成员企业名称集合
            List<String> enterpriseNameList = new ArrayList();
            for(Object obj:memberList){
                Map map = (Map)obj;
                String auth_enterprise_id = (String)map.get("auth_enterprise_id");
                List userIdList = userDao.findUserIdByAuthId(auth_enterprise_id);
                List enterpriseList = authEnterpriseBaseDao.findEnterpriseNameByAuthId(auth_enterprise_id);
                //遍历获取所有的用户ID
                for(Object object:userIdList){
                    Map userMap = (Map)object;
                    String user_id = (String)userMap.get("user_id");
                    receiveUserIdList.add(user_id);
                }
                //遍历获取所有的企业名称
                for(Object enterpriseObj:enterpriseList){
                    Map enterpriseMap = (Map)enterpriseObj;
                    String enterpriseName = (String)enterpriseMap.get("enterprise_name");
                    enterpriseNameList.add(enterpriseName);
                    receiveMessage.setReceiver_name(enterpriseName);
                }
            }

            //发件箱内容添加
            sendMessage.setSender_id(userId);
            sendMessage.setSender_name(senderName);
            sendMessage.setReceiver_id(StringUtils.strip(receiveUserIdList.toString(),"[]"));
            sendMessage.setReceiver_name(StringUtils.strip(enterpriseNameList.toString(),"[]"));
            sendMessage.setMessage_title(messagetitle);
            sendMessage.setMessage_content(messagecontent);
            sendMessage.setMessage_type(messagetype);
            sendMessage.setMessage_status("1");//这里写死的,1代表已发送   0草稿 1已发送
            sendMessage.setIsDelete("0");//默认未删除
            sendMessage.setSend_type("3");//1组织对企业 2 企业对组织 3群发
            sendMessage.setCreate_time(date);
            sendMessageDao.addSendMessage(sendMessage);

            //收件箱内容添加(这里是共同的信息)
            receiveMessage.setSender_id(userId);
            receiveMessage.setSender_name(senderName);
            receiveMessage.setMessage_title(messagetitle);
            receiveMessage.setMessage_content(messagecontent);
            receiveMessage.setMessage_type(messagetype);
            receiveMessage.setMessage_status("0");//默认未读   0未读 1已读
            receiveMessage.setIsDelete("0");//默认未删除
            receiveMessage.setSend_type("3");// 1组织对企业  2企业对组织  3群发
            receiveMessage.setCreate_time(date);

            List<OrgReceiveMessage> receiveMessageList = new ArrayList<>();
            for(int i = 0;i<receiveUserIdList.size();i++){
                receiveMessage.setReceiver_id(receiveUserIdList.get(i));
                receiveMessage.setReceiver_name(enterpriseNameList.get(i));
                receiveMessageDao.addReceiveMessage(receiveMessage);
            }
            return XinfuResult.build(200,"企业群发会内通知成功");
        } catch (Exception e) {
            e.printStackTrace();
            return XinfuResult.build(400,"企业群发会内通知失败");
        }
    }

    //查询组织下所有的企业名称和id
    @Override
    public List findOrgEntMember(String auth_org_id) {
        return orgEntMemberDao.findOrgEntMember(auth_org_id);
    }

    //将sql查到list(只要一个字段的),获取转换到指定的字段内容
    public String sqlToListToMapToString(List list,String key){
        if(list!=null && list.size()>0){
            Map map = (Map)list.get(0);
            String str = (String)map.get(key);
            return str;
        }
        return null;
    }

}
