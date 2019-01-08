package jll.reported_data.service.impl;

import jll.model.basic_pnformation_submit.SharePledgeRegistration;
import jll.reported_data.dao.EquityRegistrationDao;
import jll.reported_data.service.EquityRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service()
@Transactional
public class EquityRegistrationServiceImpl implements EquityRegistrationService {
    //调用dao层
    @Autowired
    private EquityRegistrationDao equityRegistrationDao;
    @Override
    public void addEquityRegistration(List<SharePledgeRegistration> sharePledgeRegistration) {
        for(SharePledgeRegistration sh:sharePledgeRegistration){
            equityRegistrationDao.addEquityRegistration(sh);
        }
    }

    @Override
    public List queryEquityRegistration(String entId) {
        List result=equityRegistrationDao.queryEquityRegistration(entId);
        if(null!=result && result.size()>0){
            return result;
        }
        return null;
    }
}
