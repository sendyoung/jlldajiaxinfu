package jll.reported_data.service;


import jll.model.basic_pnformation_submit.ActualController;

import java.util.List;

public interface TheActualControllerService {



    /**
     * 添加实际控制人
     */
    public void addActualController(List<ActualController> ActualController);

    /**
     * 查询实际控制人
     */
    public List queryActualController(String entId);

}
