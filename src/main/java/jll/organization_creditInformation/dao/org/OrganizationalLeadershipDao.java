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
     * 回向 组织领导
     */
    public List queryOrganizationalLeadership(String auth_org_id){
        StringBuffer sq = new StringBuffer();
        sq.append("select * from org_position where 1=1 and auth_org_id='"+auth_org_id+"'");
        Query query = this.getSession().createSQLQuery(sq.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        System.out.println("打印组织领导查询出来的结果:"+query.list());

        return query.list();
    }

    /**
     * 回显组织领导职位 详情
     */
    public String queryOrganizationalLeadershipDetail(String post_id){
        StringBuffer sq = new StringBuffer();
        sq.append("select * from org_position_detail where 1=1 and post_id='"+post_id+"'");
        Query query = this.getSession().createSQLQuery(sq.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        System.out.println("打印回显组织领导职位 详情查询出来的结果:"+query.list());

        return query.list().toString();
    }

}
