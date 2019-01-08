package jll.organization_creditInformation.service.build;

import jll.model.org_organization.OrganizationAward;

import java.util.List;

/**
 * 组织奖项
 */
public interface OrganizationAwardService {
    /**
     * 添加
     */
    public void addOrganizationAward(List<OrganizationAward> organizationAward);

    /**
     * 回显
     */
    public List queryOrganizationAward(String auth_org_id);

}
