package jll.goog_information.service.impl;

import jll.goog_information.dao.HonorDao;
import jll.goog_information.service.HonorService;
import jll.model.Honor;
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
