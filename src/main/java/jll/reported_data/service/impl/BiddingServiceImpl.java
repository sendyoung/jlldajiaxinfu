package jll.reported_data.service.impl;

import jll.model.BasicPnformationSubmit.Bidding;
import jll.reported_data.dao.BiddingDao;
import jll.reported_data.service.BiddingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service()
@Transactional
public class BiddingServiceImpl implements BiddingService {

    //调用dao层
    @Autowired
    private BiddingDao biddingDao;
    @Override
    public void addBidding(List<Bidding> bidding) {
        for(Bidding sh:bidding){
            biddingDao.addBidding(sh);
        }
    }

    @Override
    public List queryBidding(String entId) {
        List result=biddingDao.queryBidding(entId);
        if(null!=result && result.size()>0){
            return result;
        }
        return null;
    }
}
