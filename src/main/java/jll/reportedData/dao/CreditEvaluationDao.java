package jll.reportedData.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.BasicPnformationSubmit.SubjectCreditEvaluation;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CreditEvaluationDao extends SimpleHibernateTemplate<SubjectCreditEvaluation> {
    /**
     * 增加主体信用评价
     */
    public void addCreditEvaluation(SubjectCreditEvaluation subjectCreditEvaluation){
        System.out.println("执行增主体信用评价dao层!");
        this.getSession().merge(subjectCreditEvaluation);
    }


    /**
     * 查询主体信用评价
     */
    public List queryCreditEvaluation(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append("select * from ent_subjectCredit_evaluation where 1=1 and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();

    }
}
