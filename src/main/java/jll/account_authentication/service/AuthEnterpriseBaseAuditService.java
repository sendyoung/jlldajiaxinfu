package jll.account_authentication.service;

public interface AuthEnterpriseBaseAuditService {
    /**
     * 查询所有的认证中的企业
     * */
    public Object findAuthEnterpriseBase(String name,String createTime,String code,Integer page,Integer rows);
}
