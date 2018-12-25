package jll.reportedData.service.impl;

import jll.model.BasicPnformationSubmit.Trademark;
import jll.reportedData.dao.TrademarkDao;
import jll.reportedData.service.TrademarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service()
@Transactional
public class TrademarkServiceImpl implements TrademarkService {
    //调用dao层
    @Autowired
    private TrademarkDao trademarkDao;
    @Override
    public void addTrademark(List<Trademark> trademark) {
        for(Trademark sh:trademark){
            trademarkDao.addTrademark(sh);
        }
    }

    @Override
    public List queryTrademark(String entId) {
        List result=trademarkDao.queryTrademark(entId);
        if(null!=result && result.size()>0){
            return result;
        }
        return null;
    }
}