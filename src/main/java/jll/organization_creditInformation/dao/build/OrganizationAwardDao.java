package jll.organization_creditInformation.dao.build;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.org_organization.OrganizationAward;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 组织奖项dao
 */
@Repository
public class OrganizationAwardDao extends SimpleHibernateTemplate<Object> {


    /**
     * 添加组织奖项
     */
    public void addOrganizationAward(OrganizationAward organizationAward){

        this.getSession().merge(organizationAward);

    }


    /**
     * 查询组织奖项
     */
    public List queryOrganizationAward(String auth_org_id){
        StringBuffer sq = new StringBuffer();
        sq.append("select * from org_organization_award where 1=1 and auth_org_id='"+auth_org_id+"'");
        Query query = this.getSession().createSQLQuery(sq.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        System.out.println("打印组织奖项的结果:"+query.list());

        return query.list();

    }



}
