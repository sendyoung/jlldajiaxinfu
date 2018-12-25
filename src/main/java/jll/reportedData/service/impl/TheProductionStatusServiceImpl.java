package jll.reportedData.service.impl;

import jll.model.BasicPnformationSubmit.ProductionStatus;
import jll.reportedData.dao.TheProductionStatusDao;
import jll.reportedData.service.TheProductionStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service()
@Transactional
public class TheProductionStatusServiceImpl implements TheProductionStatusService {
    //调用dao层
    @Autowired
    private TheProductionStatusDao theProductionStatusDao;
    @Override
    public void addTheProductionStatus(List<ProductionStatus> productionStatus) {
        for(ProductionStatus sh:productionStatus){
            theProductionStatusDao.addTheProductionStatus(sh);
        }
    }

    @Override
    public List queryTheProductionStatus(String entId) {
        List result=theProductionStatusDao.queryTheProductionStatus(entId);
        if(null!=result && result.size()>0){
            return result;
        }
        return null;
    }
}
