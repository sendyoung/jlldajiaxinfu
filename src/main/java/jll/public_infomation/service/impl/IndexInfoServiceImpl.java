package jll.public_infomation.service.impl;


import jll.public_infomation.dao.IndexInfoDao;
import jll.public_infomation.service.IndexInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 首页展示的4块信息
 */
@Service()
@Transactional
public class IndexInfoServiceImpl implements IndexInfoService {

    @Autowired
    private IndexInfoDao indexInfoDao;  // 查询首页需要显示的信息dao

    /**
     * 查询数据库
     * @return
     */
    @Override
    public List queryIndexData() {
        return indexInfoDao.queryIndexData();
    }
}
