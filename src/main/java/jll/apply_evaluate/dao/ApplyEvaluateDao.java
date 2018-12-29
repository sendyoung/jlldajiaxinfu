package jll.apply_evaluate.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import com.cn.zyzs.hibernate.util.Page;
import com.cn.zyzs.utils.utils.PageContext;
import jll.model.apply_evaluate.ApplyEvaluate;
import jll.utils.MapTrunPojo;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ApplyEvaluateDao extends SimpleHibernateTemplate<ApplyEvaluate> {
    private static final long serialVersionUID = 1L;

    /**
     * 修改请求
     * */
    public void saveApplyEvaluate(ApplyEvaluate applyEvaluate){
        if(applyEvaluate.getApply_evaluate_id()!=null&&!applyEvaluate.getApply_evaluate_id().equals("")){
            this.getSession().saveOrUpdate(applyEvaluate);
        }else{
            applyEvaluate.setIsDelete("0");
            applyEvaluate.setCreate_time(new Date());
            this.getSession().save(applyEvaluate);
        }
    }

    /**
     * 查询企业已有关联关系的组织信息
     * */
    public Page queryApplyEvaluateForApplyStatus(String entId){
        Map<String, Object> param = new HashMap<String, Object>();
        StringBuffer sql = new StringBuffer();
        LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
        sql.append("select eae.apply_evaluate_id,eae.apply_status,aob.organization_name,aob.org_tel,aob.org_address,aob.org_email,aob.org_website,aob.org_introduction,aob.auth_org_id,aob.org_logo " +
                "from eva_apply_evaluate eae left join auth_org_base aob on eae.auth_org_id=aob.auth_org_id " +
                "where 1=1 and eae.apply_status in ('0','1','3','2','4') and eae.auth_enterprise_id='"+entId+
                "' order by eae.apply_status asc");
        return sqlqueryForpage1(sql.toString(), param, PageContext.getPageSize(), PageContext.getOffSet(), orderby);
    }
    /**
     * 根据所属行业查询可申请组织并查询企业关联
     * */
    public Page queryApplyEvaluateByIndustry(String authEnterpriseId,String industry){
        Map<String, Object> param = new HashMap<String, Object>();
        StringBuffer sql = new StringBuffer();
        LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
        sql.append("SELECT " +
                " t2.apply_status,t2.apply_evaluate_id,t1.* " +
                "FROM " +
                " ( " +
                "  SELECT " +
                "   aob.auth_org_id,aob.organization_name,aob.org_tel, " +
                "  aob.org_address,aob.org_email,aob.org_website,aob.org_introduction,aob.org_logo " +
                "  FROM " +
                "   auth_org_base aob " +
                "  LEFT JOIN org_organization oo ON aob.auth_org_id = oo.auth_org_id " +
                "  WHERE " +
                "   1=1 ");
        if(industry!=null&&!industry.equals("")){
            sql.append(" and oo.industry = '"+industry+"' ");
        }
        sql.append(" ) AS t1 " +
                "LEFT JOIN ( " +
                " SELECT " +
                "  aob.auth_org_id,eae.apply_evaluate_id,eae.apply_status, eae.auth_enterprise_id " +
                " FROM " +
                "  auth_org_base aob " +
                " LEFT JOIN org_organization oo ON aob.auth_org_id = oo.auth_org_id " +
                " LEFT JOIN eva_apply_evaluate eae ON aob.auth_org_id = eae.auth_org_id " +
                " WHERE " +
                "  1=1 ");
        if(industry!=null&&!industry.equals("")){
            sql.append(" and oo.industry = '"+industry+"' ");
        }
        if(authEnterpriseId!=null&&!authEnterpriseId.equals("")){
            sql.append(" AND eae.auth_enterprise_id ='"+authEnterpriseId+"' ");
        }
        sql.append(" AND eae.apply_status IN ('0','1','2','3','4') " +
                ") AS t2 ON t1.auth_org_id = t2.auth_org_id " +
                "order by t2.apply_status desc");
        return sqlqueryForpage1(sql.toString(), param, PageContext.getPageSize(), PageContext.getOffSet(), orderby);
    }
    /**
     * 根据日期查询企业历史申请信息
     * */
    public Page queryApplyEvaluateByDate(String entId,String date){
        Map<String, Object> param = new HashMap<String, Object>();
        StringBuffer sql = new StringBuffer();
        LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
        sql.append("select eae.auth_org_id,eae.create_time,aob.organization_name,aob.org_tel,eae.audit_status,eae.apply_evaluate_id " +
                "from eva_apply_evaluate eae left join auth_org_base aob on eae.auth_org_id=aob.auth_org_id " +
                "where 1=1 and eae.audit_status>0 and eae.auth_enterprise_id='"+entId+"' ");
        if(date!=null&&!date.equals("")){
            sql.append("and date_format(eae.create_time,'%Y-%c-%d')='"+date+"' ");
        }
        sql.append("order by eae.create_time desc");
        return sqlqueryForpage1(sql.toString(), param, PageContext.getPageSize(), PageContext.getOffSet(), orderby);
    }
    /**
     * 提交审核
     * */
    public void updateApplyEvaluateForAuditStatus(String applyEvaluateId,String applyStatus,String auditStatus){
        StringBuffer sql = new StringBuffer();
        sql.append("update eva_apply_evaluate set apply_status='"+applyStatus+"',audit_status='"+auditStatus+"' where apply_evaluate_id='"+applyEvaluateId+"' ");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        query.executeUpdate();
    }
    /**
     * 查询组织的所有审核
     * */
    public Page queryApplyEvaluateForAuditStatus(String authOrgId,String name,String date,String type,String status){
        Map<String, Object> param = new HashMap<String, Object>();
        StringBuffer sql = new StringBuffer();
        LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
        sql.append("select eae.auth_enterprise_id,eae.audit_status,eae.apply_evaluate_id,aeb.enterprise_name,aeb.social_credit_code,aeb.legal_representative,(select count(eam.apply_module_id) from eva_apply_module eam where eam.apply_evaluate_id=eae.apply_evaluate_id) count " +
                "from auth_enterprise_base aeb right join eva_apply_evaluate eae on aeb.auth_enterprise_id=eae.auth_enterprise_id " +
                "where 1=1 ");
        if(status!=null&&!status.equals("")){
            sql.append("and eae.audit_status='"+status+"' ");
        }else{
            sql.append("and eae.audit_status IN ('1', '2') ");
        }
        if(name!=null&&!name.equals("")){
            sql.append("and aeb.enterprise_name='"+name+"' ");
        }
        if(date!=null&&!date.equals("")){
            sql.append("and date_format(eae.create_time,'%Y-%c-%d')='"+date+"' ");
        }
        if(type!=null&&!type.equals("")){
            sql.append("and aeb.types_enterprises='"+type+"' ");
        }
        sql.append("and eae.auth_org_id='"+authOrgId+ "' ");
        return sqlqueryForpage1(sql.toString(), param, PageContext.getPageSize(), PageContext.getOffSet(), orderby);
    }
    /**
     * 根据申请评价ID
     * 查询详情
     * */
    public Object queryApplyEvaluateDetailByApplyEvaluateId(String applyEvaluateId){
        StringBuffer sql = new StringBuffer();
        sql.append("select eae.create_time,eae.apply_status,eae.audit_status,aob.organization_name,aob.org_tel " +
                "from eva_apply_evaluate eae left join auth_org_base aob " +
                "on aob.auth_org_id=eae.auth_org_id " +
                "where 1=1 and apply_evaluate_id='"+applyEvaluateId+"' ");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List list=query.list();
        if(list==null||list.size()==0){
            return null;
        }
        return list.get(0);
    }
    /**
     * 查询组织所有的信用评价
     * */
    public Page queryApplyEvaluateForCreditEvaluate(String authOrgId,String name,String date,String level,String auditStatus){
        Map<String, Object> param = new HashMap<String, Object>();
        StringBuffer sql = new StringBuffer();
        LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
        sql.append("select eae.auth_enterprise_id,eae.apply_evaluate_id,aeb.enterprise_name,aeb.social_credit_code,aeb.legal_representative,eae.audit_status,eae.auth_org_id,esr.score,esr.level " +
                "from auth_enterprise_base aeb left join eva_apply_evaluate eae on eae.auth_enterprise_id=aeb.auth_enterprise_id " +
                "left join eva_score_result esr on esr.apply_evaluate_id=eae.apply_evaluate_id " +
                "where 1=1 ");
        if(name!=null&&!name.equals("")){
            sql.append("and aeb.enterprise_name='"+name+"' ");
        }
        if(date!=null&&!date.equals("")){
            sql.append("and date_format(eae.create_time,'%Y-%c-%d')='"+date+"' ");
        }
        if(level!=null&&!level.equals("")){
            sql.append("and esr.level='"+level+"' ");
        }
        if(auditStatus!=null&&!auditStatus.equals("")){
            sql.append("and eae.audit_status='"+auditStatus+"' ");
        }
        sql.append(" and eae.auth_org_id='"+authOrgId+"' ");
        return sqlqueryForpage1(sql.toString(), param, PageContext.getPageSize(), PageContext.getOffSet(), orderby);
    }
    /**
     * 查询组织所有的各审核状态数量
     *
     * */
    public Object queryApplyEvaluateByAuditStatusForCount(String authOrgId,String auditStatus){
        StringBuffer sql = new StringBuffer();
        sql.append("select count(apply_evaluate_id) count from eva_apply_evaluate where 1=1 and auth_org_id='"+authOrgId+"' and audit_status='"+auditStatus+"' ");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List list=query.list();
        if(list==null||list.size()==0){
            return null;
        }
        return list.get(0);
    }
    /**
     * 根据组织Id查询已完成的请求
     * */
    public List queryApplyEvaluateByAuthOrgId(String authOrgId){
        StringBuffer sql = new StringBuffer();
        sql.append("select * from eva_apply_evaluate where 1=1 and auth_org_id='"+authOrgId+"' and audit_status=4 ");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }
    /**
     * 添加评价批语
     * */
    public void updateApplyEvaluateForRemarks(String applyEvaluateId,String title,String remarks){
        StringBuffer sql = new StringBuffer();
        sql.append("update eva_apply_evaluate set title='"+title+"',remarks='"+remarks+"' where apply_evaluate_id='"+applyEvaluateId+"' ");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        query.executeUpdate();
    }
    /**
     * 查询企业的所有请求
     * */
    public Page queryApplyEvaluateByAuthEnterpriseId(String authEnterpriseId,String date,String level){
        Map<String, Object> param = new HashMap<String, Object>();
        StringBuffer sql = new StringBuffer();
        LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
        sql.append("select eae.apply_evaluate_id,eae.audit_status,eae.title,eae.remarks,esr.level,aob.organization_name from eva_apply_evaluate eae " +
                "left join eva_score_result esr on esr.apply_evaluate_id=eae.apply_evaluate_id " +
                "left join auth_org_base aob on aob.auth_org_id=eae.auth_org_id " +
                "where 1=1 and eae.auth_enterprise_id='"+authEnterpriseId+"' and audit_status in ('1','2','3','4')");
        if(date!=null&&!date.equals("")){
            sql.append("and date_format(eae.create_time,'%Y-%c-%d')='"+date+"' ");
        }
        if(level!=null&&!level.equals("")){
            sql.append("and esr.level='"+level+"' ");
        }
        sql.append(" order by eae.create_time desc");
        return sqlqueryForpage1(sql.toString(), param, PageContext.getPageSize(), PageContext.getOffSet(), orderby);
    }
    /**
     * 查询企业的所有可申诉请求（评价已完成）
     * */
    public Page queryApplyEvaluateByAuthEnterpriseIdForAppeal(String authEnterpriseId,String date,String level){
        Map<String, Object> param = new HashMap<String, Object>();
        StringBuffer sql = new StringBuffer();
        LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
        sql.append("select eae.create_time,eae.apply_evaluate_id,eae.audit_status,eae.title,eae.remarks,esr.level,aob.organization_name from eva_apply_evaluate eae " +
                "left join eva_score_result esr on esr.apply_evaluate_id=eae.apply_evaluate_id " +
                "left join auth_org_base aob on aob.auth_org_id=eae.auth_org_id " +
                "where 1=1 and eae.auth_enterprise_id='"+authEnterpriseId+"' and audit_status=4 or appeal_status is null and appeal_status not in('1','2','4','3') ");
        if(date!=null&&!date.equals("")){
            sql.append(" and date_format(eae.create_time,'%Y-%c-%d')='"+date+"' ");
        }
        if(level!=null&&!level.equals("")){
            sql.append(" and esr.level='"+level+"' ");
        }
        sql.append(" order by eae.create_time desc");
        return sqlqueryForpage1(sql.toString(), param, PageContext.getPageSize(), PageContext.getOffSet(), orderby);
    }
    /**
     * 修改申诉状态
     * */
    public void updateApplyEvaluateForAppealStatus(String applyEvaluateId,String appealStatus){
        StringBuffer sql = new StringBuffer();
        sql.append("update eva_apply_evaluate set appeal_status='"+appealStatus+"' where apply_evaluate_id='"+applyEvaluateId+"' ");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        query.executeUpdate();
    }

    /**
     * 申请评价关系表findEntAuthIdByOrgAuthId
     * 根据组织ID查询所有有关联的企业ID
     */
    public List findEntAuthIdByOrgAuthId(String authOrgId) {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT applyEvaluate.auth_enterprise_id FROM eva_apply_evaluate applyEvaluate WHERE 1=1 AND applyEvaluate.isDelete = '0'");
        sql.append(" AND applyEvaluate.auth_org_id = '" + authOrgId + "' ");
        sql.append(" AND apply_status in('2','4')");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }
    /**
     * 根据申请Id查询所有申请信息
     * */
    public ApplyEvaluate queryApplyEvaluateByApplyEvaluateId(String applyEvaluateId){
        StringBuffer sql = new StringBuffer();
        sql.append("select * from eva_apply_evaluate where 1=1 and apply_evaluate_id='"+applyEvaluateId+"' ");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List list=query.list();
        if(list==null||list.size()==0){
            return null;
        }
        ApplyEvaluate ae=(ApplyEvaluate)MapTrunPojo.map2Object((Map)list.get(0),ApplyEvaluate.class);
        return ae;
    }
    /**
     * 根据组织跟企业ID查询请求
     * */
    public ApplyEvaluate queryApplyEvaluate(String authEnterpriseId,String authOrgId){
        StringBuffer sql = new StringBuffer();
        sql.append("select * from eva_apply_evaluate where 1=1 and auth_enterprise_id='"+authEnterpriseId+"' and auth_org_id='"+authOrgId+"' ");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List list=query.list();
        if(list==null||list.size()==0){
            return null;
        }
        ApplyEvaluate ae=(ApplyEvaluate)MapTrunPojo.map2Object((Map)list.get(0),ApplyEvaluate.class);
        return ae;
    }

}