package jll.good_information.service.impl;

import jll.good_information.dao.PublicWelfareActivityDao;
import jll.good_information.service.PublicWelfareActivityService;
import jll.model.good_information.PublicWelfareActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("publicWelfareActivityService")
@Transactional
public class PublicWelfareActivityServiceImpl implements PublicWelfareActivityService {

    @Autowired
    private PublicWelfareActivityDao publicWelfareActivityDao;//公益

    @Override
    public List getPublicWelfareActivity(String entId) {
        List result=publicWelfareActivityDao.queryPublicWelfareActivity(entId);
        if(null!=result && result.size()>0){
            return result;
        }
        return null;
    }

    @Override
    public void editPublicWelfareActivity(List<PublicWelfareActivity> pwaList) {
        for(PublicWelfareActivity pwa:pwaList){
            publicWelfareActivityDao.savePublicWelfareActivity(pwa);
        }
    }
}
