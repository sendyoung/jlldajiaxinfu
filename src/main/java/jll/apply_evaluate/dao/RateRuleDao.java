package jll.apply_evaluate.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.apply_evaluate.RateRule;
import jll.model.apply_evaluate.ScoreResult;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RateRuleDao extends SimpleHibernateTemplate<RateRule> {
    private static final long serialVersionUID = 1L;

    /**
     * 查询组织评级规则
     * */
    public List queryRateRuleByAuthOrgId(String authOrgId){
        StringBuffer sql = new StringBuffer();
        sql.append("select * from eva_rate_rule where 1=1 and auth_org_id='"+authOrgId+"' ");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }

}
