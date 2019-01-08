package jll.reported_data.service;

import jll.model.basic_pnformation_submit.WebsiteRecords;

import java.util.List;

public interface WebsiteFilingService {
    /**
     * 添加网站备案
     */
    public void addWebsiteFilingService(List<WebsiteRecords> websiteRecords);

    /**
     * 查询网站备案
     */
    public List queryWebsiteFilingService(String entId);
}
