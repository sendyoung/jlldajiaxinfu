package jll.apply_evaluate.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.apply_evaluate.ScoreRule;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ScoreRuleDao extends SimpleHibernateTemplate<ScoreRule> {
    private static final long serialVersionUID = 1L;

    /**
     * 查询组织评分记录
     * */
    public List queryScoreRuleByAuthOrgId(String authOrgId,String applyEvaluateId){
        StringBuffer sql = new StringBuffer();
        sql.append("select esr.score_rule_id,esr.rule_name,esd.score from eva_score_rule esr left join eva_score_details esd" +
                " on esd.score_rule_id=esr.score_rule_id where 1=1 and auth_org_id='"+authOrgId+"' ");
        sql.append(" and esd.apply_evaluate_id='"+applyEvaluateId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }
    /**
     * 查询组织评分规则
     * */
    public List queryScoreRuleByAuthOrgId(String authOrgId){
        StringBuffer sql = new StringBuffer();
        sql.append("select score_rule_id,rule_name,score from eva_score_rule where 1=1 and auth_org_id='"+authOrgId+"' ");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }

}
