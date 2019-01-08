package jll.reported_data.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import com.cn.zyzs.hibernate.util.Page;
import com.cn.zyzs.utils.utils.PageContext;
import jll.model.basic_pnformation_submit.ServiceByPublication;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
    /**
     * 分页查询公示催告
     * */
    public Page queryPublicNoticeForPage(String entId){
        Map<String, Object> param = new HashMap<String, Object>();
        StringBuffer sql = new StringBuffer();
        LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
        sql.append("select * from ent_service_by_publication where 1=1 and ent_id='"+entId+"'");
        return sqlqueryForpage1(sql.toString(), param, PageContext.getPageSize(), PageContext.getOffSet(), orderby);
    }
}
