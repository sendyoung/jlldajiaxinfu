package jll.organization_creditInformation.service.org;

import jll.model.org_organization.Position;
import jll.model.org_organization.PositionDetail;

import java.util.List;

/**
 * 组织领导
 */
public interface OrganizationalLeadershipService {

    /**
     * 添加 组织领导信息
     */
    public void addOrganizationalLeadership(Position position);

    /**
     * 添加 组织领导详情信息
     *
     */
    public void addaddOrganizationalLeadershipDetail(PositionDetail positionDetail);

    /**
     * 回显 组织领导职位
     */
    public List queryOrganizationalLeadership(String auth_org_id);

    /**
     * 回显 组织领导职位详情
     */
    public String queryOrganizationalLeadershipDetail(String post_id);





}
