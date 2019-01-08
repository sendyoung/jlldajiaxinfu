package jll.organization_creditInformation.service.year;

import java.util.List;

/**
 * 年度发展报告
 */
public interface AnnualDevelopmentReportService {
    /**
     * 添加
     */
    public void addAnnualDevelopmentReport();

    /**
     * 查询
     */
    public List queryAnnualDevelopmentReport(String auth_org_id);
}
