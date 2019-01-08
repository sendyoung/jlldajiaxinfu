package jll.reported_data.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import com.cn.zyzs.hibernate.util.Page;
import com.cn.zyzs.utils.utils.PageContext;
import jll.model.basic_pnformation_submit.EquityInvestment;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EquityInvestmentDao extends SimpleHibernateTemplate<EquityInvestment> {
    /**
     * 增加股权投资
     */
    public void addEquityInvestment(EquityInvestment equityInvestment){
        System.out.println("执行股权投资!");
        this.getSession().merge(equityInvestment);
    }


    /**
     * 查询股权投资
     */
    public List queryEquityInvestment(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append("select * from ent_equity_investment where 1=1 and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }
    /**
     * 分页查询股权投资
     * */
    public Page queryEquityInvestmentForPage(String entId){
        Map<String, Object> param = new HashMap<String, Object>();
        StringBuffer sql = new StringBuffer();
        LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
        sql.append("select * from ent_equity_investment where 1=1 and ent_id='"+entId+"'");
        return sqlqueryForpage1(sql.toString(), param, PageContext.getPageSize(), PageContext.getOffSet(), orderby);
    }
}
