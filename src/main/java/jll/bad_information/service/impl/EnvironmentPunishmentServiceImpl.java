package jll.bad_information.service.impl;

import jll.bad_information.dao.EnvironmentPunishmentDao;
import jll.bad_information.service.EnvironmentPunishmentService;
import jll.model.bad_information.EnvironmentPunishment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("environmentPunishmeentService")
@Transactional
public class EnvironmentPunishmentServiceImpl implements EnvironmentPunishmentService {

    @Autowired
    private EnvironmentPunishmentDao environmentPunishmentDao;//环保处罚

    @Override
    public List getEnvironmentPunishment(String entId) {
        List result=environmentPunishmentDao.queryEnvironmentPunishment(entId);
        if(null!=result && result.size()>0){
            return result;
        }
        return null;
    }

    @Override
    public void editEnvironmentPunishment(List<EnvironmentPunishment> epList) {
        for(EnvironmentPunishment ep:epList){
            environmentPunishmentDao.saveEnvironmentPunishment(ep);
        }
    }
}
