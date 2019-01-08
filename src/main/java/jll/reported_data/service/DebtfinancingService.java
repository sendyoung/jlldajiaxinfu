package jll.reported_data.service;

import jll.model.basic_pnformation_submit.BondFinancing;

import java.util.List;

public interface DebtfinancingService {
    /**
     * 添加债权融资
     */
    public void addDebtfinancing(List<BondFinancing> bondFinancing);
    /**
     * 查询债权融资
     */
    public List queryDebtfinancing(String entId);
}
