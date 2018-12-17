package jll.OrganizationCreditInformation.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 组织信用信息
 */
@Controller
@Scope("prototype")
@RequestMapping("/organization")
public class OrganizationController {

    // 调用service层
//    private BusinessInformationService businessInformationService;

    // 调用
    @RequestMapping(value = "/getBarData")
    @ResponseBody
    public String getBarData(HttpServletRequest request, HttpServletResponse response) {

        return "腾讯qq";

    }








}
