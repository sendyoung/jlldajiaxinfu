package jll.reported_data.service;

import jll.model.basic_pnformation_submit.ProductionStatus;

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
