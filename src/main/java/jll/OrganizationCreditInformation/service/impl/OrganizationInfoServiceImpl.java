package jll.OrganizationCreditInformation.service.impl;

import jll.OrganizationCreditInformation.dao.OrganizationInfoDao;
import jll.OrganizationCreditInformation.service.OrganizationInfoService;
import jll.model.OrgOrganization.Organization;
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
     * 添加
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
     * 查询
     * @param auth_org_id
     * @return
     */
    @Override
    public List queryOrganizationInfo(String auth_org_id) {
        List result=organizationInfoDao.queryOrganizationInfo(auth_org_id);
        return result;
    }
}
