package jll.reportedData.service;

import jll.model.BasicPnformationSubmit.ExternalGuaranteeInformation;

import java.util.List;

public interface ExternalGuaranteeService {
    /**
     * 添加对外担保信息
     */
    public void addExternalGuarantee(List<ExternalGuaranteeInformation> externalGuaranteeInformation);

    /**
     * 查询对外担保信息
     */
    public List queryExternalGuarantee(String entId);
}
