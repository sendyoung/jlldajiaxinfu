package jll.account_authentication.controller;

import jll.account_authentication.service.AuthEnterpriseBaseAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Scope("prototype")
@RequestMapping("/AuthEnterpriseBaseAudit")
public class AuthEnterpriseBaseAuditController {

    @Autowired
    private AuthEnterpriseBaseAuditService authEnterpriseBaseAuditService;//认证企业

    /**
     * 查询所有的认证中的企业
     * */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST},value = {"/FindAuthEnterpriseBase"})
    public @ResponseBody Object findAuthEnterpriseBase(@RequestParam(required = false) String name,@RequestParam(required = false) String createTime,@RequestParam(required = false) String code,@RequestParam(defaultValue = "1")Integer page,@RequestParam(defaultValue = "10")Integer rows) {
        return authEnterpriseBaseAuditService.findAuthEnterpriseBase(name,createTime,code,page,rows);
    }
    /**
     * 认证审核
     * */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST},value = {"/EditAuthEnterpriseBase"})
    public @ResponseBody Object editAuthEnterpriseBase(@RequestParam String userId,@RequestParam String type) {
        return null;
    }

}
