package jll.organization_creditInformation.dao.org;


import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.org_organization.Position;
import jll.model.org_organization.PositionDetail;
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
    public void addOrganizationalLeadership(Position position){
        this.getSession().merge(position);
    }

    /**
     * 组织领导详情数据添加
     */
    public void addOrganizationalLeadershipDetail(PositionDetail positionDetail){
        this.getSession().merge(positionDetail);
    }

    /**
     * 回显 组织领导
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
