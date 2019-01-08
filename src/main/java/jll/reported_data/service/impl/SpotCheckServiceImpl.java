package jll.reported_data.service.impl;

import jll.model.BasicPnformationSubmit.Check;
import jll.reported_data.dao.SpotCheckDao;
import jll.reported_data.service.SpotCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service()
@Transactional
public class SpotCheckServiceImpl implements SpotCheckService {
    //调用dao层
    @Autowired
    private SpotCheckDao spotCheckDao;
    @Override
    public void addSpotCheck(List<Check> check) {
        for(Check sh:check){
            spotCheckDao.addSpotCheck(sh);
        }
    }

    @Override
    public List querySpotCheck(String entId) {
        List result=spotCheckDao.querySpotCheck(entId);
        if(null!=result && result.size()>0){
            return result;
        }
        return null;
    }
}
