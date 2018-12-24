package jll.good_information.controller;


import com.alibaba.fastjson.JSONArray;
import com.cn.zyzs.utils.base.BaseClass;
import jll.good_information.service.HonorService;
import jll.good_information.service.IndustryInfrastructureService;
import jll.good_information.service.OthersCertificateService;
import jll.good_information.service.PublicWelfareActivityService;
import jll.model.good_information.Honor;
import jll.model.good_information.IndustryInfrastructure;
import jll.model.good_information.OthersCertificate;
import jll.model.good_information.PublicWelfareActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Scope("prototype")
@RequestMapping("/GoodInformation")
public class GoodInformationController extends BaseClass {

    @Autowired
    private OthersCertificateService othersCertificateService;//其他证书

    @Autowired
    private HonorService honorService;//表彰

    @Autowired
    private PublicWelfareActivityService publicWelfareActivityService;//公益

    @Autowired
    private IndustryInfrastructureService industryInfrastructureService;//行业基础建设

    /**
     * entId企业ID
     * 获取良好信息
     * */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/FindGoodInformation",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Object findGoodInformation(@RequestParam String entId){
        System.out.println(entId);
        Map map=new HashMap();
        //其他证书
        map.put("othersCertificate",othersCertificateService.getOthersCertificate(entId));
        //表彰
        map.put("honor",honorService.getHonor(entId));
        //公益
        map.put("publicWelfareActivity",publicWelfareActivityService.getPublicWelfareActivity(entId));
        //基础建设
        map.put("industryInfrastructure",industryInfrastructureService.getIndustryInfrastructure(entId));
        return map;
    }

    /**
     * type良好信息的分类
     * content内容
     * 添加良好信息
     * */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/EditGoodInformation",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Object editGoodInformation(@RequestParam String info,@RequestParam String content){
        System.out.println(info+"----------------"+content);
        if("othersCertificate".equals(info)){
            //其他证书
            List<OthersCertificate> ocList=JSONArray.parseArray(content,OthersCertificate.class);
            othersCertificateService.editOthersCertificate(ocList);
        }else if("honor".equals(info)){
            //表彰
            List<Honor> hList =JSONArray.parseArray(content,Honor.class);
            honorService.editHonor(hList);
        }else if("publicWelfareActivity".equals(info)){
            //公益
            List<PublicWelfareActivity> pwaList=JSONArray.parseArray(content,PublicWelfareActivity.class);
            publicWelfareActivityService.editPublicWelfareActivity(pwaList);
        }else if("industryInfrastructure".equals(info)){
            //基础建设
            List<IndustryInfrastructure> iiList=JSONArray.parseArray(content,IndustryInfrastructure.class);
            industryInfrastructureService.editIndustryInfrastructure(iiList);
        }
        return "success";
    }

}
