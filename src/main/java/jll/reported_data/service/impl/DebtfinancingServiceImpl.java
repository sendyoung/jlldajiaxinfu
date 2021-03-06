package jll.reported_data.service.impl;

import jll.model.basic_pnformation_submit.BondFinancing;
import jll.reported_data.dao.DebtfinancingDao;
import jll.reported_data.service.DebtfinancingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service()
@Transactional
public class DebtfinancingServiceImpl implements DebtfinancingService {
    //调用dao层
    @Autowired
    private DebtfinancingDao debtfinancingDao;
    @Override
    public void addDebtfinancing(List<BondFinancing> bondFinancing) {
        for(BondFinancing sh:bondFinancing){
            debtfinancingDao.addDebtfinancing(sh);
        }
    }

    @Override
    public List queryDebtfinancing(String entId) {

        List result=debtfinancingDao.queryDebtfinancing(entId);
        if(null!=result && result.size()>0){
            return result;
        }
        return null;
    }
}
