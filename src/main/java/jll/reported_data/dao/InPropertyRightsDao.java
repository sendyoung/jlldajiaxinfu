package jll.reported_data.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import com.cn.zyzs.hibernate.util.Page;
import com.cn.zyzs.utils.utils.PageContext;
import jll.model.basic_pnformation_submit.IntellectualProperty;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public class InPropertyRightsDao extends SimpleHibernateTemplate<IntellectualProperty> {
    /**
     * 增加知识产权出质信息
     */
    public void addInPropertyRights(IntellectualProperty intellectualProperty){
        System.out.println("执行知识产权出质信息");
        this.getSession().merge(intellectualProperty);
    }



    /**
     * 查询知识产权出质信息
     */
    public List queryInPropertyRights(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append("select * from ent_intellectual_property where 1=1 and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }
    /**
     * 分页查询知识产权出质信息
     * */
    public Page queryInPropertyRightsForPage(String entId){
        Map<String, Object> param = new HashMap<String, Object>();
        StringBuffer sql = new StringBuffer();
        LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
        sql.append("select * from ent_intellectual_property where 1=1 and ent_id='"+entId+"'");
        return sqlqueryForpage1(sql.toString(), param, PageContext.getPageSize(), PageContext.getOffSet(), orderby);
    }
}
