package jll.organization_creditInformation.service.year;

import jll.model.org_organization.AnnualReport;

import java.util.List;

/**
 * 组织年报
 */
public interface AnnualReportService {

    /**
     * 添加
     */
    public void addAnnualReport(List<AnnualReport> annualReport);


    /**
     * 查询
     */
    public List queryAnnualReport(String auth_org_id);
}
