package jll.organization_creditInformation.service.impl.org;

import jll.model.org_organization.Department;
import jll.model.org_organization.Structure;
import jll.organization_creditInformation.dao.org.OrganizationDao;
import jll.organization_creditInformation.service.org.OrganizationMechanismService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrganizationMechanismServiceImpl implements OrganizationMechanismService {

    @Autowired
    private OrganizationDao organizationDao;   // 组织机构  dao

    /**
     * 添加组织机构
     * @param structure
     */
    @Override
    public void addOrganization(Structure structure) {
        organizationDao.addOrganization(structure);
    }

    /**
     * 查询组织机构
     * @param auth_org_id
     * @return
     */
    @Override
    public List queryOrganization(String auth_org_id) {

        List result = organizationDao.queryOrganization(auth_org_id);
        if(null!=result && result.size()>0){
            return result;
        }
        return null;
    }

    /**
     * 组织部门添加
     * @param department
     */
    @Override
    public void addOrganizationDepartment(Department department) {
        organizationDao.addOrganizationDepartment(department);
    }

    /**
     * 组织部门 回显
     * @param org_structure_id
     * @return
     */
    @Override
    public List queryOrganizationDepartment(String org_structure_id) {
        List result = organizationDao.queryOrganizationDepartment(org_structure_id);

        if(null!=result && result.size()>0){
            return result;
        }
        return null;
    }
}
