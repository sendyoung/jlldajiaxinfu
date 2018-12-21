package jll.account_authentication.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.authentication.AuthOrgBase;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

//组织认证
@Repository
public class AuthOrgBaseDao extends SimpleHibernateTemplate<AuthOrgBase> {

    /**
     *回显企业认证数据
     */
    public List findAuthOrgBase(String authenticationId) {
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT                                                                                      ");
        sql.append(" 	authOrgBase.*                                                                              ");
        sql.append(" FROM                                                                                        ");
        sql.append(" 	auth_org_base authOrgBase                                                                ");
        sql.append(" WHERE                                                                                       ");
        sql.append(" 1 = 1        ");
        sql.append(" AND authOrgBase.isDelete = '0'                                                                                      ");
        sql.append(" AND authOrgBase .auth_org_id = '" + authenticationId + "'                                                               ");

        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }

    /**
     * 新增认证或者更新认证数据
     */
    public void saveOrUpdateAuthOrgBase(AuthOrgBase authOrgBase){
        if(authOrgBase.getAuth_org_id()!=null && !"".equals(authOrgBase.getAuth_org_id())){
            this.getSession().saveOrUpdate(authOrgBase);
        }else{
            this.getSession().save(authOrgBase);
        }

    }

    /**
     * 组织认证表findOrgNameByAuthId
     * 根据认证ID查询组织名称
     */
    public List findOrgNameByAuthId(String authId) {
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT                                                                                      ");
        sql.append(" 	authOrgBase.organization_name                                                                            ");
        sql.append(" FROM                                                                                        ");
        sql.append(" 	auth_org_base authOrgBase                                                                ");
        sql.append(" WHERE                                                                                       ");
        sql.append(" 1 = 1        ");
        sql.append(" AND authOrgBase.isDelete = '0'                                                                                      ");
        sql.append(" AND authOrgBase .auth_org_id = '" + authId + "'                                                               ");

        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }
}
