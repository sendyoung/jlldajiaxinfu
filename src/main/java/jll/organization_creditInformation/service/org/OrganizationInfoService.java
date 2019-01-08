package jll.organization_creditInformation.service.org;


import jll.model.org_organization.Organization;

import java.util.List;


/**
 * 组织信息
 */
public interface OrganizationInfoService {

    /**
     * 添加组织信息
     */
    public void addOrganizationInfo(Organization organization);

    /**
     * 回显组织信息
     */
    public List queryOrganizationInfo(String auth_org_id);



}
