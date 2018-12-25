package jll.reportedData.service.impl;

import jll.model.BasicPnformationSubmit.CustomsRegistrationInformation;
import jll.reportedData.dao.CustomsRegistrationDao;
import jll.reportedData.service.CustomsRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service()
@Transactional
public class CustomsRegistrationServiceImpl implements CustomsRegistrationService {
    //调用dao层
    @Autowired
    private CustomsRegistrationDao customsRegistrationDao;

    @Override
    public void addCustomsRegistration(List<CustomsRegistrationInformation> customsRegistrationInformation) {
        for(CustomsRegistrationInformation sh:customsRegistrationInformation){
            customsRegistrationDao.addCustomsRegistration(sh);
        }
    }


    @Override
    public List queryCustomsRegistration(String entId) {
        List result=customsRegistrationDao.queryCustomsRegistration(entId);
        if(null!=result && result.size()>0){
            return result;
        }
        return null;
    }
}