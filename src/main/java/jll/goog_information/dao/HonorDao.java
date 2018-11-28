package jll.goog_information.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.Honor;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

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
        this.getSession().saveOrUpdate(honor);
    }

}
