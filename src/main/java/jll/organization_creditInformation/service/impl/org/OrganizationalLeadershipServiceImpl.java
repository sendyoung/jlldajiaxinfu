package jll.organization_creditInformation.service.impl.org;


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
    public void addOrganizationalLeadership() {

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
}