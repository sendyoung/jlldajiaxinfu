package jll.reported_data.service;

import jll.model.basic_pnformation_submit.ChangeRecord;

import java.util.List;

public interface ChangeInformationService {


    /**
     * 添加变更记录信息
     */
    public void addChangeInformation(List<ChangeRecord> crList);

    /**
     * 查询变更记录信息
     */
    public List queryChangeInformation(String entId);
}
