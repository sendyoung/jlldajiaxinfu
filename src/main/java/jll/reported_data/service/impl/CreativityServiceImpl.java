package jll.reported_data.service.impl;

import jll.model.basic_pnformation_submit.InnovationAbility;
import jll.reported_data.dao.CreativityDao;
import jll.reported_data.service.CreativityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service()
@Transactional
public class CreativityServiceImpl implements CreativityService {
    //调用dao层
    @Autowired
    private CreativityDao creativityDao;
    @Override
    public void addTheProductionStatus(List<InnovationAbility> innovationAbility) {
        for(InnovationAbility sh:innovationAbility){
            creativityDao.addCreativity(sh);
        }
    }

    @Override
    public List queryTheProductionStatus(String entId) {
        List result=creativityDao.queryCreativity(entId);
        if(null!=result && result.size()>0){
            return result;
        }
        return null;
    }
}
