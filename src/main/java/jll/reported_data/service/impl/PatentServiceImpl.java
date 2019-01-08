package jll.reported_data.service.impl;

import jll.model.basic_pnformation_submit.PatentInformation;
import jll.reported_data.dao.PatentDao;
import jll.reported_data.service.PatentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service()
@Transactional
public class PatentServiceImpl implements PatentService {
    //调用dao层
    @Autowired
    private PatentDao patentDao;
    @Override
    public void addPatent(List<PatentInformation> patentInformation) {
        for(PatentInformation sh:patentInformation){
            patentDao.addPatent(sh);
        }
    }

    @Override
    public List queryPatent(String entId) {
        List result=patentDao.queryPatent(entId);
        if(null!=result && result.size()>0){
            return result;
        }
        return null;
    }
}
