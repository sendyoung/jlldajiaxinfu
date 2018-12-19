package jll.account_authentication.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.authentication.AuthEnterpriseBase;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

//企业认证
@Repository
public class AuthEnterpriseBaseDao extends SimpleHibernateTemplate<AuthEnterpriseBase> {
    /**
     *回显企业认证数据
     */
    public List findAuthEnterpriseBase(String authenticationId) {
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT                                                                                      ");
        sql.append(" 	authEnterpriseBase.*                                                                              ");
        sql.append(" FROM                                                                                        ");
        sql.append(" 	auth_enterprise_base authEnterpriseBase                                                                ");
        sql.append(" WHERE                                                                                       ");
        sql.append(" 1 = 1        ");
        sql.append(" AND authEnterpriseBase.isDelete = '0'                                                                                      ");
        sql.append(" AND authEnterpriseBase.auth_enterprise_id = '" + authenticationId + "'                                                               ");

        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }

    /**
     * 新增认证或者更新认证数据
     */
    public void saveOrUpdateAuthEnterpriseBase(AuthEnterpriseBase authEnterpriseBase){
        this.getSession().saveOrUpdate(authEnterpriseBase);
    }

    /**
     * 企业认证表findEnterpriseNameByAuthId
     *
     *
     * 									  申请评价关系表findEntAuthIdByOrgAuthId
     */

}
