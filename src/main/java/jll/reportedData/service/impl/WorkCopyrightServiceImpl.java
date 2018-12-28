package jll.reportedData.service.impl;

import jll.model.BasicPnformationSubmit.CopyrightInWorks;
import jll.reportedData.dao.WorkCopyrightDao;
import jll.reportedData.service.WorkCopyrightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service()
@Transactional
public class WorkCopyrightServiceImpl implements WorkCopyrightService {

    //调用dao层
    @Autowired
    private WorkCopyrightDao workCopyrightDao;
    @Override
    public void addWorkCopyright(List<CopyrightInWorks> copyrightInWorks) {
        for(CopyrightInWorks sh:copyrightInWorks){
            workCopyrightDao.addWorkCopyright(sh);
        }
    }

    @Override
    public List queryWorkCopyright(String entId) {
//        List result=workCopyrightDao.queryWorkCopyright(entId);
        List result=workCopyrightDao.queryWorkCopyright(entId);
//        if(null!=result && result.size()>0){
//            return result;
//        }
        if(result!=null && result.size()>0){
            return result;
        }
        return null;
    }
}
