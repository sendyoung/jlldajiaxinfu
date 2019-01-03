package jll.good_information.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.Statistics;
import jll.model.good_information.Honor;
import jll.utils.MapTrunPojo;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@Repository
public class HonorDao extends SimpleHibernateTemplate<Honor> {

    private static final long serialVersionUID = 1L;
    /**
     *entId企业ID
     * 查询表彰信息
     * */
    public List queryHonor(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append(" select eh.* from ent_honor eh where 1=1 and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }

    /**
     * 添加表彰信息
     * */
    public void saveHonor(Honor honor){
        if(honor.getHonor_id()!=null&&!honor.getHonor_id().equals("")){
            this.getSession().saveOrUpdate(honor);
        }else{
            this.getSession().save(honor);
        }
    }
    /**
     * 企业表彰统计数量
     * */
    public BigInteger queryHonorForCount(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append(" select count(*) count from ent_honor eh where 1=1 and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List list=query.list();
        if(list==null||list.size()==0){
            return null;
        }
        Statistics statistics=(Statistics) MapTrunPojo.map2Object((Map)list.get(0),Statistics.class);
        System.out.println("------------"+statistics.getCount());
        return statistics.getCount();
    }

}
