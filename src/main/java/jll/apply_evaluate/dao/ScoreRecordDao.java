package jll.apply_evaluate.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.apply_evaluate.ScoreRecord;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ScoreRecordDao extends SimpleHibernateTemplate<ScoreRecord> {
    private static final long serialVersionUID = 1L;

    /**
     * 添加评分记录
     * */
    public void saveScoreResult(ScoreRecord scoreRecord){
        if(scoreRecord.getScore_record_id()!=null&&!scoreRecord.getScore_record_id().equals("")){
            this.getSession().saveOrUpdate(scoreRecord);
        }else{
            this.getSession().save(scoreRecord);
        }
    }
    /**
     * 根据申请Id查询评分记录
     * */
    public List queryScoreRecordByApplyEvaluateId(String applyEvaluateId){
        StringBuffer sql = new StringBuffer();
        sql.append("select * from eva_score_record where 1=1 and apply_evaluate_id="+applyEvaluateId+" ");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }

}
