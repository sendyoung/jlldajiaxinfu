package jll.reportedData.service.impl;

import jll.model.BasicPnformationSubmit.QualificationAuthentication;
import jll.reportedData.dao.CertificationDao;
import jll.reportedData.service.CertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service()
@Transactional
public class CertificationServiceImpl implements CertificationService {
    //调用dao层
    @Autowired
    private CertificationDao certificationDao;


    @Override
    public void addCertification(List<QualificationAuthentication> qualificationAuthentication) {
        for(QualificationAuthentication sh:qualificationAuthentication){
            certificationDao.addCertification(sh);
        }
    }

    @Override
    public List queryCertification(String entId) {
        List result=certificationDao.queryCertification(entId);
        if(null!=result && result.size()>0){
            return result;
        }
        return null;
    }
}
