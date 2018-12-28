package jll.account_authentication.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import com.cn.zyzs.hibernate.util.Page;
import com.cn.zyzs.utils.utils.PageContext;
import jll.model.authentication.AuthEnterpriseBase;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
        if(!"".equals(authEnterpriseBase.getAuth_enterprise_id()) && null != authEnterpriseBase.getAuth_enterprise_id()){
            this.getSession().saveOrUpdate(authEnterpriseBase);
        }else{
            this.getSession().save(authEnterpriseBase);
        }
    }

    /**
     * 企业认证表findEnterpriseNameByAuthId
     * 根据认证ID查询企业名称
     */
    public List findEnterpriseNameByAuthId(String authId){
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT                                                                                      ");
        sql.append(" 	authEnterpriseBase.enterprise_name                                                                             ");
        sql.append(" FROM                                                                                        ");
        sql.append(" 	auth_enterprise_base authEnterpriseBase                                                                ");
        sql.append(" WHERE                                                                                       ");
        sql.append(" 1 = 1        ");
        sql.append(" AND authEnterpriseBase.isDelete = '0'                                                                                      ");
        sql.append(" AND authEnterpriseBase.auth_enterprise_id = '" + authId + "'                                                               ");

        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }
    /**
     * 查询所有的认证中的企业
     * */
    public Page queryAuthEnterpriseBase(String name,String createTime,String code){
        Map<String, Object> param = new HashMap<String, Object>();
        StringBuffer sql = new StringBuffer();
        LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
        sql.append("select oua.user_id,oua.username,aeb.auth_enterprise_id,aeb.enterprise_name " +
                ",aeb.social_credit_code,aeb.legal_representative,oua.authentication_type,aeb.create_time " +
                "from org_user_account oua left join auth_enterprise_base aeb on oua.authentication_id=aeb.auth_enterprise_id " +
                "where 1=1 and oua.authentication_type='1' ");
        if(name!=null&&!name.equals("")){
            sql.append(" and aeb.enterprise_name='"+name+"' ");
        }
        if(createTime!=null&&!createTime.equals("")){
            sql.append(" and aeb.social_credit_code='"+code+"' ");
        }
        if(code!=null&&!code.equals("")){
            sql.append(" and aeb.create_time='"+createTime+"' ");
        }
        sql.append("order by aeb.create_time desc");
        return sqlqueryForpage1(sql.toString(), param, PageContext.getPageSize(), PageContext.getOffSet(), orderby);
    }

}
