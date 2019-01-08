package jll.reported_data.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.BasicPnformationSubmit.Trademark;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class TrademarkDao extends SimpleHibernateTemplate<Trademark> {
    /**
     * 添加商标信息
     */
    public void addTrademark(Trademark trademark){
        System.out.println("执行商标信息dao层!");
        this.getSession().merge(trademark);
    }

    /**
     * 查询商标信息
     */
    public List queryTrademark(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append("select * from ent_trademark where 1=1 and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }
}
