package jll.bad_information.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.bad_information.DiscreditExecutor;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DiscreditExecutorDao extends SimpleHibernateTemplate<DiscreditExecutor> {

    private static final long serialVersionUID = 1L;
    /**
     *entId企业ID
     * 查询失信被执行人信息
     * */
    public List queryDiscreditExecutor(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append(" select ede.* from ent_discredit_executor ede where 1=1 and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }

    /**
     * 添加失信被执行人信息
     * */
    public void saveDiscreditExecutor(DiscreditExecutor discreditExecutor){
        if(discreditExecutor.getDiscredit_executor_id()!=null&&!discreditExecutor.getDiscredit_executor_id().equals("")){
            this.getSession().saveOrUpdate(discreditExecutor);
        }else{
            this.getSession().save(discreditExecutor);
        }

    }

}
