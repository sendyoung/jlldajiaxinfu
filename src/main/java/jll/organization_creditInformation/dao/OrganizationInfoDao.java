package jll.organization_creditInformation.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.org_organization.Organization;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 添加组织信息
 */
@Repository
public class OrganizationInfoDao extends SimpleHibernateTemplate<Organization> {

    /**
     * 添加信息
     */
    public void addOrganizationInfo(Organization organization){
//        this.getSession().merge(organization);
//        this.getSession().save(organization);
        this.getSession().merge(organization);
    }

    /**
     * 查询信息
     */
    public List queryOrganizationInfo(String auth_org_id){

        StringBuffer sq = new StringBuffer();
        sq.append("select * from org_organization where 1=1 and auth_org_id='"+auth_org_id+"'");
        Query query = this.getSession().createSQLQuery(sq.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
//        System.out.println("打印查询出来的结果:"+query.list());

        return query.list();
    }
}
