package jll.bad_information.service.impl;

import jll.bad_information.dao.AdministrativePublishmentDao;
import jll.bad_information.service.AdministrativePublishmentService;
import jll.model.bad_information.AdministrativePublishment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("administrativePublishmentService")
@Transactional
public class AdministrativePublishmentServiceImpl implements AdministrativePublishmentService {

    @Autowired
    private AdministrativePublishmentDao administrativePublishmentDao;//行政处罚

    @Override
    public List getAdministrativePublishment(String entId) {
        List result=administrativePublishmentDao.queryAdministrativePublishment(entId);
        if(null!=result && result.size()>0){
            return result;
        }
        return null;
    }

    @Override
    public void editAdministrativePublishment(List<AdministrativePublishment> apList) {
        for(AdministrativePublishment ap:apList){
            administrativePublishmentDao.saveAdministrativePublishment(ap);
        }
    }
}
