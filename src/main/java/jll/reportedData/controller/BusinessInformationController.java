package jll.reportedData.controller;


import com.alibaba.fastjson.JSONObject;
import com.cn.zyzs.utils.base.BaseClass;
import jll.model.BasicPnformationSubmit.CoreEntering;
import jll.reportedData.service.BusinessInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 填写工商信息
 */
@Controller
@Scope("prototype")
@RequestMapping("/fillData")
public class BusinessInformationController extends BaseClass {

    //调用service层
    @Autowired
    private BusinessInformationService businessInformationService;

    // 工商基本信息实体类
    @RequestMapping(value = "/business")
    @ResponseBody
    public String getBarData(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("进入test");
        Map map = getParameters(request);
        System.out.println(map);

        CoreEntering coreEntering = JSONObject.parseObject(map.get("content").toString(), CoreEntering.class);

        businessInformationService.addBusinessInformation(coreEntering);
        System.out.println("=====================-00000");
        return "工商信息填报!";

    }

}