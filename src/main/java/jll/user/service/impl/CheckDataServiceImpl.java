package jll.user.service.impl;

import jll.model.CheckDataCode;
import jll.user.dao.CheckDataDao;
import jll.user.service.CheckDataService;
import jll.utils.MapTrunPojo;
import jll.utils.XinfuResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("checkDataService")
@Transactional
public class CheckDataServiceImpl implements CheckDataService {

    @Autowired
    private CheckDataDao checkDataDao;

    /**
     *插入一条校验码,返回他的id
     */
    @Override
    public String addCheckDataCode(String codeValue,String phonenum) {
        return checkDataDao.addCheckCode(codeValue,phonenum);
    }

    /**
     * 根据id查到此校验码值
     */
    @Override
    public int findCodeById(String codeId, String inputCode,String phonenum) {
        List list = checkDataDao.findCodeById(codeId,inputCode,phonenum);
        if(list!=null&&list.size()>0){
            return 200;
        }
        return 400;
    }
}
