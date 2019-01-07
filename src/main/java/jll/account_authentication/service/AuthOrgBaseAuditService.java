package jll.account_authentication.service;

import com.cn.zyzs.utils.utils.PageView;
import jll.utils.XinfuResult;

//组织认证审核
public interface AuthOrgBaseAuditService {

    //查看待审核的组织列表
    public PageView findAuthOrgBaseAuditList(String orgName,String authTime,String creditCode,int currentPage,int rows);
    /**
     * 暂时不用
     * ①修改用户信息中的认证类型为(2 企业认证通过 ,4 组织认证通过,5 企业认证驳回,6 组织认证驳回)    根据用户ID
     * ②修改用户信息中的用户类型为2 企业用户 3 组织用户  (不通过则不修改)       根据用户ID
     */
    public XinfuResult updateUserAuthType(String userId,String authType);
    /**
     * 暂时不用
     * 通过审核后修改用户角色(2 企业 3 组织)  根据用户ID
     */
    public XinfuResult updateUserRoleMiddle(String userId,String roleId);

    //组织认证审核
    public XinfuResult examineOrg(String userId);

    //添加默认数据
    public XinfuResult addDefualtData(String authOrgId);
}
