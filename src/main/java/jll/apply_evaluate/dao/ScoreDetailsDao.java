package jll.apply_evaluate.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.apply_evaluate.ScoreDetails;
import jll.utils.MapTrunPojo;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ScoreDetailsDao extends SimpleHibernateTemplate<ScoreDetails> {
    private static final long serialVersionUID = 1L;

    /**
     * 查询评分是否存在
     * */
    public ScoreDetails queryScoreDetailsForOne(String applyEvaluateId,String scoreRuleId){
        StringBuffer sql = new StringBuffer();
        sql.append("select * from eva_score_details where 1=1 and score_rule_id='"+scoreRuleId+"' and apply_evaluate_id='"+applyEvaluateId+"' ");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List list=query.list();
        if(list==null||list.size()==0){
            return null;
        }
        ScoreDetails sd=(ScoreDetails)MapTrunPojo.map2Object((Map)list.get(0),ScoreDetails.class);
        return sd;
    }
    /**
     * 修改评分
     * */
    public void saveScoreDetails(ScoreDetails scoreDetails){
        if(scoreDetails.getScore_details_id()!=null&&!scoreDetails.getScore_details_id().equals("")){
            this.getSession().saveOrUpdate(scoreDetails);
        }else{
            this.getSession().save(scoreDetails);
        }
    }
}
