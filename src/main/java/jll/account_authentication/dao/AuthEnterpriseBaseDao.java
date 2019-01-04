package jll.account_authentication.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import com.cn.zyzs.hibernate.util.Page;
import com.cn.zyzs.utils.utils.PageContext;
import jll.model.authentication.AuthEnterpriseBase;
import jll.model.enterprise.EntBasics;
import jll.utils.MapTrunPojo;
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
        if(code!=null&&!code.equals("")){
            sql.append(" and aeb.social_credit_code='"+code+"' ");
        }
        if(createTime!=null&&!createTime.equals("")){
            sql.append(" and aeb.create_time='"+createTime+"' ");
        }
        sql.append("order by aeb.create_time desc");
        return sqlqueryForpage1(sql.toString(), param, PageContext.getPageSize(), PageContext.getOffSet(), orderby);
    }
    /**
     * 修改认证审核状态
     * */
    public void updateUserForAuthenticationType(String userId,String type){
        StringBuffer sql = new StringBuffer();
        sql.append("update org_user_account set authentication_type='"+type+"' where user_id='"+userId+"' ");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        query.executeUpdate();
    }
    /**
     * 查询认证信息
     * */
    public AuthEnterpriseBase queryAuthEnterpriseBaseByUserId(String userId){
        StringBuffer sql = new StringBuffer();
        sql.append("select aeb.enterprise_logo,aeb.enterprise_tel,aeb.enterprise_email,aeb.enterprise_website" +
                ",aeb.enterprise_introduction,aeb.business_scope,aeb.residence,aeb.registration_authority " +
                ",aeb.date_establishment,aeb.types_enterprises,aeb.registered_capital,aeb.enterprise_name,aeb.social_credit_code " +
                "from org_user_account oua left join auth_enterprise_base aeb on oua.authentication_id=aeb.auth_enterprise_id " +
                "where oua.user_id='"+userId+"' ");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List list=query.list();
        if(list==null||list.size()==0){
            return null;
        }
        AuthEnterpriseBase aeb=(AuthEnterpriseBase) MapTrunPojo.map2Object((Map)list.get(0),AuthEnterpriseBase.class);
        return aeb;
    }
    /**
     * 根据认证社会统一代码查询工商信息
     * */
    public EntBasics queryEntBasicsByCode(String code){
        StringBuffer sql = new StringBuffer();
        sql.append("select eb.* " +
                "from ent_basics eb left join auth_enterprise_base aeb on eb.unified_social_credit_code=aeb.social_credit_code " +
                "where aeb.social_credit_code='"+code+"' ");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List list=query.list();
        if(list==null||list.size()==0){
            return null;
        }
        EntBasics aeb=(EntBasics) MapTrunPojo.map2Object((Map)list.get(0),EntBasics.class);
        return aeb;
    }


}
