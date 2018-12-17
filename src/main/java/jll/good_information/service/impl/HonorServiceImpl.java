package jll.good_information.service.impl;

import jll.good_information.dao.HonorDao;
import jll.good_information.service.HonorService;
import jll.model.good_information.Honor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("honorService")
@Transactional
public class HonorServiceImpl implements HonorService {

    @Autowired
    private HonorDao honorDao;//表彰

    @Override
    public List getHonor(String entId) {
        List result=honorDao.queryHonor(entId);
        if(null!=result && result.size()>0){
            return result;
        }
        return null;
    }

    @Override
    public void editHonor(List<Honor> honorList) {
        for(Honor h:honorList){
            honorDao.saveHonor(h);
        }
    }
}
