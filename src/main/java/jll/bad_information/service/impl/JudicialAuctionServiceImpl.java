package jll.bad_information.service.impl;

import jll.bad_information.dao.JudicialAuctionDao;
import jll.bad_information.service.JudicialAuctionService;
import jll.model.bad_information.JudicialAuction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("judicialAuctionService")
@Transactional
public class JudicialAuctionServiceImpl implements JudicialAuctionService {

    @Autowired
    private JudicialAuctionDao judicialAuctionDao;//司法拍卖

    @Override
    public List getJudicialAuction(String entId) {
        List result=judicialAuctionDao.queryJudicialAuction(entId);
        if(null!=result && result.size()>0){
            return result;
        }
        return null;
    }

    @Override
    public void editJudicialAuction(List<JudicialAuction> jaList) {
        for(JudicialAuction ja:jaList){
            judicialAuctionDao.saveJudicialAuction(ja);
        }
    }
}
