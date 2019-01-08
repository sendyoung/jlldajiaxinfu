package jll.reported_data.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.basic_pnformation_submit.EquityFinancing;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EquityFinancingDao extends SimpleHibernateTemplate<EquityFinancing> {
    /**
     * 增加股权融资
     */
    public void addEquityFinancing(EquityFinancing equityFinancing){
        System.out.println("执行股权融资!");
        this.getSession().merge(equityFinancing);
    }


    /**
     * 查询股权融资
     */
    public List queryEquityFinancing(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append("select * from ent_equity_financing where 1=1 and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }
}
