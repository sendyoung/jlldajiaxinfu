package jll.apply_evaluate.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import com.cn.zyzs.hibernate.util.Page;
import com.cn.zyzs.utils.utils.PageContext;
import jll.model.apply_evaluate.EvaluateAppeal;
import jll.utils.MapTrunPojo;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class EvaluateAppealDao extends SimpleHibernateTemplate<EvaluateAppeal> {
    private static final long serialVersionUID = 1L;

    /**
     * 添加申诉信息
     * */
    public void saveEvaluateAppeal(EvaluateAppeal evaluateAppeal){
        if(evaluateAppeal.getEvaluate_appeal_id()!=null&&!evaluateAppeal.getEvaluate_appeal_id().equals("")){
            this.getSession().saveOrUpdate(evaluateAppeal);
        }else{
            evaluateAppeal.setIsDelete("0");
            evaluateAppeal.setCreate_time(new Date());
            this.getSession().save(evaluateAppeal);
        }
    }
    /**
     * 查询历史申诉
     * */
    public Page queryEvaluateAppealHistory(String authEnterpriseId,String appealStype,String appealCreateTime, String appealStatus){
        Map<String, Object> param = new HashMap<String, Object>();
        StringBuffer sql = new StringBuffer();
        LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
        sql.append("select eae.auth_org_id,eae.apply_evaluate_id,eae.remarks,aob.organization_name,eea.create_time,eea.appeal_title,eea.details,eae.appeal_status " +
                "from eva_apply_evaluate eae " +
                "left join eva_evaluate_appeal eea on eea.apply_evaluate_id=eae.apply_evaluate_id " +
                "left join auth_org_base aob on aob.auth_org_id=eae.auth_org_id " +
                "where 1=1 and eae.auth_enterprise_id='"+authEnterpriseId+"' ");
        if(appealStype!=null&&!appealStype.equals("")){
            sql.append(" and eea.stype='"+appealStype+"' ");
        }
        if(appealCreateTime!=null&&!appealCreateTime.equals("")){
            sql.append(" and date_format(eea.create_time,'%Y-%c-%d')='"+appealCreateTime+"' ");
        }
        if(appealStatus!=null&&!appealStatus.equals("")){
            sql.append(" and eae.appeal_status='"+appealStatus+"' ");
        }else{
            sql.append(" and eae.appeal_status in ('1','2','3','4')");
        }
        sql.append(" order by eea.create_time desc");
        return sqlqueryForpage1(sql.toString(), param, PageContext.getPageSize(), PageContext.getOffSet(), orderby);
    }
    /**
     * 历史申诉详情
     * */
    public Object queryEvaluateAppealByApplyEvaluateId(String applyEvalateId){
        StringBuffer sql = new StringBuffer();
        sql.append("select eae.auth_org_id,eae.apply_evaluate_id,eae.create_time apply_time,eea.appeal_title,eea.stype,eea.create_time appeal_time,eea.evidence,eea.details,esr.level " +
                "from eva_apply_evaluate eae " +
                "left join eva_evaluate_appeal eea on eea.apply_evaluate_id=eae.apply_evaluate_id " +
                "left join auth_org_base aob on aob.auth_org_id=eae.auth_org_id " +
                "left join eva_score_result esr on esr.apply_evaluate_id=eae.apply_evaluate_id " +
                "where 1=1 and eae.apply_evaluate_id='"+applyEvalateId+"' ");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List list=query.list();
        if(list==null||list.size()==0){
            return null;
        }
        return list.get(0);
    }
    /**
     * 组织的所有申诉
     * */
    public Page queryEvaluateAppealByAuthOrgId(String authOrgId,String stype,String appealTime,String appealStatus,String name){
        Map<String, Object> param = new HashMap<String, Object>();
        StringBuffer sql = new StringBuffer();
        LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
        sql.append("select eae.auth_enterprise_id,eea.evaluate_appeal_id,eae.apply_evaluate_id,eea.create_time appeal_time,aeb.enterprise_name,eea.appeal_title,eea.details,eea.stype,eae.appeal_status " +
                "from eva_apply_evaluate eae " +
                "left join eva_evaluate_appeal eea on eae.apply_evaluate_id=eea.apply_evaluate_id " +
                "left join auth_enterprise_base aeb on aeb.auth_enterprise_id = eae.auth_enterprise_id  " +
                "where 1=1 and eae.auth_org_id='"+authOrgId+"' ");
        if(appealStatus!=null&&!appealStatus.equals("")){
            sql.append(" and eae.appeal_status='"+appealStatus+"' ");
        }else{
            sql.append(" and eae.appeal_status in ('1','2','3','4')");
        }
        if(appealTime!=null&&!appealTime.equals("")){
            sql.append(" and date_format(eea.create_time,'%Y-%c-%d')='"+appealTime+"' ");
        }
        if(stype!=null&&!stype.equals("")){
            sql.append(" and eea.stype='"+stype+"' ");
        }
        if(name!=null&&!name.equals("")){
            sql.append(" and aeb.enterprise_name='"+name+"' ");
        }
        sql.append(" order by eea.create_time desc");
        return sqlqueryForpage1(sql.toString(), param, PageContext.getPageSize(), PageContext.getOffSet(), orderby);
    }
    /**
     * 查看组织异议详情
     * */
    public Object queryEvaluateAppealDetailsForApplyEvaluateId(String evaluateAppealId){
        StringBuffer sql = new StringBuffer();
        sql.append("select eae.auth_enterprise_id,eea.evaluate_appeal_id,eae.apply_evaluate_id,eea.create_time appeal_time,aeb.enterprise_name,eea.appeal_title,eea.details,eea.stype,eae.appeal_status,eea.evidence,eea.objection_title,eea.handle_content,eea.handle_material,eea.handler " +
                "from eva_apply_evaluate eae " +
                "left join eva_evaluate_appeal eea on eae.apply_evaluate_id=eea.apply_evaluate_id " +
                "left join auth_enterprise_base aeb on aeb.auth_enterprise_id = eae.auth_enterprise_id  " +
                "where 1=1 and eea.evaluate_appeal_id='"+evaluateAppealId+"' ");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List list=query.list();
        if(list==null||list.size()==0){
            return null;
        }
        return list.get(0);
    }
    /**
     * 查询申诉详情
     * */
    public EvaluateAppeal queryEvaluateAppeal(String evaluateAppealId){
        StringBuffer sql = new StringBuffer();
        sql.append("select * from eva_evaluate_appeal where evaluate_appeal_id='"+evaluateAppealId+"' ");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List list=query.list();
        if(list==null||list.size()==0){
            return null;
        }
        EvaluateAppeal ea=(EvaluateAppeal)MapTrunPojo.map2Object((Map)list.get(0),EvaluateAppeal.class);
        return ea;
    }

}
