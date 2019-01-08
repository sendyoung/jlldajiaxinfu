package jll.reported_data.service.impl;

import jll.model.basic_pnformation_submit.EnvironmentalProtectionSystemCertification;
import jll.reported_data.dao.EnvironmentalCertificationDao;
import jll.reported_data.service.EnvironmentalCertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service()
@Transactional
public class EnvironmentalCertificationServiceImpl implements EnvironmentalCertificationService {
    //调用dao层
    @Autowired
    private EnvironmentalCertificationDao environmentalCertificationDao;

    @Override
    public void addEnvironmentalCertification(List<EnvironmentalProtectionSystemCertification> environmentalProtectionSystemCertification) {
        for(EnvironmentalProtectionSystemCertification sh:environmentalProtectionSystemCertification){
            environmentalCertificationDao.addEnvironmentalCertification(sh);
        }
    }

    @Override
    public List queryEnvironmentalCertification(String entId) {
        List result=environmentalCertificationDao.queryEnvironmentalCertification(entId);
        if(null!=result && result.size()>0){
            return result;
        }
        return null;
    }
}
