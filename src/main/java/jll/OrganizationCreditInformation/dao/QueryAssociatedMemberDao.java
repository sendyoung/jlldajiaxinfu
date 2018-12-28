package jll.OrganizationCreditInformation.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
@Repository
public class QueryAssociatedMemberDao extends SimpleHibernateTemplate {


    /**
     * 查询已关联会员数量
     */
    public String queryAssociatedMember(String auth_org_id){
        StringBuffer sq = new StringBuffer();
        sq.append("select COUNT(*) from eva_apply_evaluate where 1=1 and auth_org_id='"+auth_org_id+"' and apply_status in ('2','4')");
        Query query = this.getSession().createSQLQuery(sq.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        System.out.println("打印查询出来的结果:"+query.list().get(0));
        return query.list().get(0).toString();
    }
}
