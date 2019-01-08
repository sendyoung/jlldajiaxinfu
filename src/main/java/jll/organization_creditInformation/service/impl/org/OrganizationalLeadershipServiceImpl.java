package jll.organization_creditInformation.service.impl.org;


import jll.model.org_organization.Position;
import jll.model.org_organization.PositionDetail;
import jll.organization_creditInformation.dao.org.OrganizationalLeadershipDao;
import jll.organization_creditInformation.service.org.OrganizationalLeadershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrganizationalLeadershipServiceImpl implements OrganizationalLeadershipService {

    @Autowired
    private OrganizationalLeadershipDao organizationalLeadershipDao;   //组织领导

    /**
     * 添加组织领导
     */
    @Override
    public void addOrganizationalLeadership(Position position) {
        organizationalLeadershipDao.addOrganizationalLeadership(position);
    }

    /**
     * 添加组织领导详情信息
     * @param positionDetail
     */
    @Override
    public void addaddOrganizationalLeadershipDetail(PositionDetail positionDetail) {
        organizationalLeadershipDao.addOrganizationalLeadershipDetail(positionDetail);
    }

    /**
     * 查询组织领导
     * @return
     */
    @Override
    public List queryOrganizationalLeadership(String auth_org_id) {

        List result=organizationalLeadershipDao.queryOrganizationalLeadership(auth_org_id);
        if(null!=result && result.size()>0){
            return result;
        }
        return null;
    }


    /**
     * 组织领导职位详情
     * @param post_id
     * @return
     */
    @Override
    public String queryOrganizationalLeadershipDetail(String post_id) {

        String result = organizationalLeadershipDao.queryOrganizationalLeadershipDetail(post_id);

        return result;
    }


}
