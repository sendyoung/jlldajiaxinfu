package jll.organization_creditInformation.service.impl.year;

import jll.model.org_organization.AnnualReport;
import jll.organization_creditInformation.dao.year.AnnualReportDao;
import jll.organization_creditInformation.service.year.AnnualReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 组织年报
 */
@Service
@Transactional
public class AnnualReportServiceImpl implements AnnualReportService {

    @Autowired
    private AnnualReportDao annualReportDao;  //组织年报dao

    /**
     * 添加
     */
    @Override
    public void addAnnualReport(List<AnnualReport> annualReport) {

        for (AnnualReport ar:annualReport){
            annualReportDao.addAnnualReport(ar);
        }

    }

    /**
     * 查询回显
     * @param auth_org_id
     */
    @Override
    public List queryAnnualReport(String auth_org_id) {

        List result=annualReportDao.queryAnnualReport(auth_org_id);
        if(null!=result && result.size()>0){
            return result;
        }
        return null;
    }
}
