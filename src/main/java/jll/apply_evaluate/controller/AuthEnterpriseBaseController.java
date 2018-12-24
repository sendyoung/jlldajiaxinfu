package jll.apply_evaluate.controller;

import jll.apply_evaluate.service.AuthEnterpriseBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Scope("prototype")
@RequestMapping("/AuthEnterpriseBase")
public class AuthEnterpriseBaseController {

    @Autowired
    private AuthEnterpriseBaseService authEnterpriseBaseService;//企业认证

    /**
     * 查询属于组织行业的企业
     * */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/FindAuthEnterpriseBaseByOrgIndustry",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Object findAuthEnterpriseBaseByOrgIndustry(@RequestParam String authOrgId,@RequestParam(required = false) String name,@RequestParam(required = false) String typesEnterprises,@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "10") Integer rows){
       return authEnterpriseBaseService.findAuthEnterpriseBaseByOrgIndustry(authOrgId,name,typesEnterprises,page,rows);
    }


}
