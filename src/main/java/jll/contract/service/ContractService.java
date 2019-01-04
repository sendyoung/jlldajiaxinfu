package jll.contract.service;

import jll.model.contract.Contract;

/**
 * 平台合同
 * */
public interface ContractService {
    /**
     * 查询平台合同
     * */
    public Contract findContract();
    /**
     * 查询企业跟平台是否签订合同
     * */
    public String findEntToContractByAuthEnterpriseId(String authEnterpriseId);
    /**
     * 添加合同
     * */
    public void editEntToContract(String authEnterpriseId,String contractId);
}
