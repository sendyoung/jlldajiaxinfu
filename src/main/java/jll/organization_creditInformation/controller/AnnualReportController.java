package jll.organization_creditInformation.controller;


import com.alibaba.fastjson.JSON;
import jll.model.org_organization.AnnualDevelopmentReport;
import jll.model.org_organization.AnnualReport;
import jll.model.org_organization.BlueBook;
import jll.organization_creditInformation.service.year.AnnualDevelopmentReportService;
import jll.organization_creditInformation.service.year.AnnualReportService;
import jll.organization_creditInformation.service.year.BlueBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

    @Autowired
    private BlueBookService blueBookService;              // 蓝皮书

    @Autowired
    private AnnualReportService annualReportService;     //组织年报

    /**
     * 添加年度报告   3块 全部数据
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/fill",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Object fill(HttpServletRequest request){

        if(request.getParameter("table_name").equals("org_annual_development_report")){
            List<AnnualDevelopmentReport> annualDevelopmentReport = JSON.parseArray(request.getParameter("fill_in_information"), AnnualDevelopmentReport.class);
            annualDevelopmentReportService.addAnnualDevelopmentReport(annualDevelopmentReport);
        }else if(request.getParameter("table_name").equals("org_blue_book")){
            List<BlueBook> blueBook = JSON.parseArray( request.getParameter("fill_in_information"), BlueBook.class);
            blueBookService.addBlueBook(blueBook);
        }else if(request.getParameter("table_name").equals("org_annual_report")){
            List<AnnualReport> annualReport = JSON.parseArray(request.getParameter("fill_in_information"), AnnualReport.class);
            annualReportService.addAnnualReport(annualReport);
        }

        return "success";
    }

    /**
     * 回显年度报告  3块 全部数据
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/query",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Object query(@RequestParam String auth_org_id){
        Map map = new HashMap();
        List annualDevelopmentlist = annualDevelopmentReportService.queryAnnualDevelopmentReport(auth_org_id);// 年度发展报告
        List  blueBooklist = blueBookService.queryBlueBook(auth_org_id);// 蓝皮书
        List  annualReportlist = annualReportService.queryAnnualReport(auth_org_id);// 组织年报


        map.put("org_annual_development_report", annualDevelopmentlist);   // 年度发展报告
        map.put("org_blue_book", blueBooklist);   // 蓝皮书
        map.put("org_annual_report", annualReportlist);   // 组织年报

        return map;
    }





}
