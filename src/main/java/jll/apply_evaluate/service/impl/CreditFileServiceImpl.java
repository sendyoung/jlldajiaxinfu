package jll.apply_evaluate.service.impl;

import com.cn.zyzs.hibernate.util.Page;
import com.cn.zyzs.utils.utils.PageContext;
import com.cn.zyzs.utils.utils.PageView;
import jll.apply_evaluate.dao.CreditFileDao;
import jll.apply_evaluate.service.CreditFileService;
import jll.model.apply_evaluate.CreditFile;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

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

    @Override
    public Object findHistoryCreditFile(String authEnterpriseId,String name,String date, Integer page, Integer rows) {
        try {
            Map param = new HashedMap();
            PageContext.setOffSet(page);
            PageContext.setPageSize(rows);
            Page pages=creditFileDao.queryHistoryCreditFile(authEnterpriseId,name,date);
            PageView pageView = new PageView(PageContext.getPageSize(), PageContext.getOffSet());
            pageView.setTotalpage(pages.getTotal());
            pageView.setRecords(pages.getItems());
            return pageView;
        } catch (Exception e) {
            e.printStackTrace();
            return "500";
        }
    }
}
