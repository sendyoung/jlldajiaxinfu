package jll.bad_information.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.bad_information.Executor;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

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
}
