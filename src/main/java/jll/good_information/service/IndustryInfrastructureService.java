package jll.good_information.service;

import jll.model.good_information.IndustryInfrastructure;

import java.util.List;

public interface IndustryInfrastructureService {

    /**
     *获取表彰信息
     * */
    public List getIndustryInfrastructure(String entId);
    /**
     * 添加表彰信息
     * */
    public void editIndustryInfrastructure(List<IndustryInfrastructure> iiList);

}
