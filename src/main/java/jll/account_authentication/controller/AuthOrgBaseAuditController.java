package jll.account_authentication.controller;

import com.cn.zyzs.utils.utils.PageView;
import jll.account_authentication.service.AuthOrgBaseAuditService;
import jll.utils.XinfuResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Scope("prototype")
@RequestMapping("/authOrgBaseAudit")
public class AuthOrgBaseAuditController {

    @Autowired
    private AuthOrgBaseAuditService authOrgBaseAuditService;

    /**
     * 待审核认证组织列表
     * @param orgName 筛选条件组织名称
     * @param authTime 筛选条件认证时间
     * @param creditCode 筛选条件社会信用统一代码
     * @param currentPage  当前页
     * @param rows  每页显示的条数
     * @return
     */
    @CrossOrigin(origins = "*", maxAge=3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST}, value = "/examinelist")
    public @ResponseBody
    PageView findAuthOrgBaseAuditList(@RequestParam(required = false) String orgName,@RequestParam(required = false) String authTime,@RequestParam(required = false) String creditCode, @RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "10") int rows){
        authOrgBaseAuditService.findAuthOrgBaseAuditList(orgName,authTime,creditCode,currentPage,rows);
    return null;
    }

    /**
     * 组织审核通过或不通过的操作
     * ①修改用户信息中的认证类型为(4 组织认证通过,6 组织认证驳回)    根据用户ID
     * ②修改用户信息中的用户类型为3 组织用户  (不通过则不修改)       根据用户ID
     * ③修改用户角色关系表中的角色 (不通过则不修改)                  根据用户ID
     */

    /**
     *组织审核
     */
    @CrossOrigin(origins = "*", maxAge=3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST}, value = "/examineorg")
    public @ResponseBody
    XinfuResult examineOrg(String userId,String authType){
       return authOrgBaseAuditService.examineOrg(userId,authType);
    }
}
