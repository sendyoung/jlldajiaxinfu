package jll.organization_creditInformation.service.org;


import jll.model.org_organization.Structure;

import java.util.List;

/**
 * 组织机构
 */
public interface OrganizationMechanismService {

    /**
     * 添加组织机构信息接口
     */
    public void addOrganization(Structure structure);


    /**
     * 查询组织机构信息接口
     */
    public List queryOrganization(String org_id);
}