package jll.reported_data.service;

import jll.model.basic_pnformation_submit.CreditorRightsInvestment;

import java.util.List;

public interface DebtInvestmentService {

    /**
     * 债权投资
     */
    public void addDebtInvestment(List<CreditorRightsInvestment> creditorRightsInvestment);
    /**
     * 查询债权投资
     */
    public List queryDebtInvestment(String entId);
}
