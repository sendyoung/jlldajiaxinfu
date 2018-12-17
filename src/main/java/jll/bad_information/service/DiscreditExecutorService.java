package jll.bad_information.service;

import jll.model.bad_information.DiscreditExecutor;

import java.util.List;

public interface DiscreditExecutorService {

    /**
     *获取失信被执行人信息
     * */
    public List getDiscreditExecutor(String entId);
    /**
     * 添加失信被执行人信息
     * */
    public void editDiscreditExecutor(List<DiscreditExecutor> deList);

}
