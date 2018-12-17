package jll.bad_information.service.impl;

import jll.bad_information.dao.DiscreditExecutorDao;
import jll.bad_information.service.DiscreditExecutorService;
import jll.model.bad_information.DiscreditExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("discreditExecutorService")
@Transactional
public class DiscreditExecutorServiceImpl implements DiscreditExecutorService {

    @Autowired
    private DiscreditExecutorDao discreditExecutorDao;//被执行人

    @Override
    public List getDiscreditExecutor(String entId) {
        List result=discreditExecutorDao.queryDiscreditExecutor(entId);
        if(null!=result && result.size()>0){
            return result;
        }
        return null;
    }

    @Override
    public void editDiscreditExecutor(List<DiscreditExecutor> deList) {
        for(DiscreditExecutor de:deList){
            discreditExecutorDao.saveDiscreditExecutor(de);
        }
    }
}
