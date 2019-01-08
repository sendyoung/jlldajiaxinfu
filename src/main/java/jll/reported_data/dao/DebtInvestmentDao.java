package jll.reported_data.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import com.cn.zyzs.hibernate.util.Page;
import com.cn.zyzs.utils.utils.PageContext;
import jll.model.basic_pnformation_submit.CreditorRightsInvestment;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DebtInvestmentDao extends SimpleHibernateTemplate<CreditorRightsInvestment> {
    /**
     * 增加债权投资
     */
    public void addDebtInvestment(CreditorRightsInvestment creditorRightsInvestment){
        System.out.println("执行债权投资!");
        this.getSession().merge(creditorRightsInvestment);
    }


    /**
     * 查询债权投资
     */
    public List queryDebtInvestment(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append("select * from ent_creditor_rights_investment where 1=1 and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }
    /**
     * 分页查询债权投资
     * */
    public Page queryDebtInvestmentForPage(String entId){
        Map<String, Object> param = new HashMap<String, Object>();
        StringBuffer sql = new StringBuffer();
        LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
        sql.append("select * from ent_creditor_rights_investment where 1=1 and ent_id='"+entId+"'");
        return sqlqueryForpage1(sql.toString(), param, PageContext.getPageSize(), PageContext.getOffSet(), orderby);
    }
}
