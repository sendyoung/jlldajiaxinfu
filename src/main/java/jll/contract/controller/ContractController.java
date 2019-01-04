package jll.contract.controller;

import jll.contract.service.ContractService;
import jll.model.contract.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Scope("prototype")
@RequestMapping("/Contract")
public class ContractController {

    @Autowired
    private ContractService contractService;//企业跟平台的合同

    /**
     * 查询平台合同
     * */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/FindContract",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Object findContract(){
        Contract contract=contractService.findContract();
        if(contract==null){
            return "无合同";
        }
        return contract;
    }
    /**
     * 查询企业跟平台是否签订合同
     * 返回值yes(签订) no(未签订)
     * authEnterpriseId企业认证ID
     * */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/FindEntToContractByAuthEnterpriseId",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Object findEntToContractByAuthEnterpriseId(@RequestParam String authEnterpriseId){
        return contractService.findEntToContractByAuthEnterpriseId(authEnterpriseId);
    }
    /**
     * 企业跟平台签订合同（添加合同）
     * contractId平台合同ID
     * authEnterpriseId企业认证ID
     * */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/EditEntToContract",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Object editEntToContract(@RequestParam String authEnterpriseId,@RequestParam String contractId){
        contractService.editEntToContract(authEnterpriseId,contractId);
        return "success";
    }

}
