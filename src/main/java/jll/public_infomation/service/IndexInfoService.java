package jll.public_infomation.service;

import java.util.List;

/**
 * 首页信息接口
 */
public interface IndexInfoService {

    /**
     * 查询首页需要展示的4块信息
     * @return
     */
    public List queryIndexData();
}
