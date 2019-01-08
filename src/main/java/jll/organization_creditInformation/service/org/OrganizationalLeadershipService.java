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
     * 回显组织领导职位
     */
    public List queryOrganizationalLeadership(String auth_org_id);

    /**
     * 回显组织领导职位详情
     */
    public String queryOrganizationalLeadershipDetail(String post_id);

}
