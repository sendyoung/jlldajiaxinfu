package jll.organization_creditInformation.dao.org;


import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 组织领导
 */
@Repository
public class OrganizationalLeadershipDao extends SimpleHibernateTemplate<Object> {


    /**
     * 组织领导 添加
     */


    /**
     * 组织领导 查询
     */
    public List queryOrganizationalLeadership(String auth_org_id){
        StringBuffer sq = new StringBuffer();
        sq.append("select * from org_position where 1=1 and auth_org_id='"+auth_org_id+"'");
        Query query = this.getSession().createSQLQuery(sq.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        System.out.println("打印组织领导查询出来的结果:"+query.list());

        return query.list();
    }


}
