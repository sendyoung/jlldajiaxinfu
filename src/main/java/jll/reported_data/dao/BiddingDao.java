package jll.reported_data.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import com.cn.zyzs.hibernate.util.Page;
import com.cn.zyzs.utils.utils.PageContext;
import jll.model.basic_pnformation_submit.Bidding;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
    /**
     * 分页查询招投标信息
     * */
    public Page queryBiddingForPage(String entId){
        Map<String, Object> param = new HashMap<String, Object>();
        StringBuffer sql = new StringBuffer();
        LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
        sql.append("select * from ent_Bidding where 1=1 and ent_id='"+entId+"'");
        return sqlqueryForpage1(sql.toString(), param, PageContext.getPageSize(), PageContext.getOffSet(), orderby);
    }


}
