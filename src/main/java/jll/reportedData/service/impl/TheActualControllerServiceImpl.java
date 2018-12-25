package jll.reportedData.service.impl;

import jll.model.BasicPnformationSubmit.ActualController;
import jll.reportedData.dao.TheActualControllerDao;
import jll.reportedData.service.TheActualControllerService;
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
