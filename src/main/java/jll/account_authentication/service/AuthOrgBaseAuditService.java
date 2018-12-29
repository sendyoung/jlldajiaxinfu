package jll.account_authentication.service;

import com.cn.zyzs.utils.utils.PageView;

//组织认证审核
public interface AuthOrgBaseAuditService {

    //查看待审核的组织列表
    public PageView findAuthOrgBaseAuditList(String orgName,String authTime,String creditCode,int currentPage,int rows);
}
