package jll.apply_evaluate.service;

import jll.model.apply_evaluate.CreditFile;

public interface CreditFileService {

    /**
     * 添加信用档案
     * */
    public void editCreditFile(CreditFile CreditFile);
    /**
     * 回显企业档案
     * */
    public Object findCreditFileByAuthEnterpriseId(String authEnterpriseId);
}
