package jll.account_authentication.service.impl;

import com.cn.zyzs.hibernate.util.Page;
import com.cn.zyzs.utils.utils.PageContext;
import com.cn.zyzs.utils.utils.PageView;
import jll.account_authentication.dao.AuthEnterpriseBaseDao;
import jll.account_authentication.dao.EntBasicsDao;
import jll.account_authentication.service.AuthEnterpriseBaseAuditService;
import jll.model.authentication.AuthEnterpriseBase;
import jll.model.enterprise.EntBasics;
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

    @Autowired
    private EntBasicsDao entBasicsDao;//工商信息

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

    @Override
    public void editAuthEnterpriseBaseToNotGo(String userId, String type) {
        //改变审核状态
        authEnterpriseBaseDao.updateUserForAuthenticationType(userId,type);
    }

    @Override
    public void editAuthEnterpriseBaseToPass(String userId) {
        //查询认证信息
        AuthEnterpriseBase aeb=authEnterpriseBaseDao.queryAuthEnterpriseBaseByUserId(userId);
       //根据认证社会统一代码查询工商信息
        EntBasics entBasics=new EntBasics();
        entBasics=authEnterpriseBaseDao.queryEntBasicsByCode(aeb.getSocial_credit_code());
        entBasics.setCompany_introduce(aeb.getEnterprise_introduction());
        entBasics.setBusiness_scope(aeb.getBusiness_scope());
        entBasics.setCompany_registration_address(aeb.getResidence());
        entBasics.setRegistration_authority(aeb.getRegistration_authority());
        entBasics.setDate_of_establishment(aeb.getDate_establishment());
        entBasics.setCompany_type(aeb.getTypes_enterprises()+"");
        entBasics.setRegistered_capital(aeb.getRegistered_capital());
        entBasics.setUnified_social_credit_code(aeb.getSocial_credit_code());
        entBasics.setCompany_name(aeb.getEnterprise_name());
        //操作工商信息
        entBasicsDao.updateEntBasics(entBasics);
    }
}
