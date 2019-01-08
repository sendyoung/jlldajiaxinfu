package jll.reported_data.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.basic_pnformation_submit.CreditRecord;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CreditHistoryDao extends SimpleHibernateTemplate<CreditRecord> {
    /**
     * 增加信用记录
     */
    public void addCreditHistory(CreditRecord creditRecord){
        System.out.println("执行增主体增加信用记录!");
        this.getSession().merge(creditRecord);
    }


    /**
     * 查询信用记录
     */
    public List queryCreditHistory(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append("select * from ent_credit_record where 1=1 and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();

    }
}
