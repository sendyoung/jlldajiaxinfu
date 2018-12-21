package jll.apply_evaluate.service.impl;

import com.cn.zyzs.hibernate.util.Page;
import com.cn.zyzs.utils.utils.PageContext;
import com.cn.zyzs.utils.utils.PageView;
import jll.apply_evaluate.dao.EnterprisesPunishmentDao;
import jll.apply_evaluate.service.EnterprisesPunishmentService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service("enterprisesPunishmentService")
@Transactional
public class EnterprisesPunishmentServiceImpl implements EnterprisesPunishmentService {

    @Autowired
    private EnterprisesPunishmentDao enterprisesPunishmentDao;//组织下的企业黑名单信息


    @Override
    public Object findEnterprisesPunishmentByAuthOrgId(String authOrgId,Integer page,Integer rows) {
        try {
            Map param = new HashedMap();
            PageContext.setOffSet(page);
            PageContext.setPageSize(rows);
            Page pages=enterprisesPunishmentDao.queryEnterprisesPunishmentByAuthOrgId(authOrgId);
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
