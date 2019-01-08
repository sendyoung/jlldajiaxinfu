package jll.reported_data.service;

import jll.model.basic_pnformation_submit.Check;

import java.util.List;

public interface SpotCheckService {


    /**
     * 添加抽查信息
     */
    public void addSpotCheck(List<Check> check);
    /**
     * 查询抽查信息
     */
    public List querySpotCheck(String entId);
}
