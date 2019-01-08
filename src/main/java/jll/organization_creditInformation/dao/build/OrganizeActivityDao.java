package jll.organization_creditInformation.dao.build;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.org_organization.OrganizeActivity;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 组织活动
 */
@Repository
public class OrganizeActivityDao extends SimpleHibernateTemplate<Object> {


    /**
     * 添加组织活动
     */
    public void addOrganizeActivity(OrganizeActivity organizeActivity){
            this.getSession().merge(organizeActivity);

    }


    /**
     * 查询组织活动
     */
    public List queryOrganizeActivity(String auth_org_id){
        StringBuffer sq = new StringBuffer();
        sq.append("select * from org_organize_activity where 1=1 and auth_org_id='"+auth_org_id+"'");
        Query query = this.getSession().createSQLQuery(sq.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        System.out.println("打印组织活动的结果:"+query.list());

        return query.list();

    }









}
