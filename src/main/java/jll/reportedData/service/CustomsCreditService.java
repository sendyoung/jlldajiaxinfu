package jll.reportedData.service;

import jll.model.BasicPnformationSubmit.CustomsCreditInformation;

import java.util.List;

public interface CustomsCreditService {

    /**
     * 添加海关信用信息
     */
    public void addCustomsCredit(List<CustomsCreditInformation> customsCreditInformation);
    /**
     * 查询海关信用信息
     */
    public List queryCustomsCredit(String entId);
}
