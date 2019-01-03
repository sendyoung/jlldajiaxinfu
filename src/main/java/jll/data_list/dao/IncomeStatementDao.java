package jll.data_list.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.data_list.IncomeStatement;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IncomeStatementDao extends SimpleHibernateTemplate<IncomeStatement> {

    private static final long serialVersionUID = 1L;
    /**
     * 查询企业利润信息
     * */
    public List queryIncomeStatementByEntId(String entId,String oneYear,String twoYear,String threeYear){
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT account_name, " +
                "    MAX(CASE left(period,4) WHEN '"+oneYear+"' THEN account_value ELSE 0 END )  '"+oneYear+"', " +
                "    MAX(CASE left(period,4) WHEN '"+twoYear+"' THEN account_value ELSE 0 END )  '"+twoYear+"', " +
                "    MAX(CASE left(period,4) WHEN '"+threeYear+"' THEN account_value ELSE 0 END )  '"+threeYear+"' " +
                "FROM ent_income_statement where 1=1 and ent_id='"+entId+"' " +
                "GROUP BY account_name");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }


}
