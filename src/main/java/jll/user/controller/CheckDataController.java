package jll.user.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 数据校验(手机号,邮箱,身份证号等)
 */
@Controller
@Scope("prototype")
public class CheckDataController {

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.POST}, value = "/checkDataMail")
    public void checkDataMail(){
        /**
         * 首先生成一个随机数,将这个随机数放在邮件内容中发送到指定邮箱中去,让用户输入这个
         */
    }
}
