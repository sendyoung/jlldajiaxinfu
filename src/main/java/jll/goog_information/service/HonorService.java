package jll.goog_information.service;

import jll.model.Honor;

import java.util.List;

public interface HonorService {

    /**
     *获取表彰信息
     * */
    public List getHonor(String entId);
    /**
     * 添加表彰信息
     * */
    public void editHonor(List<Honor> honorList);

}
