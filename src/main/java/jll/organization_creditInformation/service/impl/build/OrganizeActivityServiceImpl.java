package jll.organization_creditInformation.service.impl.build;


import jll.model.org_organization.OrganizeActivity;
import jll.organization_creditInformation.dao.build.OrganizeActivityDao;
import jll.organization_creditInformation.service.build.OrganizeActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 组织活动
 */
@Service
@Transactional
public class OrganizeActivityServiceImpl implements OrganizeActivityService {

    @Autowired
    private OrganizeActivityDao organizeActivityDao;   //组织活动

    /**
     * 添加 组织活动
     * @param organizeActivity
     */
    @Override
    public void addOrganizeActivity(List<OrganizeActivity> organizeActivity) {
        for(OrganizeActivity oa:organizeActivity){
            organizeActivityDao.addOrganizeActivity(oa);
        }
    }

    /**
     * 回显 组织活动
     * @param auth_org_id
     */
    @Override
    public List queryOrganizeActivity(String auth_org_id) {
        List result = organizeActivityDao.queryOrganizeActivity(auth_org_id);
        if(null!=result && result.size()>0){
            return result;
        }
        return null;
    }
}
