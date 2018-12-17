package jll.bad_information.service;

import jll.model.bad_information.EnvironmentPunishment;

import java.util.List;

public interface EnvironmentPunishmentService {

    /**
     *获取环保处罚信息
     * */
    public List getEnvironmentPunishment(String entId);
    /**
     * 添加环保处罚信息
     * */
    public void editEnvironmentPunishment(List<EnvironmentPunishment> epList);

}
