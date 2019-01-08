package jll.reported_data.service.impl;

import jll.model.BasicPnformationSubmit.AdministrativeLicensing;
import jll.reported_data.dao.AdministrativeLicenseDao;
import jll.reported_data.service.AdministrativeLicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service()
@Transactional
public class AdministrativeLicenseServiceImpl implements AdministrativeLicenseService {
    //调用dao层
    @Autowired
    private AdministrativeLicenseDao administrativeLicenseDao;  //行政许可


    /**
     * 添加信息
     * @param
     */
    @Override
    public void addAdministrativeLicense(List<AdministrativeLicensing> administrativeLicensing) {
        for(AdministrativeLicensing al:administrativeLicensing){
            administrativeLicenseDao.addAdministrativeLicense(al);
        }
    }

    /**
     * 查询信息
     * @param
     * @return
     */
    @Override
    public List queryAdministrativeLicense(String entId) {
        List result=administrativeLicenseDao.queryAdministrativeLicense(entId);
        if(null!=result && result.size()>0){
            return result;
        }
        return null;
    }
}
