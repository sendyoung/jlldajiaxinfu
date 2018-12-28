package jll.account_authentication.service.impl;

import jll.account_authentication.dao.EntBasicsDao;
import jll.account_authentication.service.EntBasicsService;
import jll.model.enterprise.EntBasics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("entBasicsService")
@Transactional
public class EntBasicsServiceImpl implements EntBasicsService {

    @Autowired
    private EntBasicsDao entBasicsDao;//工商信息

    @Override
    public EntBasics findEntBasics(String authEnterpriseId) {
        return entBasicsDao.queryEntBasics(authEnterpriseId);
    }

    @Override
    public void editEntBasics(EntBasics entBasics) {
        entBasicsDao.updateEntBasics(entBasics);
    }
}
