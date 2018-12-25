package jll.reportedData.service.impl;

import jll.model.BasicPnformationSubmit.IntellectualProperty;
import jll.reportedData.dao.InPropertyRightsDao;
import jll.reportedData.service.InPropertyRightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service()
@Transactional
public class InPropertyRightsServiceImpl implements InPropertyRightsService {
    //调用dao层
    @Autowired
    private InPropertyRightsDao inPropertyRightsDao;

    @Override
    public void addInPropertyRights(List<IntellectualProperty> intellectualProperty) {
        for(IntellectualProperty sh:intellectualProperty){
            inPropertyRightsDao.addInPropertyRights(sh);
        }
    }

    @Override
    public List queryInPropertyRights(String entId) {
        List result=inPropertyRightsDao.queryInPropertyRights(entId);
        if(null!=result && result.size()>0){
            return result;
        }
        return null;
    }
}
