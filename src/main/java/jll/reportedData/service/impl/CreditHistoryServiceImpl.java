package jll.reportedData.service.impl;

import jll.model.BasicPnformationSubmit.CreditRecord;
import jll.reportedData.dao.CreditHistoryDao;
import jll.reportedData.service.CreditHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service()
@Transactional
public class CreditHistoryServiceImpl implements CreditHistoryService {
    //调用dao层
    @Autowired
    private CreditHistoryDao creditHistoryDao;

    @Override
    public void addCreditHistory(List<CreditRecord> creditRecord) {
        for(CreditRecord sh:creditRecord){
            creditHistoryDao.addCreditHistory(sh);
        }
    }

    @Override
    public List queryCreditHistory(String entId) {
        List result=creditHistoryDao.queryCreditHistory(entId);
        if(null!=result && result.size()>0){
            return result;
        }
        return null;
    }
}
