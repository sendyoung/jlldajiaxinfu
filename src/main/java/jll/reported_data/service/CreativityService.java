package jll.reported_data.service;


import jll.model.basic_pnformation_submit.InnovationAbility;

import java.util.List;

public interface CreativityService {

    /**
     * 添加创新能力
     */

    public void addTheProductionStatus(List<InnovationAbility> innovationAbility);
    /**
     * 查询创新能力
     */
    public List queryTheProductionStatus(String entId);
}
