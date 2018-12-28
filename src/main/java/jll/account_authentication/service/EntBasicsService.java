package jll.account_authentication.service;

import jll.model.enterprise.EntBasics;

public interface EntBasicsService {
    /**
     * 根据企业认证ID查询工商信息
     * */
    public EntBasics findEntBasics(String authEnterpriseId);
    /**
     * 修改工商信息
     * */
    public void editEntBasics(EntBasics entBasics);
}
