package jll.reported_data.service.impl;

import jll.model.BasicPnformationSubmit.EquityFinancing;
import jll.reported_data.dao.EquityFinancingDao;
import jll.reported_data.service.EquityFinancingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service()
@Transactional
public class EquityFinancingServiceImpl implements EquityFinancingService {
    //调用dao层
    @Autowired
    private EquityFinancingDao EquityFinancingDao;
    @Override
    public void addEquityFinancing(List<EquityFinancing> equityFinancing) {
        for(EquityFinancing sh:equityFinancing){
            EquityFinancingDao.addEquityFinancing(sh);
        }
    }

    @Override
    public List queryEquityFinancing(String entId) {
        List result=EquityFinancingDao.queryEquityFinancing(entId);
        if(null!=result && result.size()>0){
            return result;
        }
        return null;
    }
}
