package jll.data_list.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.data_list.FinancialExpenses;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FinancialExpensesDao extends SimpleHibernateTemplate<FinancialExpenses> {

    private static final long serialVersionUID = 1L;
    /**
     * period年度
     * 查询财务费用信息
     * */
    public FinancialExpenses queryFinancialExpensesForPeriod(String entId,Integer period){
        StringBuffer sql = new StringBuffer();
        sql.append(" select efe.* from ent_financial_expenses efe where 1=1 and period='"+period+"' and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List<FinancialExpenses> list=query.list();
        if(list==null){
            return null;
        }
        return (FinancialExpenses)query.list().get(0);
    }

    /**
     * 添加财务费用信息
     * */
    public void saveFinancialExpenses(FinancialExpenses financialExpenses){
        if(financialExpenses.getFinancial_expenses_id()!=null&&!financialExpenses.getFinancial_expenses_id().equals("")){
            this.getSession().saveOrUpdate(financialExpenses);
        }else{
            this.getSession().save(financialExpenses);
        }
    }

}
