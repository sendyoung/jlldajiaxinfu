package jll.message.controller;

import com.cn.zyzs.utils.utils.PageView;
import jll.message.service.MessageService;
import jll.model.message.OrgReceiveMessage;
import jll.model.message.OrgSendMessage;
import jll.utils.XinfuResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 发送和接收消息
 */
@Controller
@Scope("prototype")
public class MessageController {

    @Autowired
    private MessageService messageService;

    /**
     * 查看发件箱列表  4消息提醒,  5会内通知
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST},value = {"/sendMessageList"})
    public @ResponseBody
    PageView findSendMessageList(String userId,String messageType, @RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "10") int rows) {
        return messageService.findSendMessageList(userId,messageType,currentPage,rows);
    }

    /**
     * 查看发件箱消息详情
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST},value = {"/sendMessage"})
    public @ResponseBody
    OrgSendMessage findSendMessage(String sendMessageId) {
        return messageService.findSendMessage(sendMessageId);
    }

    /**
     * 查看收件箱列表
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST},value = {"/receiveMessageList"})
    public @ResponseBody
    PageView findReceiveMessageList(String userId, @RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "10") int rows) {
        return messageService.findReceiveMessageList(userId,currentPage,rows);
    }

    /**
     * 查看收件箱消息详情
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST},value = {"/receiveMessage"})
    public @ResponseBody
    OrgReceiveMessage findReceiveMessage(String receiveMessageId) {
        return messageService.findReceiveMessage(receiveMessageId);
    }

    /**
     *申请评价(关联)
     * 评价申诉
     * 以上两类消息是企业给组织发消息
     * userId 当前用户id
     * sendAuthId 当前用户认证ID
     * receiveAuthId接收消息认证ID
     * messagetitle 消息标题
     * messagecontent消息内容
     * messagetype  消息类型
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST},value = {"/entToOrgMessage"})
    public @ResponseBody XinfuResult entToOrgMessage(@RequestBody Map map){
        String userId = (String)map.get("userId");
        String sendAuthId = (String)map.get("sendAuthId");
        String receiveAuthId = (String)map.get("receiveAuthId");
        String messagetitle = (String)map.get("messagetitle");
        String messagecontent = (String)map.get("messagecontent");
        String messagetype = (String)map.get("messagetype");
        return messageService.entToOrgMessage(userId,sendAuthId,receiveAuthId,messagetitle,messagecontent,messagetype);
    }

    /**
     * 评价审核
     *  消息提醒
     *  以上两类消息是组织给企业发送消息
     * userId当前用户ID
     * sendAuthId当前用户认证ID
     * receiveAuthId接收方认证ID
     * messagetitle消息标题
     * messagecontent消息内容
     * messagetype消息类型
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST},value = {"/orgToEntMessage"})
    public @ResponseBody XinfuResult orgToEntMessage(@RequestBody Map map){
        String userId = (String)map.get("userId");
        String sendAuthId = (String)map.get("sendAuthId");
        String receiveAuthId = (String)map.get("receiveAuthId");
        String messagetitle = (String)map.get("messagetitle");
        String messagecontent = (String)map.get("messagecontent");
        String messagetype = (String)map.get("messagetype");
        return messageService.orgToEntMessage(userId,sendAuthId,receiveAuthId,messagetitle,messagecontent,messagetype);
    }

    /**
     * 会内通知
     * 会内通知是组织给成员企业群发消息
     * userId当前用户ID
     * sendAuthId当前用户认证ID
     * messagetitle消息标题
     * messagecontent消息内容
     * messagetype消息类型默认为会内通知
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST},value = {"/orgToAllMember"})
    public @ResponseBody XinfuResult orgToAllMember(@RequestBody Map map){
        String userId = (String)map.get("userId");
        String sendAuthId = (String)map.get("sendAuthId");
        String messagetitle = (String)map.get("messagetitle");
        String messagecontent = (String)map.get("messagecontent");
        String messagetype = (String)map.get("messagetype");
        return messageService.orgToAllMember(userId,sendAuthId,messagetitle,messagecontent,messagetype);
    }

    /**
     * 查询组织下所有成员的企业名称和id
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST},value = {"/orgEntMember"})
    public @ResponseBody List findOrgEntMember(@RequestParam String authOrgId){
        return messageService.findOrgEntMember(authOrgId);
    }

    /**
     * 审核通过发消息
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST},value = {"/examineMessage"})
    public @ResponseBody XinfuResult examineMessage(@RequestBody Map map){
        String userId = (String)map.get("userId");
        String receiveUserId = (String)map.get("receiveUserId");
        String receivename = (String)map.get("receivename");
        String messagetitle = (String)map.get("messagetitle");
        String messagecontent = (String)map.get("messagecontent");
        return messageService.sendExaminedMessage(userId,receiveUserId,receivename,messagetitle,messagecontent);
    }

}
