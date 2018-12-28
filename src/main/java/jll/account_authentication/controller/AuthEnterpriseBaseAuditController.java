package jll.account_authentication.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Scope("prototype")
@RequestMapping("/AuthEnterpriseBaseAudit")
public class AuthEnterpriseBaseAuditController {



    /**
     * 查询所有的认证企业
     * */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST},value = {"/FindAuthEnterpriseBase"})
    public @ResponseBody Object findAuthEnterpriseBase() {
        //return entBasicsService.findEntBasics(authEnterpriseId);
        return null;
    }

}
