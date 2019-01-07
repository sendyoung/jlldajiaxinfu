package jll.public_infomation.controller;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 首页需要显示的4块信息
 */
@Controller
@Scope("prototype")
@RequestMapping("/index")
public class IndexInfoController {

    /**
     * 回显首页需要的数据
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/queryCreditSet",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Object queryIndexData(){
        System.out.println("进入接口!");
        return "返回数据";
    }

}
