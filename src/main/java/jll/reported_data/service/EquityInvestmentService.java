package jll.reported_data.service;

import jll.model.BasicPnformationSubmit.EquityInvestment;

import java.util.List;

public interface EquityInvestmentService {
    /**
     * 添加股权投资
     */
    public void addEquityInvestment(List<EquityInvestment> equityInvestment);
    /**
     * 查询股权投资
     */
    public List queryEquityInvestment(String entId);
}
