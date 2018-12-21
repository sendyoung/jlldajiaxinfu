package jll.apply_evaluate.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import com.cn.zyzs.hibernate.util.Page;
import com.cn.zyzs.utils.utils.PageContext;
import jll.model.apply_evaluate.ScoreResult;
import jll.utils.MapTrunPojo;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ScoreResultDao extends SimpleHibernateTemplate<ScoreResult> {
    private static final long serialVersionUID = 1L;

    /**
     * 添加评分结果
     * */
    public void saveScoreResult(ScoreResult scoreResult){
        if(scoreResult.getScore_result_id()!=null&&!scoreResult.getScore_result_id().equals("")){
            this.getSession().saveOrUpdate(scoreResult);
        }else{
            this.getSession().save(scoreResult);
        }
    }
    /**
     * 根据申请Id查询结果
     * */
    public ScoreResult queryScoreResultByApplyEvaluateId(String applyEvaluateId){
        StringBuffer sql = new StringBuffer();
        sql.append("select * from eva_score_result where 1=1 and apply_evaluate_id="+applyEvaluateId+" ");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List list=query.list();
        if(list==null||list.size()==0){
            return null;
        }
        ScoreResult sr=(ScoreResult)MapTrunPojo.map2Object((Map)list.get(0),ScoreResult.class);
        return sr;
    }
    /**
     * 查询组织所有请求结果数
     * */
    public Object queryScoreResultForCount(String authOrgId,String level){
        StringBuffer sql = new StringBuffer();
        sql.append("select count(eae.apply_evaluate_id) count from eva_apply_evaluate eae" +
                " left join eva_score_result esr on esr.apply_evaluate_id=eae.apply_evaluate_id" +
                " where 1=1 and eae.auth_org_id="+authOrgId+" and eae.audit_status=4 and esr.level='"+level+"' ");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List list=query.list();
        if(list==null||list.size()==0){
            return null;
        }
        return list.get(0);
    }
    /**
     * 查询组织所有某个等级的企业
     * */
    public Page queryScoreResultByLevel(String authOrgId, String level){
        Map<String, Object> param = new HashMap<String, Object>();
        StringBuffer sql = new StringBuffer();
        LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
        sql.append("select eae.apply_evaluate_id,aeb.enterprise_name from auth_enterprise_base aeb left join eva_apply_evaluate eae" +
                " on eae.auth_enterprise_id=aeb.auth_enterprise_id " +
                " left join eva_score_result esr on esr.apply_evaluate_id=eae.apply_evaluate_id" +
                " where 1=1 and eae.auth_org_id="+authOrgId+" and eae.audit_status=4 and esr.level='"+level+"' ");
        return sqlqueryForpage1(sql.toString(), param, PageContext.getPageSize(), PageContext.getOffSet(), orderby);
    }

}
