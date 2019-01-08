package jll.reported_data.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import com.cn.zyzs.hibernate.util.Page;
import com.cn.zyzs.utils.utils.PageContext;
import jll.model.basic_pnformation_submit.ProductionStatus;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TheProductionStatusDao extends SimpleHibernateTemplate<ProductionStatus> {
    /**
     * 添加生产情况
     */
    public void addTheProductionStatus(ProductionStatus productionStatus){
        System.out.println("执行生产情况dao层!");
        this.getSession().merge(productionStatus);
    }

    /**
     * 查询生产情况
     */
    public List queryTheProductionStatus(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append("select * from ent_production_status where 1=1 and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }
    /**
     * 分页查询生产情况
     * */
    public Page queryTheProductionStatusForPage(String entId){
        Map<String, Object> param = new HashMap<String, Object>();
        StringBuffer sql = new StringBuffer();
        LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
        sql.append("select * from ent_production_status where 1=1 and ent_id='"+entId+"'");
        return sqlqueryForpage1(sql.toString(), param, PageContext.getPageSize(), PageContext.getOffSet(), orderby);
    }


}
