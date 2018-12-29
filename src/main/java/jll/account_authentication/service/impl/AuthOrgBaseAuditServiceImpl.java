package jll.account_authentication.service.impl;

import com.cn.zyzs.utils.utils.PageView;
import jll.account_authentication.dao.AuthOrgBaseDao;
import jll.account_authentication.service.AuthOrgBaseAuditService;
import jll.utils.HibernatePageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//组织认证
@Service("authOrgBaseAuditService")
@Transactional
public class AuthOrgBaseAuditServiceImpl implements AuthOrgBaseAuditService {

    @Autowired
    private AuthOrgBaseDao authOrgBaseDao;

    //查看待审核的的组织认证列表
    @Override
    public PageView findAuthOrgBaseAuditList(String orgName, String authTime, String creditCode, int currentPage, int rows) {
        return HibernatePageUtil.sqlPageUtil(authOrgBaseDao.findAuthOrgBaseAuditList(orgName,authTime,creditCode),currentPage,rows);
    }
}
