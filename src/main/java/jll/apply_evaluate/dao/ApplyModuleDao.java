package jll.apply_evaluate.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.apply_evaluate.ApplyModule;
import jll.utils.MapTrunPojo;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ApplyModuleDao extends SimpleHibernateTemplate<ApplyModule> {
    private static final long serialVersionUID = 1L;

    /**
     * 添加申请模块
     * */
    public void saveApplyModule(ApplyModule applyModule){
        this.getSession().save(applyModule);
    }
    /**
     * 根据请求ID查询模块
     * */
    public List queryApplyModuleByApplyEvaluateId(String applyEvaluateId){
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT eam.apply_module_id,eam.status,eam.apply_permission_id,eap.name from eva_apply_module eam left join eva_apply_permission eap" +
                " on eam.apply_permission_id=eap.apply_permission_id where 1=1 and eam.apply_permission_id!=8 and eam.apply_evaluate_id='"+applyEvaluateId+"' ");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }
    /**
     * 根据请求ID查询模块
     * */
    public List queryApplyModuleByApplyEvaluateIdForAll(String applyEvaluateId){
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT eam.apply_module_id,eam.status,eam.apply_permission_id,eap.name from eva_apply_module eam left join eva_apply_permission eap" +
                " on eam.apply_permission_id=eap.apply_permission_id where 1=1 and eam.apply_evaluate_id='"+applyEvaluateId+"' ");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }
    /**
     * 修改模块状态
     * */
    public void updateApplyModuleForStatus(String applyModuleId,String status,String remarks){
        StringBuffer sql = new StringBuffer();
        sql.append("update eva_apply_module set status='"+status+"' ");
        if(remarks!=null){
            sql.append(",remarks='"+remarks+"' ");
        }
        sql.append(" where apply_module_id='"+applyModuleId+"' ");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        query.executeUpdate();
    }
    /**
     * 查询所有同请求的模块
     * */
    public List queryApplyModuleByApplyModuleId(String applyModuleId){
        StringBuffer sql = new StringBuffer();
        sql.append("select * from eva_apply_module where 1=1 and apply_permission_id!=8 and apply_evaluate_id=(select apply_evaluate_id from eva_apply_module where apply_module_id='"+applyModuleId+"') ");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }
    /**
     * 根据模块ID查询模块详情
     * */
    public ApplyModule queryApplyModuleDetailByApplyModuleId(String applyModuleId){
        StringBuffer sql = new StringBuffer();
        sql.append("select * from eva_apply_module where 1=1 and apply_module_id='"+applyModuleId+"' ");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List list=query.list();
        if(list==null||list.size()==0){
            return null;
        }
        ApplyModule am=(ApplyModule)MapTrunPojo.map2Object((Map)list.get(0),ApplyModule.class);
        return am;
    }
}
