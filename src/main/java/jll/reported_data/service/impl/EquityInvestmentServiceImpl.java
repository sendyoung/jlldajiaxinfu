package jll.reported_data.service.impl;

import jll.model.basic_pnformation_submit.EquityInvestment;
import jll.reported_data.dao.EquityInvestmentDao;
import jll.reported_data.service.EquityInvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service()
@Transactional
public class EquityInvestmentServiceImpl implements EquityInvestmentService {
    //调用dao层
    @Autowired
    private EquityInvestmentDao equityInvestmentDao;
    @Override
    public void addEquityInvestment(List<EquityInvestment> equityInvestment) {
        for(EquityInvestment sh:equityInvestment){
            equityInvestmentDao.addEquityInvestment(sh);
        }
    }

    @Override
    public List queryEquityInvestment(String entId) {
        List result=equityInvestmentDao.queryEquityInvestment(entId);
        if(null!=result && result.size()>0){
            return result;
        }
        return null;
    }
}
