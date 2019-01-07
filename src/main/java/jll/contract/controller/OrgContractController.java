package jll.contract.controller;

import jll.contract.service.OrgContractService;
import jll.model.contract.OrgContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Scope("prototype")
@RequestMapping("/OrgContract")
public class OrgContractController {

    @Autowired
    private OrgContractService orgContractService;//企业跟组织的合同

    /**
     * 查询组织合同
     * authOrgId组织Id
     * */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/FindOrgContractByAuthOrgId",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Object findOrgContractByAuthOrgId(@RequestParam String authOrgId){
        OrgContract orgContract=orgContractService.findOrgContractByAuthOrgId(authOrgId);
        if(orgContract==null){
            return "无合同";
        }
        return orgContract;
    }

    /**
     * 企业跟组织签订合同（添加合同）
     * orgContractId组织合同ID
     * authEnterpriseId企业认证ID
     * */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/EditEntToOrgContract",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Object editEntToOrgContract(@RequestParam String authEnterpriseId,@RequestParam String orgContractId){
        orgContractService.editEntToOrgContract(authEnterpriseId,orgContractId);
        return "success";
    }

}
