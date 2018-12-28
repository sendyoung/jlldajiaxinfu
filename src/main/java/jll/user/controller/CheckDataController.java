package jll.user.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.google.gson.JsonObject;
import jll.model.User;
import jll.user.service.CheckDataService;
import jll.user.service.UserService;
import jll.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 数据校验(手机号,邮箱,身份证号等)
 */
@Controller
@Scope("prototype")
public class CheckDataController {

    @Autowired
    private CheckDataService checkDataService;
    @Autowired
    private UserService userService;

    /**
     * 发送邮件验证码
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST}, value = "/sendmailcode")
    public @ResponseBody
   XinfuResult sendCodeToMail(@RequestBody Map map){
        try {
            String tomail = (String)map.get("tomail");
            //生成6位随机数字符串
            String codeValue = CheckCodeUtil.randomVcode();
            //将字符串插入到数据库当中去返回该条数据的id
            String codeId = checkDataService.addCheckDataCode(codeValue,null);
            if (null!=codeId&&!"".equals(codeId)){
                JavaMailUtil.sendMail(tomail,"您正在尝试变更重要信息,验证码为: " + codeValue + ",验证码5分钟有效,请妥善保管账户信息!","数据变更校验");
            }
            return XinfuResult.build(200,"发送邮件成功,请输入收到的验证码",codeId);
        } catch (Exception e) {
            e.printStackTrace();
            return XinfuResult.build(400,"发送邮件失败,请重试");
        }
    }

    /**
     * 发送手机验证码
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST}, value = "/sendphonecode")
    public @ResponseBody XinfuResult sendCodeToPhone(@RequestBody Map map){
        try {
            String phonenum = (String)map.get("phonenum");
            //String template = (String)map.get("template");
            String codeValue = CheckCodeUtil.randomVcode();
            /*if(template.equals("login")){
                Sms.sendSms(phonenum,codeValue,"SMS_152750580");
            }else if(template.equals("register")){
                Sms.sendSms(phonenum,codeValue,"SMS_152750578");
            }else if(template.equals("modifyinfo")){
                Sms.sendSms(phonenum,codeValue,"SMS_152750576");
            }else if(template.equals("modifypsw")){
                Sms.sendSms(phonenum,codeValue,"SMS_152750577");
            }*/
            Sms.sendSms(phonenum,codeValue,"SMS_152920001");
            String codeId = checkDataService.addCheckDataCode(codeValue,phonenum);
            return XinfuResult.build(200,"发送短信成功",codeId);
        } catch (ClientException e) {
            e.printStackTrace();
            return XinfuResult.build(400,"发送短信失败");
        }
    }

    /**
     * 单独的校验验证码
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST}, value = "/checkcode")
    public @ResponseBody XinfuResult checkCode(@RequestBody Map map) {
        String inputCode = (String)map.get("inputCode");
        String codeId = (String)map.get("codeId");
        String phonenum = (String)map.get("phonenum");
        int status = checkDataService.findCodeById(codeId, inputCode,phonenum);
        if (status == 200) {
            return XinfuResult.build(200, "校验验证码成功!");
        } else {
            return XinfuResult.build(400, "您输入的验证码有误,请重试!");
        }
    }

    /**
     * 校验验证码并提交新的手机号
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST}, value = "/modifyphone")
    public @ResponseBody XinfuResult updatePhoneNum(@RequestBody Map map) {
        String codeId = (String)map.get("codeId");
        String inputCode = (String)map.get("inputCode");
        String userId = (String)map.get("userId");
        String phonenum = (String)map.get("phonenum");
        int status = checkDataService.findCodeById(codeId, inputCode,phonenum);
        if (status == 200) {
            return userService.updateUserPhone(phonenum,userId);
        } else {
            return XinfuResult.build(400, "您输入的验证码有误,请重试!");
        }
    }


    /**
     * 校验验证码成功后修改用户账号个人信息(这个接口暂时失效)
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST}, value = "/checkdatainfomation")
    public @ResponseBody XinfuResult checkCodeMailOrPhone(@RequestBody Map map){
        String inputCode = (String)map.get("inputCode");
        String codeId = (String)map.get("codeId");
        String phonenum = (String)map.get("phonenum");
        User user = JsonUtils.jsonToPojo((String)map.get("user"),User.class);
        int status = checkDataService.findCodeById(codeId,inputCode,phonenum);
        if (status==200){
            userService.updateUserAccount(user);
            return XinfuResult.build(200,"校验成功,数据修改成功");
        }else{
            return XinfuResult.build(400,"您输入的验证码有误,请重试!");
        }
        /*if(inputCode.equals(codeValue)){
           *//* User user = new User();
            user.setUser_id(userId);
            user.setEmail(newEmail);*//*
            userService.updateUserAccount(user);
            return XinfuResult.build(200,"校验成功,数据修改成功");
        }else{
            return XinfuResult.build(400,"您输入的验证码有误,请重试!");
        }*/
    }

}
