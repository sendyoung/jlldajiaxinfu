package jll.message.dao.service;

public interface AuthEnterpriseBaseService {
    /**
     * 查询属于组织行业的企业
     * */
    public Object findAuthEnterpriseBaseByOrgIndustry(String authOrgId, String name,String typesEnterprises,Integer page,Integer rows);
}
