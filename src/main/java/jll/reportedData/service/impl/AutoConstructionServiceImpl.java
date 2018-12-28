package jll.reportedData.service.impl;

import jll.model.BasicPnformationSubmit.AutomationConstruction;
import jll.reportedData.dao.AutoConstructionDao;
import jll.reportedData.service.AutoConstructionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service()
@Transactional
public class AutoConstructionServiceImpl implements AutoConstructionService {

    // 自动化建设
    @Autowired
    private AutoConstructionDao autoConstructionDao;


    @Override
    public void addAutoConstruction(List<AutomationConstruction> automationConstruction) {
        for(AutomationConstruction sh:automationConstruction){
            autoConstructionDao.addAutoConstruction(sh);
        }
    }

    @Override
    public List queryAutoConstruction(String entId) {
        List result=autoConstructionDao.queryAutoConstruction(entId);
        if(null!=result && result.size()>0){
            return result;
        }
        return null;
    }
}
