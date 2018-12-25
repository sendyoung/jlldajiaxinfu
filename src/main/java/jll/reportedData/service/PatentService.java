package jll.reportedData.service;


import jll.model.BasicPnformationSubmit.PatentInformation;

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
