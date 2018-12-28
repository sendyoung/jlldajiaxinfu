package jll.OrganizationCreditInformation.service.impl;

import jll.OrganizationCreditInformation.dao.QueryAssociatedMemberDao;
import jll.OrganizationCreditInformation.service.QueryAssociatedServiceMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class QueryAssociatedServiceMemberImpl implements QueryAssociatedServiceMember {
    /**
     * 查询已关联会员数量
     * @param org_id
     * @return
     */
    @Autowired
    private QueryAssociatedMemberDao queryAssociatedMemberDao;   // 查询已关联会员数量

    @Override
    public String queryAssociatedMember(String org_id) {
        String Count = queryAssociatedMemberDao.queryAssociatedMember(org_id);
        return Count.toString();
    }
}
