package jll.bad_information.service;

import jll.model.bad_information.AdministrativeSanction;

import java.util.List;

public interface AdministrativeSanctionService {

    /**
     *获取海关行政处罚信息
     * */
    public List getAdministrativeSanction(String entId);
    /**
     * 添加海关行政处罚信息
     * */
    public void editAdministrativeSanction(List<AdministrativeSanction> asList);

}
