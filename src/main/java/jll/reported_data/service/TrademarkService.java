package jll.reported_data.service;


import jll.model.basic_pnformation_submit.Trademark;

import java.util.List;

public interface TrademarkService {
    /**
     * 添加商标信息
     */
    public void addTrademark(List<Trademark> trademark);
    /**
     * 查询商标信息
     */
    public List queryTrademark(String entId);
}
