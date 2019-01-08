package jll.reported_data.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import com.cn.zyzs.hibernate.util.Page;
import com.cn.zyzs.utils.utils.PageContext;
import jll.model.basic_pnformation_submit.CustomsCreditInformation;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CustomsCreditDao extends SimpleHibernateTemplate<CustomsCreditInformation> {

    /**
     * 增加海关信用信息
     */
    public void addCustomsCredit(CustomsCreditInformation customsCreditInformation){
        System.out.println("执行增主体增加信用记录!");
        this.getSession().merge(customsCreditInformation);
    }


    /**
     * 查询海关信用信息
     */
    public List queryCustomsCredit(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append("select * from ent_customs_credit where 1=1 and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }
    /**
     * 分页查询海关信用信息
     * */
    public Page queryCustomsCreditForPage(String entId){
        Map<String, Object> param = new HashMap<String, Object>();
        StringBuffer sql = new StringBuffer();
        LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
        sql.append("select * from ent_customs_credit where 1=1 and ent_id='"+entId+"'");
        return sqlqueryForpage1(sql.toString(), param, PageContext.getPageSize(), PageContext.getOffSet(), orderby);
    }
}
