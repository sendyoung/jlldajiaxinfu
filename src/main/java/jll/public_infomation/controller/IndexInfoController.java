package jll.public_infomation.controller;


import jll.public_infomation.service.IndexInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 首页需要显示的4块信息
 */
@Controller
@Scope("prototype")
@RequestMapping("/index")
public class IndexInfoController {

    @Autowired
    private IndexInfoService indexInfoService;   //调用service

    /**
     * 回显首页需要的数据
     */

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/queryCreditSet",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Object queryIndexData(){
        List list = indexInfoService.queryIndexData();
        Map map = new HashMap();
        System.out.println("进入接口!");
        map.put("creditRedList", list.get(0));
        map.put("creditBlacklist", list.get(1));
        map.put("creditEvaluation", list.get(2));
        map.put("informationPublicity", list.get(3));
        return map;
    }

}
