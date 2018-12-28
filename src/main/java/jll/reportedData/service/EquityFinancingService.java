package jll.reportedData.service;

import jll.model.BasicPnformationSubmit.EquityFinancing;

import java.util.List;

public interface EquityFinancingService {
    /**
     * 添加股权融资
     */
    public void addEquityFinancing(List<EquityFinancing> equityFinancing);
    /**
     * 查询股权融资
     */
    public List queryEquityFinancing(String entId);

}
