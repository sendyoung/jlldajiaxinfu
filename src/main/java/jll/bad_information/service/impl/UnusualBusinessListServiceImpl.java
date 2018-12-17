package jll.bad_information.service.impl;

import jll.bad_information.dao.UnusualBusinessListDao;
import jll.bad_information.service.UnusualBusinessListService;
import jll.model.bad_information.UnusualBusinessList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("unusualBusinessListService")
@Transactional
public class UnusualBusinessListServiceImpl implements UnusualBusinessListService {

    @Autowired
    private UnusualBusinessListDao unusualBusinessListDao;//经营异常

    @Override
    public List getUnusualBusinessList(String entId) {
        List result=unusualBusinessListDao.queryUnusualBusinessList(entId);
        if(null!=result && result.size()>0){
            return result;
        }
        return null;
    }

    @Override
    public void editUnusualBusinessList(List<UnusualBusinessList> ublList) {
        for(UnusualBusinessList ubl:ublList){
            unusualBusinessListDao.saveUnusualBusinessList(ubl);
        }
    }
}
