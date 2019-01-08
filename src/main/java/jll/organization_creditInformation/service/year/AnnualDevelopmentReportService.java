package jll.organization_creditInformation.service.year;

import jll.model.org_organization.AnnualDevelopmentReport;

import java.util.List;

/**
 * 年度发展报告
 */
public interface AnnualDevelopmentReportService {
    /**
     * 添加
     */
    public void addAnnualDevelopmentReport(List<AnnualDevelopmentReport> annualDevelopmentReport);

    /**
     * 查询
     */
    public List queryAnnualDevelopmentReport(String auth_org_id);
}
