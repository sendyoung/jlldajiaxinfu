package jll.reported_data.service.impl;

import jll.model.BasicPnformationSubmit.ChangeRecord;
import jll.reported_data.dao.ChangeInformationDao;
import jll.reported_data.service.ChangeInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service()
@Transactional
public class ChangeInformationServiceImpl implements ChangeInformationService {
    //调用dao层
    @Autowired
    private ChangeInformationDao changeInformationDao;  //变更信息
    @Override
    public void addChangeInformation(List<ChangeRecord> crList) {
        for(ChangeRecord sh:crList){
            changeInformationDao.addChangeInformation(sh);
        }
    }

    @Override
    public List queryChangeInformation(String entId) {
        List result=changeInformationDao.queryChangeInformation(entId);
        if(null!=result && result.size()>0){
            return result;
        }
        return null;
    }
}
