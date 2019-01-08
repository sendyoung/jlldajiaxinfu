package jll.reported_data.service;


import jll.model.basic_pnformation_submit.CustomsRegistrationInformation;

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
