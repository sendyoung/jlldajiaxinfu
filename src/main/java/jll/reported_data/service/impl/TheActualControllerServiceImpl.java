package jll.reported_data.service.impl;

import jll.model.BasicPnformationSubmit.ActualController;
import jll.reported_data.dao.TheActualControllerDao;
import jll.reported_data.service.TheActualControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service()
@Transactional
public class TheActualControllerServiceImpl implements TheActualControllerService {
    //调用dao层
    @Autowired
    private TheActualControllerDao theActualControllerDao;
    @Override
    public void addActualController(List<ActualController> ActualController) {
        for(ActualController sh:ActualController){
            theActualControllerDao.addTheActualController(sh);
        }
    }

    @Override
    public List queryActualController(String entId) {
        List result=theActualControllerDao.queryTheActualController(entId);
        if(null!=result && result.size()>0){
            return result;
        }
        return null;
    }
}
