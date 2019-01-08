package jll.reported_data.service;

import jll.model.BasicPnformationSubmit.SocialSecurity;

import java.util.List;

public interface SocialSecurityService {
    /**
     * 添加社保方面
     */
    public void addSocialSecurity(List<SocialSecurity> socialSecurity);

    /**
     * 查询社保方面
     */
    public List querySocialSecurity(String entId);
}
