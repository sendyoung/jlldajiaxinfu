package jll.reported_data.service;


import jll.model.BasicPnformationSubmit.AutomationConstruction;

import java.util.List;

public interface AutoConstructionService {
    /**
     * 添加自动化建设
     */
    public void addAutoConstruction(List<AutomationConstruction> automationConstruction);

    /**
     * 查询自动化建设
     */
    public List queryAutoConstruction(String entId);
}
