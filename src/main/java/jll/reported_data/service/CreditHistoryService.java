package jll.reported_data.service;

import jll.model.basic_pnformation_submit.CreditRecord;

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
