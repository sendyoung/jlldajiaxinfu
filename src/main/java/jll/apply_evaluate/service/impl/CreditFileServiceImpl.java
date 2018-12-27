package jll.apply_evaluate.service.impl;

import jll.apply_evaluate.dao.CreditFileDao;
import jll.apply_evaluate.service.CreditFileService;
import jll.model.apply_evaluate.CreditFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("creditFileService")
@Transactional
public class CreditFileServiceImpl implements CreditFileService {

    @Autowired
    private CreditFileDao creditFileDao;//信用档案


    @Override
    public void editCreditFile(CreditFile creditFile) {
        creditFileDao.saveCreditFile(creditFile);
    }

    @Override
    public Object findCreditFileByAuthEnterpriseId(String authEnterpriseId) {
        return creditFileDao.queryCreditFileByAuthEnterpriseId(authEnterpriseId);
    }
}
