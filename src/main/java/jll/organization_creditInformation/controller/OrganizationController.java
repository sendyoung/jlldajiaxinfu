package jll.organization_creditInformation.controller;

import com.alibaba.fastjson.JSON;
import jll.model.org_organization.Organization;
import jll.model.org_organization.Structure;
import jll.organization_creditInformation.service.org.OrganizationInfoService;
import jll.organization_creditInformation.service.org.OrganizationMechanismService;
import jll.organization_creditInformation.service.org.OrganizationalLeadershipService;
import jll.organization_creditInformation.service.org.QueryAssociatedServiceMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    private OrganizationInfoService organizationInfoService;    //组织信息

    @Autowired
    private QueryAssociatedServiceMember queryAssociatedServiceMember;  //查询已关联会员数量

    @Autowired
    private OrganizationMechanismService organizationMechanismService;                            // 组织机构

    @Autowired
    private OrganizationalLeadershipService organizationalLeadershipService;      //组织领导
    /**
     * 组织信息填报(龚力)
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
     *  组织信息  回显
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/queryOrgInfo",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Object OrganizationInfoFill(@RequestParam String auth_org_id){
        Map map=new HashMap();
        map.put("fill_in_organization",organizationInfoService.queryOrganizationInfo(auth_org_id).get(0));
        map.put("associated_member",queryAssociatedServiceMember.queryAssociatedMember(auth_org_id).replace("{COUNT(*)=", "").replace("}",""));
        return map;
    }


    /**
     * 组织机构添加
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/writeMechanism",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Object writeMechanism(@RequestParam String org_structure){
        System.out.println("要添加的组织机构信息"+org_structure);

        //序列化
        Structure structure = JSON.parseObject(org_structure, Structure.class);

        organizationMechanismService.addOrganization(structure);
        return "success";
    }

    /**
     * 组织机构回显
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/queryMechanism",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Object queryMechanism(@RequestParam String auth_org_id){
        Map map = new HashMap();

        List list = organizationMechanismService.queryOrganization(auth_org_id);

        map.put("mechanism", list);
        return map;
    }



    /**
     * 组织领导回显
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/queryQrganizationlPosition",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Object queryQrganizationlPosition(@RequestParam String auth_org_id){
        Map map = new HashMap();

        List list = organizationalLeadershipService.queryOrganizationalLeadership(auth_org_id);
        map.put("fill_in_organization", list);
        return map;
    }
}
