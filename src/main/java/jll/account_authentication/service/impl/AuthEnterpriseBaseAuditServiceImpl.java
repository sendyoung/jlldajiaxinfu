package jll.account_authentication.service.impl;

import com.cn.zyzs.hibernate.util.Page;
import com.cn.zyzs.utils.utils.PageContext;
import com.cn.zyzs.utils.utils.PageView;
import jll.account_authentication.dao.AuthEnterpriseBaseDao;
import jll.account_authentication.service.AuthEnterpriseBaseAuditService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service("authEnterpriseBaseAuditService")
@Transactional
public class AuthEnterpriseBaseAuditServiceImpl implements AuthEnterpriseBaseAuditService {

    @Autowired
    private AuthEnterpriseBaseDao authEnterpriseBaseDao;//企业认证

    @Override
    public Object findAuthEnterpriseBase(String name,String createTime,String code,Integer page,Integer rows) {
        try {
            Map param = new HashedMap();
            PageContext.setOffSet(page);
            PageContext.setPageSize(rows);
            Page pages=authEnterpriseBaseDao.queryAuthEnterpriseBase(name,createTime,code);
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
