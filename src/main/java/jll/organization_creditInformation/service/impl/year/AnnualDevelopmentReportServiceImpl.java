package jll.organization_creditInformation.service.impl.year;

import jll.organization_creditInformation.dao.year.AnnualDevelopmentReportDao;
import jll.organization_creditInformation.service.year.AnnualDevelopmentReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AnnualDevelopmentReportServiceImpl implements AnnualDevelopmentReportService {

    @Autowired
    private AnnualDevelopmentReportDao annualDevelopmentReportDao;     // 年度发展报告

    /**
     * 添加年度报告
     */
    @Override
    public void addAnnualDevelopmentReport() {

    }

    /**
     * 回显年度报告
     */
    @Override
    public List queryAnnualDevelopmentReport(String auth_org_id) {

        List result=annualDevelopmentReportDao.queryAnnualDevelopmentReport(auth_org_id);
        if(null!=result && result.size()>0){
            return result;
        }
        return null;
    }
}
