package jll.contract.service.impl;

import jll.contract.dao.ContractDao;
import jll.contract.dao.EntToContractDao;
import jll.contract.service.ContractService;
import jll.model.contract.Contract;
import jll.model.contract.EntToContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service("contractService")
@Transactional
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractDao contractDao;//平台合同
    @Autowired
    private EntToContractDao entToContractDao;//企业跟平台签订合同

    @Override
    public Contract findContract() {
        return contractDao.queryContractByContractId("1");
    }

    @Override
    public String findEntToContractByAuthEnterpriseId(String authEnterpriseId) {
        EntToContract etc=entToContractDao.queryEntToContractByAuthEnterpriseId(authEnterpriseId,"1");
        if(etc==null){
            return "no";
        }else{
            return "yes";
        }
    }

    @Override
    public void editEntToContract(String authEnterpriseId, String contractId) {
        EntToContract etc=new EntToContract();
        etc.setCreate_time(new Date());
        etc.setAuth_enterprise_id(authEnterpriseId);
        etc.setContract_id(contractId);
        entToContractDao.saveEntToContract(etc);
    }
}
