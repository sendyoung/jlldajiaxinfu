package jll.reported_data.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.basic_pnformation_submit.Bidding;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BiddingDao extends SimpleHibernateTemplate<Bidding> {
    /**
     * 增加招投标信息
     */
    public void addBidding(Bidding bidding){
        System.out.println("执行增加自动化建设信息dao层!");
        this.getSession().merge(bidding);
    }

    /**
     * 查询招投标信息
     */
    public List queryBidding(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append("select * from ent_Bidding where 1=1 and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();

    }


}
