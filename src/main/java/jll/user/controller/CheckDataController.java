package jll.user.controller;

import jll.model.User;
import jll.user.service.CheckDataService;
import jll.user.service.UserService;
import jll.utils.CheckCodeUtil;
import jll.utils.JavaMailUtil;
import jll.utils.XinfuResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.POST}, value = "/sendcode")
    public @ResponseBody
   XinfuResult sendCodeToMail(String to){
        try {
            //生成6位随机数字符串
            String codeValue = CheckCodeUtil.mailCheckCode();
            //将字符串插入到数据库当中去返回该条数据的id
            String codeId = checkDataService.addCheckDataCode(codeValue);
            if (null!=codeId&&!"".equals(codeId)){
                JavaMailUtil.sendMail(to,"您的邮箱校验码为: " + codeValue + ",请勿告知他人!","邮箱更改校验通知");
            }
            return XinfuResult.build(200,"发送邮件成功,请输入收到的验证码",codeId);
        } catch (Exception e) {
            e.printStackTrace();
            return XinfuResult.build(400,"发送邮件失败,请重试");
        }

    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.POST}, value = "/checkdatamail")
    public @ResponseBody XinfuResult checkCodeMail(String inputCode,User user,String codeId){
        String codeValue = checkDataService.findCodeById(codeId);
        if(inputCode.equals(codeValue)){
           /* User user = new User();
            user.setUser_id(userId);
            user.setEmail(newEmail);*/
            userService.updateUserAccount(user);
            return XinfuResult.build(200,"校验成功,数据修改成功");
        }else{
            return XinfuResult.build(400,"您输入的验证码有误,请重试!");
        }
    }

}
