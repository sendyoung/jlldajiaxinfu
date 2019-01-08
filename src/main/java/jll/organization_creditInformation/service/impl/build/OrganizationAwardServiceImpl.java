package jll.organization_creditInformation.service.impl.build;

import jll.model.org_organization.OrganizationAward;
import jll.organization_creditInformation.dao.build.OrganizationAwardDao;
import jll.organization_creditInformation.service.build.OrganizationAwardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 组织奖项
 */
@Repository
@Transactional
public class OrganizationAwardServiceImpl implements OrganizationAwardService {

    @Autowired
    private OrganizationAwardDao organizationAwardDao;  //组织奖项 dao

    /**
     * 添加
     * @param organizationAward
     */
    @Override
    public void addOrganizationAward(List<OrganizationAward> organizationAward) {
        for (OrganizationAward oa:organizationAward){
            organizationAwardDao.addOrganizationAward(oa);
        }
    }


    /**
     * 查询
     * @param auth_org_id
     */
    @Override
    public List queryOrganizationAward(String auth_org_id) {
        List result = organizationAwardDao.queryOrganizationAward(auth_org_id);
        if(null!=result && result.size()>0){
            return result;
        }
        return null;
    }
}
