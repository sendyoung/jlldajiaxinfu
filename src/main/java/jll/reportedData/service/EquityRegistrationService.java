package jll.reportedData.service;

import jll.model.BasicPnformationSubmit.SharePledgeRegistration;

import java.util.List;

public interface EquityRegistrationService {
    /**
     * 添加股权出质登记信息
     */
    public void addEquityRegistration(List<SharePledgeRegistration> sharePledgeRegistration);
    /**
     * 查询股权出质登记信息
     */
    public List queryEquityRegistration(String entId);
}
