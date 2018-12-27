package jll.account_authentication.controller;

import jll.account_authentication.service.AreaService;
import jll.account_authentication.service.IndustryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Scope("prototype")
@RequestMapping("/Tool")
public class ToolController {

    @Autowired
    private IndustryService industryService;//行业

    @Autowired
    private AreaService areaService;//地区

    /**
     * 查询行业信息
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST},value = {"/FindIndustry"})
    public @ResponseBody Object findIndustry() {
        return industryService.findIndustry();
    }
    /**
     * 查询区域信息
     * */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST},value = {"/FindArea"})
    public @ResponseBody Object findArea(){
        return areaService.findArea();
    }
}
