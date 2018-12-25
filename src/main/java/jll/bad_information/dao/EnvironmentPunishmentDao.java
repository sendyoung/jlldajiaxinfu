package jll.bad_information.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.bad_information.EnvironmentPunishment;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EnvironmentPunishmentDao extends SimpleHibernateTemplate<EnvironmentPunishment> {

    private static final long serialVersionUID = 1L;
    /**
     *entId企业ID
     * 查询环保处罚信息
     * */
    public List queryEnvironmentPunishment(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append(" select eep.* from ent_environment_punishment eep where 1=1 and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }

    /**
     * 添加环保处罚信息
     * */
    public void saveEnvironmentPunishment(EnvironmentPunishment environmentPunishment){
        if(environmentPunishment.getEnvironment_punishment_id()!=null&&!environmentPunishment.getEnvironment_punishment_id().equals("")){
            this.getSession().saveOrUpdate(environmentPunishment);
        }else{
            this.getSession().save(environmentPunishment);
        }
    }




}
