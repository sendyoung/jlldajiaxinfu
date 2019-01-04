package jll.contract.service.impl;

import jll.contract.dao.EntToOrgContractDao;
import jll.contract.dao.OrgContractDao;
import jll.contract.service.OrgContractService;
import jll.model.contract.EntToOrgContract;
import jll.model.contract.OrgContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service("orgContractService")
@Transactional
public class OrgContractServiceImpl implements OrgContractService {

    @Autowired
    private OrgContractDao orgContractDao;//组织合同
    @Autowired
    private EntToOrgContractDao entToOrgContractDao;//企业跟组织签订合同


    @Override
    public OrgContract findOrgContractByAuthOrgId(String authOrgId) {
        return orgContractDao.queryOrgContractByAuthOrgId(authOrgId,"1");
    }

    @Override
    public void editEntToOrgContract(String authEnterpriseId, String orgContractId) {
        EntToOrgContract etoc=new EntToOrgContract();
        etoc.setAuth_enterprise_id(authEnterpriseId);
        etoc.setOrg_contract_id(orgContractId);
        etoc.setCreate_time(new Date());
        entToOrgContractDao.saveEntToContract(etoc);
    }
}
