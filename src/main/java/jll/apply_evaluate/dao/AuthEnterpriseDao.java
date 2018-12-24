package jll.apply_evaluate.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import com.cn.zyzs.hibernate.util.Page;
import com.cn.zyzs.utils.utils.PageContext;
import jll.model.authentication.AuthEnterpriseBase;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Repository
public class AuthEnterpriseDao extends SimpleHibernateTemplate<AuthEnterpriseBase> {
    private static final long serialVersionUID = 1L;

    /**
     * 查询属于组织行业的企业
     * */
    public Page queryAuthEnterpriseBaseByOrgIndustry(String authOrgId, String name,String typesEnterprises){
        Map<String, Object> param = new HashMap<String, Object>();
        StringBuffer sql = new StringBuffer();
        LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
        sql.append("select aeb.auth_enterprise_id,aeb.enterprise_name,aeb.social_credit_code,aeb.legal_representative,aeb.enterprise_tel,aeb.enterprise_email " +
                "from auth_enterprise_base aeb left join ent_basics eb on aeb.social_credit_code=eb.unified_social_credit_code " +
                "where 1=1 ");
        if(name!=null&&!name.equals("")){
            sql.append("and aeb.enterprise_name='"+name+"' ");
        }
        if(typesEnterprises!=null&&!typesEnterprises.equals("")){
            sql.append("and aeb.types_enterprises='"+typesEnterprises+"' ");
        }
        sql.append("and eb.industry=(select industry from org_organization where org_id='"+authOrgId+"')");
        return sqlqueryForpage1(sql.toString(), param, PageContext.getPageSize(), PageContext.getOffSet(), orderby);
    }
}
