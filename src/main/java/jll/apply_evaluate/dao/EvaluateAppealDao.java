package jll.apply_evaluate.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import com.cn.zyzs.hibernate.util.Page;
import com.cn.zyzs.utils.utils.PageContext;
import jll.model.apply_evaluate.EvaluateAppeal;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

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
            this.getSession().save(evaluateAppeal);
        }
    }
    /**
     * 查询历史申诉
     * */
    public Page queryEvaluateAppealHistory(String applyEvaluateId,String appealStype,String appealCreateTime, String appealStatus){
        Map<String, Object> param = new HashMap<String, Object>();
        StringBuffer sql = new StringBuffer();
        LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
        sql.append("select eae.apply_evaluate_id,eae.remarks,aob.organization_name,eea.create_time,eea.appeal_title,eea.details " +
                "from eva_apply_evaluate eae " +
                "left join eva_evaluate_appeal eea on eea.apply_evaluate_id=eae.apply_evaluate_id " +
                "left join auth_org_base aob on aob.auth_org_id=eae.auth_org_id " +
                "where 1=1 and eae.appeal_status in ('1','2','3','4') and eae.auth_enterprise_id=14555");

        sql.append(" order by eea.create_time desc");
        return sqlqueryForpage1(sql.toString(), param, PageContext.getPageSize(), PageContext.getOffSet(), orderby);
    }

}
