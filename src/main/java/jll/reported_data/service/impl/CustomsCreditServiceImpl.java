package jll.reported_data.service.impl;

import jll.model.basic_pnformation_submit.CustomsCreditInformation;
import jll.reported_data.dao.CustomsCreditDao;
import jll.reported_data.service.CustomsCreditService;
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
