package jll.good_information.service;

import jll.model.good_information.PublicWelfareActivity;

import java.util.List;

public interface PublicWelfareActivityService {

    /**
     *获取公益信息
     * */
    public List getPublicWelfareActivity(String entId);
    /**
     * 添加公益信息
     * */
    public void editPublicWelfareActivity(List<PublicWelfareActivity> pwaList);

}
