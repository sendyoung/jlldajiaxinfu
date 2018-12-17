package jll.bad_information.service.impl;

import jll.bad_information.dao.AdministrativeSanctionDao;
import jll.bad_information.service.AdministrativeSanctionService;
import jll.model.bad_information.AdministrativeSanction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("administrativeSanctionService")
@Transactional
public class AdministrativeSanctionServiceImpl implements AdministrativeSanctionService {

    @Autowired
    private AdministrativeSanctionDao administrativeSanctionDao;//经营异常

    @Override
    public List getAdministrativeSanction(String entId) {
        List result=administrativeSanctionDao.queryAdministrativeSanction(entId);
        if(null!=result && result.size()>0){
            return result;
        }
        return null;
    }

    @Override
    public void editAdministrativeSanction(List<AdministrativeSanction> asList) {
        for(AdministrativeSanction as:asList){
            administrativeSanctionDao.saveAdministrativeSanction(as);
        }
    }
}
