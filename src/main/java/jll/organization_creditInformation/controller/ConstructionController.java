package jll.organization_creditInformation.controller;

import jll.organization_creditInformation.service.build.HostingJournalService;
import jll.organization_creditInformation.service.build.OrganizationAwardService;
import jll.organization_creditInformation.service.build.OrganizeActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 组织建设Controller
 */

@Controller
@Scope("prototype")
@RequestMapping("/organizationalConstruction")
public class ConstructionController {

    @Autowired
    private HostingJournalService hostingJournalService; //主办期刊
    @Autowired
    private OrganizationAwardService organizationAwardService; //组织奖项
    @Autowired
    private OrganizeActivityService organizeActivityService; //组织活动


    /**
     * 添加组织建设信息
     */





    /**
     * 回显组织建设信息
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/query",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Object query(@RequestParam String auth_org_id){
        System.out.println("进入组织建设接口");
        Map map = new HashMap();

        map.put("org_hosting_journal", hostingJournalService.queryHostingJournal(auth_org_id));//主办期刊
        map.put("org_organization_award", organizationAwardService.queryOrganizationAward(auth_org_id));//组织奖项
        map.put("org_organize_activity", organizeActivityService.queryOrganizeActivity(auth_org_id));//组织活动


        return map;
    }
}
