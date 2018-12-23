package jll.user.service;

import jll.utils.XinfuResult;

public interface CheckDataService {

    /**
     * 插入一个校验码
     */
    public String addCheckDataCode(String codeValue);
    /**
     * 根据ID查到此校验码
     */
    public String findCodeById(String codeId);

}
