package jll.account_authentication.service;

import jll.model.authentication.AuthEnterpriseBase;
import jll.model.authentication.AuthOrgBase;
import jll.model.enterprise.EntBasics;
import jll.utils.XinfuResult;

public interface AccountAuthenticationService {
    //回显企业认证数据
    public AuthEnterpriseBase findAuthEnterpriseBase(String authenticationId);
    //新增或更新企业认证数据
    public XinfuResult saveOrUpdateAuthEnterpriseBase(AuthEnterpriseBase authEnterpriseBase,String userId);
    //回显组织认证数据
    public AuthOrgBase findAuthOrgBase(String authenticationId);
    //新增或更新组织认证数据
    public XinfuResult saveOrUpdateAuthOrgBase(AuthOrgBase authOrgBase,String userId);
    //根据社会信用统一代码查寻是否有对应的企业数据
    public EntBasics findEntBasics(String unified_social_credit_code);
}
