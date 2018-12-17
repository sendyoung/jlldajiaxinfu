package jll.reportedData.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 企业信息填报controller层
 */

@Controller
@Scope("prototype")
@RequestMapping("/enterprise")
public class EnterpriseInformationFillingController {
    @RequestMapping(value = "/write")
    @ResponseBody
    public String getBarData(HttpServletRequest request, HttpServletResponse response) {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
        System.out.println("request"+request.getParameterMap().toString());
        Map map = request.getParameterMap();

        System.out.println("map"+map.toString());
        System.out.println("ent_id"+map.get("ent_id"));
        return "腾讯qq企业邮箱！";
    }


}
