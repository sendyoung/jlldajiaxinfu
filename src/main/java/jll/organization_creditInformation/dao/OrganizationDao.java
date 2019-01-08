package jll.organization_creditInformation.dao;


import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.org_organization.Structure;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrganizationDao extends SimpleHibernateTemplate<Object> {


    /**
     * 添加组织机构信息
     */
    public void addOrganization(Structure structure){

         this.getSession().merge(structure);

    }


    /**
     * 查询组织机构信息
     */
    public List queryOrganization(String auth_org_id){
        StringBuffer sq = new StringBuffer();
        sq.append("select * from org_structure where 1=1 and auth_org_id='"+auth_org_id+"'");
        Query query = this.getSession().createSQLQuery(sq.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        System.out.println("打印查询出来的结果:"+query.list());

        return query.list();

    }
}
