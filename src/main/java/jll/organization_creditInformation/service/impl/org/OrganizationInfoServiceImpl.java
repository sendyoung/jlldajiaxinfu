package jll.organization_creditInformation.service.impl.org;

import jll.organization_creditInformation.dao.org.OrganizationInfoDao;
import jll.organization_creditInformation.service.org.OrganizationInfoService;
import jll.model.org_organization.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrganizationInfoServiceImpl implements OrganizationInfoService {

    //调用dao层
    @Autowired
    private OrganizationInfoDao organizationInfoDao;

    /**
     * 添加 组织信息
     * @param organization
     */
    @Override
    public void addOrganizationInfo(Organization organization) {
//            for(Organization ot : organization){
//                organizationInfoDao.addOrganizationInfo(ot);
//            }
             organizationInfoDao.addOrganizationInfo(organization);

        }

    /**
     * 查询  组织信息
     * @param auth_org_id
     * @return
     */
    @Override
    public List queryOrganizationInfo(String auth_org_id) {
        List result=organizationInfoDao.queryOrganizationInfo(auth_org_id);
        return result;
    }
}
