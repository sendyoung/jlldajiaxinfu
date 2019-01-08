package jll.organization_creditInformation.controller;

import com.alibaba.fastjson.JSON;
import jll.model.org_organization.*;
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
    private OrganizationMechanismService organizationMechanismService;  // 组织机构

    @Autowired
    private OrganizationalLeadershipService organizationalLeadershipService;      //组织领导
    /**
     * 组织信息  填报
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
        System.out.println("进入组织信息  回显");
        Map map=new HashMap();
        map.put("fill_in_organization",organizationInfoService.queryOrganizationInfo(auth_org_id).get(0));
        System.out.println("第一个map结束");
        map.put("associated_member",queryAssociatedServiceMember.queryAssociatedMember(auth_org_id).replace("{COUNT(*)=", "").replace("}",""));
        return map;
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
     * 组织机构 以及 部门信息 填报
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
     * 添加组织机构 (--部门--)
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/writeDepartment",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Object writeDepartment(HttpServletRequest request){
        List<Department> department = JSON.parseArray(request.getParameter("fill_in_information"), Department.class);
        for (Department dt : department){
            System.out.println("打印dt"+dt);
            organizationMechanismService.addOrganizationDepartment(dt);
        }

        Position position =JSON.parseObject(request.getParameter("fill_in_information"), Position.class);
        organizationalLeadershipService.addOrganizationalLeadership(position);

        String str = request.getParameter("fill_in_information");
        System.out.println("str的值------------------"+str);

        return "success";
    }







    /**
     * 组织机构 部门回显
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/queryDepartment",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Object queryDepartment(@RequestParam String org_structure_id){
        Map map = new HashMap();

        System.out.println("进入组织机构部门回显");

        List list = organizationMechanismService.queryOrganizationDepartment(org_structure_id);
        map.put("mepartment", list);
        return map;
    }



    /**
     * 组织领导 详情 添加
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/writeQrganizationlPositionDetail",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Object writeQrganizationlPositionDetail(HttpServletRequest request){

        PositionDetail positionDetail =JSON.parseObject(request.getParameter("fill_in_information"), PositionDetail.class);
        organizationalLeadershipService.addaddOrganizationalLeadershipDetail(positionDetail);
        return "success";


    }


    /**
     * 组织领导回显
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/queryQrganizationlPosition",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Object queryQrganizationlPosition(@RequestParam String auth_org_id){
        Map map = new HashMap();

        List list = organizationalLeadershipService.queryOrganizationalLeadership(auth_org_id);
        map.put("position", list);
        return map;
    }

    /**
     * 组织领导详情回显
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/queryQrganizationlPositionDetail",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Object queryQrganizationlPositionDetail(@RequestParam String post_id){
        System.out.println("进入组织领导详情回显数据");
        return organizationalLeadershipService.queryOrganizationalLeadershipDetail(post_id);
    }






}
