package jll.reported_data.service.impl;

import jll.model.basic_pnformation_submit.ExternalGuaranteeInformation;
import jll.reported_data.dao.ExternalGuaranteeDao;
import jll.reported_data.service.ExternalGuaranteeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service()
@Transactional
public class ExternalGuaranteeServiceImpl implements ExternalGuaranteeService {
    //调用dao层
    @Autowired
    private ExternalGuaranteeDao externalGuaranteeDao;
    @Override
    public void addExternalGuarantee(List<ExternalGuaranteeInformation> externalGuaranteeInformation) {
        for(ExternalGuaranteeInformation sh:externalGuaranteeInformation){
            externalGuaranteeDao.addExternalGuarantee(sh);
        }
    }

    @Override
    public List queryExternalGuarantee(String entId) {
        List result=externalGuaranteeDao.queryExternalGuarantee(entId);
        if(null!=result && result.size()>0){
            return result;
        }
        return null;
    }
}
