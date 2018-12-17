package jll.bad_information.service.impl;

import jll.bad_information.dao.CourtSessionNoticeDao;
import jll.bad_information.service.CourtSessionNoticeService;
import jll.model.bad_information.CourtSessionNotice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("courtSessionNoticeService")
@Transactional
public class CourtSessionNoticeServiceImpl implements CourtSessionNoticeService {

    @Autowired
    private CourtSessionNoticeDao courtSessionNoticeDao;//欠税公告

    @Override
    public List getCourtSessionNotice(String entId) {
        List result=courtSessionNoticeDao.queryCourtSessionNotice(entId);
        if(null!=result && result.size()>0){
            return result;
        }
        return null;
    }

    @Override
    public void editCourtSessionNotice(List<CourtSessionNotice> csnList) {
        for(CourtSessionNotice csn:csnList){
            courtSessionNoticeDao.saveCourtSessionNotice(csn);
        }
    }
}
