package jll.reportedData.service;


import jll.model.BasicPnformationSubmit.CustomsRegistrationInformation;

import java.util.List;

public interface CustomsRegistrationService {
    /**
     * 添加海关注册信息
     */
    public void addCustomsRegistration(List<CustomsRegistrationInformation> customsRegistrationInformation);
    /**
     * 查询海关注册信息
     */
    public List queryCustomsRegistration(String entId);
}
