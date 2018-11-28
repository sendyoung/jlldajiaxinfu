package jll.goog_information.service.impl;

import jll.goog_information.dao.HonorDao;
import jll.goog_information.dao.IndustryInfrastructureDao;
import jll.goog_information.service.HonorService;
import jll.goog_information.service.IndustryInfrastructureService;
import jll.model.Honor;
import jll.model.IndustryInfrastructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("industryInfrastructureService")
@Transactional
public class IndustryInfrastructureServiceImpl implements IndustryInfrastructureService {

    @Autowired
    private IndustryInfrastructureDao industryInfrastructureDao;//表彰

    @Override
    public List getIndustryInfrastructure(String entId) {
        List result=industryInfrastructureDao.queryIndustryInfrastructure(entId);
        if(null!=result && result.size()>0){
            return result;
        }
        return null;
    }

    @Override
    public void editIndustryInfrastructure(List<IndustryInfrastructure> iiList) {
        for(IndustryInfrastructure ii:iiList){
            industryInfrastructureDao.saveIndustryInfrastructure(ii);
        }
    }
}
