package jll.account_authentication.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.enterprise.EntBasics;
import jll.utils.MapTrunPojo;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 企业工商信息
 */
@Repository
public class EntBasicsDao extends SimpleHibernateTemplate<EntBasics> {

    /**
     *回显企业工商数据
     */
    public List findEntBasics(String unified_social_credit_code) {
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT                                                                                      ");
        sql.append(" 	entBasics.*                                                                              ");
        sql.append(" FROM                                                                                        ");
        sql.append(" 	ent_basics entBasics                                                                ");
        sql.append(" WHERE                                                                                       ");
        sql.append(" 1 = 1        ");
        sql.append(" AND entBasics.isDelete = '0'                                                                                      ");
        sql.append(" AND entBasics .unified_social_credit_code = '" + unified_social_credit_code + "'                                                               ");

        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }
    /**
     * 根据企业认证ID查询工商信息
     * */
    public EntBasics queryEntBasics(String authEnterpriseId){
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT eb.* from ent_basics eb left join auth_enterprise_base aeb " +
                "on aeb.social_credit_code=eb.unified_social_credit_code where 1=1 and aeb.auth_enterprise_id='"+authEnterpriseId+"' ");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List list=query.list();
        if(list==null||list.size()==0){
            return null;
        }
        EntBasics eb=(EntBasics)MapTrunPojo.map2Object((Map)list.get(0),EntBasics.class);
        return eb;
    }
    /**
     * 修改工商信息
     * */
    public void updateEntBasics(EntBasics entBasics){
        this.getSession().saveOrUpdate(entBasics);
    }

}
