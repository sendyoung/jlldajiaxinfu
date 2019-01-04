package jll.contract.service;

import jll.model.contract.OrgContract;

/**
 * 组织合同
 * */
public interface OrgContractService {
    /**
     * 查询组织合同
     * */
    public OrgContract findOrgContractByAuthOrgId(String authOrgId);
    /**
     * 添加合同
     * */
    public void editEntToOrgContract(String authEnterpriseId,String orgContractId);
}
