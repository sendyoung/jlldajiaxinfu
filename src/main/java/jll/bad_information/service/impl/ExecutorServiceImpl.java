package jll.bad_information.service.impl;

import jll.bad_information.dao.ExecutorDao;
import jll.bad_information.service.ExecutorService;
import jll.model.bad_information.Executor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("executorService")
@Transactional
public class ExecutorServiceImpl implements ExecutorService {

    @Autowired
    private ExecutorDao executorDao;//被执行人

    @Override
    public List getExecutor(String entId) {
        List result=executorDao.queryExecutor(entId);
        if(null!=result && result.size()>0){
            return result;
        }
        return null;
    }

    @Override
    public void editExecutor(List<Executor> eList) {
        for(Executor e:eList){
            executorDao.saveExecutor(e);
        }
    }
}
