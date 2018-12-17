package jll.bad_information.service;

import jll.model.bad_information.UnusualBusinessList;

import java.util.List;

public interface UnusualBusinessListService {

    /**
     *获取经营异常信息
     * */
    public List getUnusualBusinessList(String entId);
    /**
     * 添加经营异常信息
     * */
    public void editUnusualBusinessList(List<UnusualBusinessList> ublList);

}
