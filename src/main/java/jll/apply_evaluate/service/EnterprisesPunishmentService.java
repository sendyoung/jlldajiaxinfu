package jll.apply_evaluate.service;

public interface EnterprisesPunishmentService {

/**
 * 查询组织下企业的黑名单信息
 */
public Object findEnterprisesPunishmentByAuthOrgId(String authOrgId,Integer page,Integer rows);
}
