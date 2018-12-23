package jll.apply_evaluate.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import com.cn.zyzs.hibernate.util.Page;
import com.cn.zyzs.utils.utils.PageContext;
import jll.model.apply_evaluate.EnterprisesPunishment;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EnterprisesPunishmentDao extends SimpleHibernateTemplate<EnterprisesPunishment> {
    private static final long serialVersionUID = 1L;

    /**
     * 查询组织下企业的黑名单信息
     */
    public Page queryEnterprisesPunishmentByAuthOrgId(String authOrgId){
        Map<String, Object> param = new HashMap<String, Object>();
        StringBuffer sql = new StringBuffer();
        LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
        sql.append("select eae.apply_evaluate_id,aeb.enterprise_name,count(eep.enterprises_punishment_id) count  " +
                "from eva_apply_evaluate eae " +
                "left join auth_enterprise_base aeb on aeb.auth_enterprise_id = eae.auth_enterprise_id " +
                "left join ent_basics eb on aeb.social_credit_code=eb.unified_social_credit_code " +
                "left join ent_enterprises_punishment eep on eep.ent_id=eb.ent_id " +
                "where 1=1 and eae.auth_org_id="+authOrgId+" and eae.audit_status in ('3','4') " +
                "having count>0");
        return sqlqueryForpage1(sql.toString(), param, PageContext.getPageSize(), PageContext.getOffSet(), orderby);
    }

    /**
     * 查询组织黑名单的请求ID
     * */
    public List EnterprisesPunishmentByAuthOrgIdForApplyEvaluateId(String authOrgId){
        StringBuffer sql = new StringBuffer();
        sql.append("select eae.apply_evaulate_id,aeb.enterprise_name,count(eep.enterprises_punishment_id) count  " +
                "from eva_apply_evaluate eae " +
                "left join auth_enterprise_base aeb on aeb.auth_enterprise_id = eae.auth_enterprise_id " +
                "left join ent_basics eb on aeb.social_credit_code=eb.unified_social_credit_code " +
                "left join ent_enterprises_punishment eep on eep.ent_id=eb.ent_id " +
                "where 1=1 and eae.auth_org_id="+authOrgId+" and eae.audit_status in ('3','4') " +
                "having count>0");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }

}
