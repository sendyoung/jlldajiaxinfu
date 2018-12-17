package jll.bad_information.service.impl;

import jll.bad_information.dao.ContraventionDao;
import jll.bad_information.service.ContraventionService;
import jll.model.bad_information.Contravention;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("contraventionService")
@Transactional
public class ContraventionServiceImpl implements ContraventionService {

    @Autowired
    private ContraventionDao contraventionDao;//欠税公告

    @Override
    public List getContravention(String entId) {
        List result=contraventionDao.queryContravention(entId);
        if(null!=result && result.size()>0){
            return result;
        }
        return null;
    }

    @Override
    public void editContravention(List<Contravention> cList) {
        for(Contravention c:cList){
            contraventionDao.saveContravention(c);
        }
    }
}
