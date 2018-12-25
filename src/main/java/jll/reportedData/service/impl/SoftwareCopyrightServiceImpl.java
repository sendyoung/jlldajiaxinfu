package jll.reportedData.service.impl;

import jll.model.BasicPnformationSubmit.SoftwareCopyright;
import jll.reportedData.dao.SoftwareCopyrightDao;
import jll.reportedData.service.SoftwareCopyrightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service()
@Transactional
public class SoftwareCopyrightServiceImpl implements SoftwareCopyrightService {

    //调用dao层
    @Autowired
    private  SoftwareCopyrightDao softwareCopyrightDao;
    @Override
    public void addSoftwareCopyright(List<SoftwareCopyright> softwareCopyright) {
        for(SoftwareCopyright sh:softwareCopyright){
            softwareCopyrightDao.addSoftwareCopyright(sh);
        }
    }

    @Override
    public List querySoftwareCopyright(String entId) {
        List result=softwareCopyrightDao.querySoftwareCopyright(entId);
        if(null!=result && result.size()>0){
            return result;
        }
        return null;
    }
}
