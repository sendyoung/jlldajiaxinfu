package jll.account_authentication.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import com.cn.zyzs.hibernate.util.Page;
import com.cn.zyzs.utils.utils.PageContext;
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

    //查看所有待审核的组织列表(列表字段:用户ID,用户名,组织名,社会信用统一代码,法定代表人,认证状态,申请认证时间)通过不通过按钮
    //筛选条件(名称,申请认证时间,社会信用统一代码)
    public Page findAuthOrgBaseAuditList(String orgName,String authTime,String creditCode){
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT oua.user_id,oua.username,oua.authentication_type,aob.auth_org_id,aob.organization_name,aob.social_credit_code,aob.legal_representative,aob.create_time FROM org_user_account oua LEFT JOIN auth_org_base aob ON oua.authentication_id = aob.auth_org_id AND oua.isDelete = '0' AND oua.authentication_type = '3' ");
        if(orgName!=null&&!orgName.equals("")){
            sql.append(" AND aob.organization_name='"+orgName+"' ");
        }
        if(authTime!=null&&!authTime.equals("")){
            sql.append(" and aob.create_time='"+authTime+"' ");
        }
        if(creditCode!=null&&!creditCode.equals("")){
            sql.append(" AND aob.social_credit_code='"+creditCode+"' ");
        }
        sql.append("ORDER BY aob.create_time DESC");
        return sqlqueryForpage1(sql.toString(), null, PageContext.getPageSize(), PageContext.getOffSet(), null);
    }


}
