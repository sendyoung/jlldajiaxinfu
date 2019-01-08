package jll.reported_data.service.impl;

import jll.model.BasicPnformationSubmit.WebsiteRecords;
import jll.reported_data.dao.WebsiteFilingDao;
import jll.reported_data.service.WebsiteFilingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service()
@Transactional
public class WebsiteFilingServiceImpl implements WebsiteFilingService {
    //调用dao层
    @Autowired
    private WebsiteFilingDao websiteFilingDao;
    @Override
    public void addWebsiteFilingService(List<WebsiteRecords> websiteRecords) {
        for(WebsiteRecords sh:websiteRecords){
            websiteFilingDao.addWebsiteFiling(sh);
        }
    }

    @Override
    public List queryWebsiteFilingService(String entId) {
        List result=websiteFilingDao.queryWebsiteFiling(entId);
        if(null!=result && result.size()>0){
            return result;
        }
        return null;
    }
}
