package jll.reported_data.service.impl;

import jll.model.BasicPnformationSubmit.SocialSecurity;
import jll.reported_data.dao.SocialSecurityDao;
import jll.reported_data.service.SocialSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service()
@Transactional
public class SocialSecurityServiceImpl implements SocialSecurityService {
    //调用dao层
    @Autowired
    private SocialSecurityDao socialSecurityDao;
    @Override
    public void addSocialSecurity(List<SocialSecurity> socialSecurity) {
        for(SocialSecurity sh:socialSecurity){
            socialSecurityDao.addSocialSecurity(sh);
        }
    }

    @Override
    public List querySocialSecurity(String entId) {
        List result=socialSecurityDao.querySocialSecurity(entId);
        if(null!=result && result.size()>0){
            return result;
        }
        return null;
    }
}
