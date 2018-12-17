package jll.bad_information.service;

import jll.model.bad_information.Executor;

import java.util.List;

public interface ExecutorService {

    /**
     *获取被执行人信息
     * */
    public List getExecutor(String entId);
    /**
     * 添加被执行人信息
     * */
    public void editExecutor(List<Executor> eList);

}
