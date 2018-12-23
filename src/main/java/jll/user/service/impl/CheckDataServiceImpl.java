package jll.user.service.impl;

import jll.model.CheckDataCode;
import jll.user.dao.CheckDataDao;
import jll.user.service.CheckDataService;
import jll.utils.MapTrunPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CheckDataServiceImpl implements CheckDataService {

    @Autowired
    private CheckDataDao checkDataDao;

    /**
     *插入一条校验码,返回他的id
     */
    @Override
    public String addCheckDataCode(String codeValue) {
        return checkDataDao.addCheckCode(codeValue);
    }

    /**
     * 根据id查到此校验码值
     */
    @Override
    public String findCodeById(String codeId) {
        List list = checkDataDao.findCodeById(codeId);
        CheckDataCode checkDataCode = (CheckDataCode)MapTrunPojo.map2Object((Map)list.get(0),CheckDataCode.class);
        return checkDataCode.getCode_value();
    }
}
