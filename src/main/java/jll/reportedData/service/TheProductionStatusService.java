package jll.reportedData.service;

import jll.model.BasicPnformationSubmit.ProductionStatus;

import java.util.List;

public interface TheProductionStatusService {

    /**
     * 添加生产情况
     */
    public void addTheProductionStatus(List<ProductionStatus> productionStatus);
    /**
     * 查询生产情况
     */
    public List queryTheProductionStatus(String entId);
}