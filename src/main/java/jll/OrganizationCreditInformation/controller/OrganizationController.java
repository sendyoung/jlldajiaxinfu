package jll.OrganizationCreditInformation.controller;

import com.alibaba.fastjson.JSON;
import jll.OrganizationCreditInformation.service.OrganizationInfoService;
import jll.OrganizationCreditInformation.service.QueryAssociatedServiceMember;
import jll.model.OrgOrganization.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 组织信用信息
 */
@Controller
@Scope("prototype")
@RequestMapping("/organization")
public class OrganizationController {

    // 调用service层
    @Autowired
    private OrganizationInfoService organizationInfoService;

    @Autowired
    private QueryAssociatedServiceMember queryAssociatedServiceMember;  //查询已关联会员数量

    /**
     * 组织信息填报
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/writeOrgInfo",method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public String OrganizationInfoFill(HttpServletRequest request, HttpServletResponse response){
            System.out.println("进入组织信息填报接口");
            String str = request.getParameter("fill_in_organization");
            System.out.println(str);
            Organization organization = JSON.parseObject(request.getParameter("fill_in_organization"), Organization.class);
            organizationInfoService.addOrganizationInfo(organization);
            System.out.println(str);
            return "ok";

    }


    /**
     * 回显数据
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/queryOrgInfo",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Object OrganizationInfoFill(@RequestParam String auth_org_id){
        System.out.println("进入回显数据!");
        Map map=new HashMap();
//        request.getParameter("")
        map.put("fill_in_organization",organizationInfoService.queryOrganizationInfo("123").get(0));
        map.put("associated_member",queryAssociatedServiceMember.queryAssociatedMember("123").replace("{COUNT(*)=", "").replace("}",""));
        return map;
    }
    /**
     *
     */
//    @RequestMapping(value = "/writeOrgInfo")
//    @ResponseBody
    /**
     * 文件上传! (会员名单上传)
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/fileUpload")
    @ResponseBody
    public String getBarData(HttpServletRequest request, HttpServletResponse response) throws Exception{
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        List<MultipartFile> files = multipartRequest.getFiles("file1");
        String filepath = request.getSession().getServletContext().getRealPath("/")+"filemanage";
        System.out.println(filepath);
        File file = new File(filepath);
        if (!file.exists()){
            file.mkdirs();
        }
        //file.createNewFile();
        for (MultipartFile file2 : files){

            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filepath+"/"+file2.getOriginalFilename()));
            BufferedInputStream in = new BufferedInputStream(file2.getInputStream());
            int b = 0;
            while((b=in.read())!=-1){
                bos.write(b);
            }
            bos.close();
            in.close();
        }

        System.out.println("进入文件上传方法");
        return "腾讯qq";

    }






}
