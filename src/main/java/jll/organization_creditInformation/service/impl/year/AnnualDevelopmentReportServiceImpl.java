package jll.organization_creditInformation.service.impl.year;

import jll.model.org_organization.AnnualDevelopmentReport;
import jll.organization_creditInformation.dao.year.AnnualDevelopmentReportDao;
import jll.organization_creditInformation.service.year.AnnualDevelopmentReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 年度发展报告
 */
@Service
@Transactional
public class AnnualDevelopmentReportServiceImpl implements AnnualDevelopmentReportService {

    @Autowired
    private AnnualDevelopmentReportDao annualDevelopmentReportDao;     // 年度发展报告

    /**
     * 添加年度发展报告
     */
    @Override
    public void addAnnualDevelopmentReport(List<AnnualDevelopmentReport> annualDevelopmentReport) {
        for (AnnualDevelopmentReport ar:annualDevelopmentReport){
            annualDevelopmentReportDao.addAnnualDevelopmentReport(ar);
        }
    }

    /**
     * 回显年度发展报告
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
