package jll.organization_creditInformation.controller;


import jll.organization_creditInformation.service.year.AnnualDevelopmentReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 年度报告Controller
 */
@Controller
@Scope("prototype")
@RequestMapping("/annualReport")
public class AnnualReportController {

    @Autowired
    private AnnualDevelopmentReportService annualDevelopmentReportService;   // 年度发展报告

    /**
     * 回显年度报告   全部数据
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/query",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Object query(@RequestParam String auth_org_id){
        Map map = new HashMap();
        List list = annualDevelopmentReportService.queryAnnualDevelopmentReport(auth_org_id);

        map.put("org_annual_development_report", list);
        return map;
    }





}
