package jll.reported_data.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.basic_pnformation_submit.ServiceByPublication;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class PublicNoticeDao extends SimpleHibernateTemplate<ServiceByPublication> {
    /**
     * 增加公示催告
     */
    public void addPublicNotice(ServiceByPublication serviceByPublication){
        System.out.println("执行公示催告");
        this.getSession().merge(serviceByPublication);
    }

    /**
     * 查询公示催告
     */
    public List queryPublicNotice(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append("select * from ent_service_by_publication where 1=1 and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }
}
