package jll.organization_creditInformation.service.build;

import jll.model.org_organization.OrganizeActivity;

import java.util.List;

/**
 * 组织活动
 */
public interface OrganizeActivityService {
    /**
     * 添加组织活动
     */
    public void addOrganizeActivity(List<OrganizeActivity> organizeActivity);


    /**
     * 查询组织活动
     */
    public List queryOrganizeActivity(String auth_org_id);
}
