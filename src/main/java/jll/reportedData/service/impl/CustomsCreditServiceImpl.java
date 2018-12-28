package jll.reportedData.service.impl;

import jll.model.BasicPnformationSubmit.CustomsCreditInformation;
import jll.reportedData.dao.CustomsCreditDao;
import jll.reportedData.service.CustomsCreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service()
@Transactional
public class CustomsCreditServiceImpl implements CustomsCreditService {
    //调用dao层
    @Autowired
    private CustomsCreditDao customsCreditDao;
    @Override
    public void addCustomsCredit(List<CustomsCreditInformation> customsCreditInformation) {
        for(CustomsCreditInformation sh:customsCreditInformation){
            customsCreditDao.addCustomsCredit(sh);
        }
    }

    @Override
    public List queryCustomsCredit(String entId) {

        List result=customsCreditDao.queryCustomsCredit(entId);
        if(null!=result && result.size()>0){
            return result;
        }
        return null;
    }
}
