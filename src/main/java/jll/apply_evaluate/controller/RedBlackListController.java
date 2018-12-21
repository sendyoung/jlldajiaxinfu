package jll.apply_evaluate.controller;

import com.alibaba.fastjson.JSONObject;
import jll.apply_evaluate.service.RedBlackListService;
import jll.model.apply_evaluate.RedBlackList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Scope("prototype")
@RequestMapping("/RedBlackList")
public class RedBlackListController {

    @Autowired
    private RedBlackListService redBlackListService;//红黑榜

    /**
     * 生成红黑名单
     * */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/EditRedBlackList",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Object editRedBlackList(@RequestParam String authOrgId,@RequestParam(required = false) String redContent,@RequestParam(required = false) String blackContent){
       if(redContent!=null){
           //生成红榜
           RedBlackList rbl1=JSONObject.parseObject(redContent,RedBlackList.class);
           rbl1.setAuth_org_id(authOrgId);
           rbl1.setType("1");
           redBlackListService.editRedBlackList(rbl1);
       }
        if(blackContent!=null){
            //生成黑榜
            RedBlackList rbl2=JSONObject.parseObject(blackContent,RedBlackList.class);
            rbl2.setAuth_org_id(authOrgId);
            rbl2.setType("2");
            redBlackListService.editRedBlackList(rbl2);
        }
        return "success";
    }
}
