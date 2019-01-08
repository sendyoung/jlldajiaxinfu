package jll.reported_data.service;


import jll.model.basic_pnformation_submit.ShareholderContributionInfo;

import java.util.List;

public interface ShareholdersInvestmentService {


    /**
     * 添加股东出资信息
     */
    public void addShareholdersInvestment(List<ShareholderContributionInfo> shList);

    /**
     * 查询股东出资信息
     */
    public List queryShareholdersInvestment(String entId);
}
