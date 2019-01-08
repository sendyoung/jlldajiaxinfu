package jll.reported_data.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import com.cn.zyzs.hibernate.util.Page;
import com.cn.zyzs.utils.utils.PageContext;
import jll.model.basic_pnformation_submit.WebsiteRecords;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public class WebsiteFilingDao extends SimpleHibernateTemplate<WebsiteRecords> {
    /**
     * 添加网站备案 填报
     */
    public void addWebsiteFiling(WebsiteRecords websiteRecords){
        System.out.println("执行网站备案dao层!");
        this.getSession().merge(websiteRecords);
    }

    /**
     * 查询网站备案 填报
     */
    public List queryWebsiteFiling(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append("select * from ent_website_records where 1=1 and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }
    /**
     * 分页查询网站备案
     * */
    public Page queryWebsiteFilingForPage(String entId){
        Map<String, Object> param = new HashMap<String, Object>();
        StringBuffer sql = new StringBuffer();
        LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
        sql.append("select * from ent_website_records where 1=1 and ent_id='"+entId+"'");
        return sqlqueryForpage1(sql.toString(), param, PageContext.getPageSize(), PageContext.getOffSet(), orderby);
    }
}
