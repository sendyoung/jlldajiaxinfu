package jll.reportedData.service.impl;

import jll.model.BasicPnformationSubmit.ServiceByPublication;
import jll.reportedData.dao.PublicNoticeDao;
import jll.reportedData.service.PublicNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service()
@Transactional
public class PublicNoticeServiceImpl implements PublicNoticeService {
    //调用dao层
    @Autowired
    private PublicNoticeDao publicNoticeDao;

    @Override
    public void addPublicNotice(List<ServiceByPublication> serviceByPublication) {
        for(ServiceByPublication sh:serviceByPublication){
            publicNoticeDao.addPublicNotice(sh);
        }
    }

    @Override
    public List queryPublicNotice(String entId) {
        List result=publicNoticeDao.queryPublicNotice(entId);
        if(null!=result && result.size()>0){
            return result;
        }
        return null;
    }
}