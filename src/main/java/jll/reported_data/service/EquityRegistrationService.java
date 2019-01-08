package jll.reported_data.service;

import jll.model.basic_pnformation_submit.SharePledgeRegistration;

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
