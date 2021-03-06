package jll.good_information.service.impl;

import jll.good_information.dao.OthersCertificateDao;
import jll.good_information.service.OthersCertificateService;
import jll.model.good_information.OthersCertificate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("othersCertificateService")
@Transactional
public class OthersCertificateServiceImpl implements OthersCertificateService {

    @Autowired
    private OthersCertificateDao othersCertificateDao;

    @Override
    public List getOthersCertificate(String entId) {
        List result=othersCertificateDao.queryOthersCertificate(entId);
        if(null!=result && result.size()>0){
            return result;
        }
        return null;
    }

    @Override
    public void editOthersCertificate(List<OthersCertificate> ocList) {
        for(OthersCertificate oc:ocList){
            othersCertificateDao.saveOthersCertificate(oc);
        }
    }
}
