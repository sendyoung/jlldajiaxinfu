package jll.reported_data.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.BasicPnformationSubmit.BondFinancing;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class DebtfinancingDao extends SimpleHibernateTemplate<BondFinancing> {
    /**
     * 增加债权融资
     */
    public void addDebtfinancing(BondFinancing bondFinancing){
        System.out.println("执行增主体增加信用记录!");
        this.getSession().merge(bondFinancing);
    }


    /**
     * 查询债权融资
     */
    public List queryDebtfinancing(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append("select * from ent_bond_financing where 1=1 and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }
}
