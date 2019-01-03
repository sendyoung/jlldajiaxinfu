package jll.bad_information.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.Statistics;
import jll.model.bad_information.Executor;
import jll.utils.MapTrunPojo;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@Repository
public class ExecutorDao extends SimpleHibernateTemplate<Executor> {

    private static final long serialVersionUID = 1L;
    /**
     *entId企业ID
     * 查询被执行人信息
     * */
    public List queryExecutor(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append(" select ee.* from ent_executor ee where 1=1 and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }

    /**
     * 添加被执行人信息
     * */
    public void saveExecutor(Executor executor){
        if(executor.getExecutor_id()!=null&&!executor.getExecutor_id().equals("")){
            this.getSession().saveOrUpdate(executor);
        }else{
            this.getSession().save(executor);
        }
    }
    /**
     * 企业被执行人统计数量
     * */
    public BigInteger queryExecutorForCount(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append(" select count(*) count from ent_executor where 1=1 and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List list=query.list();
        if(list==null||list.size()==0){
            return null;
        }
        Statistics statistics=(Statistics) MapTrunPojo.map2Object((Map)list.get(0),Statistics.class);
        return statistics.getCount();
    }
}
