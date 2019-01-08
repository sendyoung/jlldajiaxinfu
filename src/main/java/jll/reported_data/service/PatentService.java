package jll.reported_data.service;


import jll.model.basic_pnformation_submit.PatentInformation;

import java.util.List;

public interface PatentService {
    /**
     *  专利信息
     */
    public void addPatent(List<PatentInformation> patentInformation);
    /**
     * 查询专利信息
     */
    public List queryPatent(String entId);
}
