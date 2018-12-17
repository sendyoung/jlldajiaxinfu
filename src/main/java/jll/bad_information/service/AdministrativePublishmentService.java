package jll.bad_information.service;

import jll.model.bad_information.AdministrativePublishment;

import java.util.List;

public interface AdministrativePublishmentService {

    /**
     *获取行政处罚信息
     * */
    public List getAdministrativePublishment(String entId);
    /**
     * 添加行政处罚信息
     * */
    public void editAdministrativePublishment(List<AdministrativePublishment> apList);

}
