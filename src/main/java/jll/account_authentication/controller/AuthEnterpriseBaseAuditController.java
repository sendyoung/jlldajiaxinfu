package jll.account_authentication.controller;

import jll.account_authentication.service.AuthEnterpriseBaseAuditService;
import jll.account_authentication.service.AuthOrgBaseAuditService;
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

    @Autowired
    private AuthOrgBaseAuditService authOrgBaseAuditService;//认证组织

    /**
     * 查询所有的认证中的企业
     * name企业名
     * createTime认证申请日期
     * code统一代码
     * page，rows
     * */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST},value = {"/FindAuthEnterpriseBase"})
    public @ResponseBody Object findAuthEnterpriseBase(@RequestParam(required = false) String name,@RequestParam(required = false) String createTime,@RequestParam(required = false) String code,@RequestParam(defaultValue = "1")Integer page,@RequestParam(defaultValue = "10")Integer rows) {
        return authEnterpriseBaseAuditService.findAuthEnterpriseBase(name,createTime,code,page,rows);
    }
    /**
     * 认证审核不通过
     * userId用户Id
     * type 5 企业认证不通过  6 组织认证不通过
     * */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST},value = {"/EditAuthEnterpriseBaseToNotGo"})
    public @ResponseBody Object editAuthEnterpriseBaseToNotGo(@RequestParam String userId,@RequestParam String type) {
       authEnterpriseBaseAuditService.editAuthEnterpriseBaseToNotGo(userId,type);
       return "success";
    }
    /**
     * 企业认证通过
     * userId用户Id
     * */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST},value = {"/EditAuthEnterpriseBaseToPass"})
    public @ResponseBody Object editAuthEnterpriseBaseToPass(@RequestParam String userId) {
        //认证通过
        //authEnterpriseBaseAuditService.editAuthEnterpriseBaseToNotGo(userId,"2");
        authOrgBaseAuditService.updateUserAuthType(userId,"2");
        authOrgBaseAuditService.updateUserRoleMiddle(userId,"2");
        //生成工商信息
        authEnterpriseBaseAuditService.editAuthEnterpriseBaseToPass(userId);
        return "success";
    }

}
