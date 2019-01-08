package jll.reported_data.service.impl;

import jll.model.basic_pnformation_submit.ServiceByPublication;
import jll.reported_data.dao.PublicNoticeDao;
import jll.reported_data.service.PublicNoticeService;
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
