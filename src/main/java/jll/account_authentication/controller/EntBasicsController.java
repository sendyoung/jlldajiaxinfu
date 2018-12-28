package jll.account_authentication.controller;

import com.alibaba.fastjson.JSONObject;
import jll.account_authentication.service.EntBasicsService;
import jll.model.enterprise.EntBasics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@Scope("prototype")
@RequestMapping("/EntBasics")
public class EntBasicsController {

    @Autowired
    private EntBasicsService entBasicsService;//工商信息

    /**
     * 根据企业认证ID查询工商信息
     * authEnterpriseId企业认证ID
     * */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST},value = {"/FindEntBasics"})
    public @ResponseBody Object findEntBasics(@RequestParam String authEnterpriseId) {
        return entBasicsService.findEntBasics(authEnterpriseId);
    }

    /**
     * 修改工商信息
     * content工商信息
     * */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST},value = {"/EditEntBasics"})
    public @ResponseBody Object editEntBasics(@RequestParam String content) {
        EntBasics entBasics=JSONObject.parseObject(content,EntBasics.class);
        entBasics.setUpdate_time(new Date());
        entBasicsService.editEntBasics(entBasics);
        return "success";
    }

}
