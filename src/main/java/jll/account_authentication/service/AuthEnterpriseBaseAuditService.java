package jll.account_authentication.service;

public interface AuthEnterpriseBaseAuditService {
    /**
     * 查询所有的认证中的企业
     * */
    public Object findAuthEnterpriseBase(String name,String createTime,String code,Integer page,Integer rows);
    /**
     * 认证审核不通过
     * userId用户Id
     * type 5 企业认证不通过  6 组织认证不通过
     * */
    public void editAuthEnterpriseBaseToNotGo(String userId,String type);
    /**
     * 企业认证通过
     * userId用户Id
     * authEnterpriseId企业认证Id
     * */
    public void editAuthEnterpriseBaseToPass(String userId);
}
