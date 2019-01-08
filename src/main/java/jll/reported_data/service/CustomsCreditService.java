package jll.reported_data.service;

import jll.model.basic_pnformation_submit.CustomsCreditInformation;

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
