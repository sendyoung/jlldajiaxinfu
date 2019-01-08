package jll.organization_creditInformation.service.org;

import java.util.List;

/**
 * 组织领导
 */
public interface OrganizationalLeadershipService {

    /**
     * 添加
     */
    public void addOrganizationalLeadership();

    /**
     * 查询
     */
    public List queryOrganizationalLeadership(String auth_org_id);

}