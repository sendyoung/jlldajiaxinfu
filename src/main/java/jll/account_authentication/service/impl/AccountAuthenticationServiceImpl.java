package jll.account_authentication.service.impl;

import jll.account_authentication.dao.AuthEnterpriseBaseDao;
import jll.account_authentication.dao.AuthOrgBaseDao;
import jll.account_authentication.dao.EntBasicsDao;
import jll.account_authentication.service.AccountAuthenticationService;
import jll.model.User;
import jll.model.authentication.AuthEnterpriseBase;
import jll.model.authentication.AuthOrgBase;
import jll.model.enterprise.EntBasics;
import jll.user.dao.UserDao;
import jll.utils.MapTrunPojo;
import jll.utils.XinfuResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("accountAuthenticatoinService")
@Transactional
public class AccountAuthenticationServiceImpl implements AccountAuthenticationService {

    @Autowired
    private AuthEnterpriseBaseDao authEnterpriseBaseDao;
    @Autowired
    private AuthOrgBaseDao authOrgBaseDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private EntBasicsDao entBasicsDao;

    //回显企业认证数据
    @Override
    public AuthEnterpriseBase findAuthEnterpriseBase(String authenticationId) {
        List list = authEnterpriseBaseDao.findAuthEnterpriseBase(authenticationId);
        if (list != null && list.size() > 0) {
            Map map = (Map) list.get(0);
            AuthEnterpriseBase authEnterpriseBase = (AuthEnterpriseBase) MapTrunPojo.map2Object(map, AuthEnterpriseBase.class);
            return authEnterpriseBase;
        }
        return null;
    }

    //新增或更新企业认证数据
    @Override
    public XinfuResult saveOrUpdateAuthEnterpriseBase(AuthEnterpriseBase authEnterpriseBase,String userId) {
        try {
            authEnterpriseBaseDao.saveOrUpdateAuthEnterpriseBase(authEnterpriseBase);
            //将新增后得到的主键存入用户表中
            User user = new User();
            //将当前用户的id存入实体类,根据id将对应的用户详情信息主键存入用户表中
            user.setUser_id(userId);
            user.setAuthentication_id(authEnterpriseBase.getAuth_enterprise_id());
            user.setAuthentication_type("1");
            userDao.updateUserAccount(user);
            return XinfuResult.build(200,"新增或更新认证信息成功");
        } catch (Exception e) {
            e.printStackTrace();
            return XinfuResult.build(400,"新增或更新认证信息失败");
        }
    }

    //回显组织认证数据
    @Override
    public AuthOrgBase findAuthOrgBase(String authenticationId) {
        List list = authOrgBaseDao.findAuthOrgBase(authenticationId);
        if (list != null && list.size() > 0) {
            Map map = (Map) list.get(0);
            AuthOrgBase authOrgBase = (AuthOrgBase) MapTrunPojo.map2Object(map, AuthOrgBase.class);
            return authOrgBase;
        }
        return null;
    }

    //新增或更新组织认证信息
    @Override
    public XinfuResult saveOrUpdateAuthOrgBase(AuthOrgBase authOrgBase,String userId) {
        try {
            authOrgBaseDao.saveOrUpdateAuthOrgBase(authOrgBase);
            //将新增后得到的主键存入用户表中
            User user = new User();
            //将当前用户的id存入实体类,根据id将对应的用户详情信息主键存入用户表中
            user.setUser_id(userId);
            user.setAuthentication_id(authOrgBase.getAuth_org_id());
            user.setAuthentication_type("3");
            userDao.updateUserAccount(user);
            return XinfuResult.build(200,"新增或更新认证信息成功");
        } catch (Exception e) {
            e.printStackTrace();
            return XinfuResult.build(400,"新增或更新认证信息失败");
        }
    }

    /**
     * 根据社会信用统一代码查询有没有对应的企业数据
     * @param unified_social_credit_code
     * @return
     */
    @Override
    public XinfuResult findEntBasics(String unified_social_credit_code) {
        List list = entBasicsDao.findEntBasics(unified_social_credit_code);
        if (list != null && list.size() > 0) {
            Map map = (Map) list.get(0);
            EntBasics entBasics = (EntBasics) MapTrunPojo.map2Object(map, EntBasics.class);
            return XinfuResult.build(200,"在后台中查到了相关企业数据",entBasics);
        }
        return XinfuResult.build(400,"在后台中没有查到相关企业数据",null);
    }
}
