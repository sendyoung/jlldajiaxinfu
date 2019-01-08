package jll.reported_data.service.impl;

import jll.model.basic_pnformation_submit.CreditRecord;
import jll.reported_data.dao.CreditHistoryDao;
import jll.reported_data.service.CreditHistoryService;
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
