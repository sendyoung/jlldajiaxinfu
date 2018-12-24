package jll.reportedData.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.BasicPnformationSubmit.CreditorRightsInvestment;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;
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
}
