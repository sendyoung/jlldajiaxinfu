package jll.account_authentication.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.enterprise.EntBasics;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 企业工商信息
 */
@Repository
public class EntBasicsDao extends SimpleHibernateTemplate<EntBasics> {

    /**
     *回显企业认证数据
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

}
