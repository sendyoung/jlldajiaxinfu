package jll.message.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrgEntMemberDao  extends SimpleHibernateTemplate<Object> {

    //查询组织下所有成员的企业名称和企业ID
    public List findOrgEntMember(String auth_org_id){
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT aeb.auth_enterprise_id value,aeb.enterprise_name text FROM eva_apply_evaluate eae,auth_enterprise_base aeb WHERE eae.auth_enterprise_id = aeb.auth_enterprise_id AND eae.auth_org_id = '" + auth_org_id + "'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }
}
