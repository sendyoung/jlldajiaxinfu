package jll.reportedData.service;

import jll.model.BasicPnformationSubmit.CreditRecord;

import java.util.List;

public interface CreditHistoryService {
    /**
     * 添加信用记录
     */
    public void addCreditHistory(List<CreditRecord> creditRecord);
    /**
     * 查询信用记录
     */
    public List queryCreditHistory(String entId);
}
