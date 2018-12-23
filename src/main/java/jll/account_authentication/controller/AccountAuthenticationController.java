package jll.account_authentication.controller;

import jll.account_authentication.service.AccountAuthenticationService;
import jll.model.authentication.AuthEnterpriseBase;
import jll.model.authentication.AuthOrgBase;
import jll.utils.JsonUtils;
import jll.utils.XinfuResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 账号认证
 */
@Controller
@Scope("prototype")
public class AccountAuthenticationController {

    @Autowired
    private AccountAuthenticationService accountAuthenticationService;

    /**
     * 回显企业认证数据
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST},value = {"/findauthenterprisebase"})
    public @ResponseBody
    AuthEnterpriseBase findAuthEnterpriseBase(String authenticationId) {
        AuthEnterpriseBase authEnterpriseBase =accountAuthenticationService.findAuthEnterpriseBase(authenticationId);
        return authEnterpriseBase;
    }

    /**
     * 新增或更新企业认证数据
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST},value = {"/fillinauthenterprisebase"})
    public @ResponseBody XinfuResult saveOrUpdateAuthEnterpriseBase(@RequestBody Map map){
        String userId = (String)map.get("userId");
        AuthEnterpriseBase authEnterpriseBase = JsonUtils.jsonToPojo((String)map.get("authEnterpriseBase"),AuthEnterpriseBase.class);
        return accountAuthenticationService.saveOrUpdateAuthEnterpriseBase(authEnterpriseBase,userId);
    }

    /**
     * 组织认证信息回显
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST},value = {"/findauthorgbase"})
    public @ResponseBody
    AuthOrgBase findAuthOrgBase(String authenticationId){
        AuthOrgBase authOrgBase = accountAuthenticationService.findAuthOrgBase(authenticationId);
        return authOrgBase;
    }

    /**
     * 新增或更新组织认证数据
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST},value = {"/fillinauthorgbase"})
    public @ResponseBody XinfuResult saveOrUpdateAuthOrgBase(@RequestBody Map map){
        String userId = (String)map.get("userId");
        AuthOrgBase authOrgBase = JsonUtils.jsonToPojo((String)map.get("authOrgBase"),AuthOrgBase.class);
        return accountAuthenticationService.saveOrUpdateAuthOrgBase(authOrgBase,userId);
    }

    /**
     * 根据社会信用统一代码查询企业信息
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST},value = {"/findentbasicsincode"})
    public @ResponseBody
    XinfuResult findEntBasicsByCode(String unified_social_credit_code){
        return accountAuthenticationService.findEntBasics(unified_social_credit_code);
    }

}
