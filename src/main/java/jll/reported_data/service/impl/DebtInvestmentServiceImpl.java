package jll.reported_data.service.impl;

import jll.model.BasicPnformationSubmit.CreditorRightsInvestment;
import jll.reported_data.dao.DebtInvestmentDao;
import jll.reported_data.service.DebtInvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service()
@Transactional
public class DebtInvestmentServiceImpl implements DebtInvestmentService {

    //调用dao层
    @Autowired
    private  DebtInvestmentDao DebtInvestmentDao;
    @Override
    public void addDebtInvestment(List<CreditorRightsInvestment> creditorRightsInvestment) {
        for(CreditorRightsInvestment sh:creditorRightsInvestment){
            DebtInvestmentDao.addDebtInvestment(sh);
        }
    }

    @Override
    public List queryDebtInvestment(String entId) {
        List result=DebtInvestmentDao.queryDebtInvestment(entId);
        if(null!=result && result.size()>0){
            return result;
        }
        return null;
    }
}
