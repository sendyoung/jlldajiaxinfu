package jll.apply_evaluate.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import com.cn.zyzs.hibernate.util.Page;
import com.cn.zyzs.utils.utils.PageContext;
import jll.model.apply_evaluate.EvaluateListDetails;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Repository
public class EvaluateListDetailsDao extends SimpleHibernateTemplate<EvaluateListDetails> {
    private static final long serialVersionUID = 1L;
    /**
     * 生成评价榜单结果
     * */
    public void saveEvaluateListDetails(EvaluateListDetails evaluateListDetails){
        evaluateListDetails.setIsDelete("0");
        evaluateListDetails.setCreate_time(new Date());
        this.getSession().save(evaluateListDetails);
    }
    /**
     * 根据榜单ID查询详情
     * */
    public Page queryEvaluateListDetailsByEvaluateListId(String evaluateListId){
        Map<String, Object> param = new HashMap<String, Object>();
        StringBuffer sql = new StringBuffer();
        LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
        sql.append("SELECT " +
                " aeb.enterprise_name,esr.score,esr.level,eae.apply_evaluate_id " +
                " FROM " +
                " eva_evaluate_list_details eeld " +
                " LEFT JOIN eva_apply_evaluate eae ON eae.apply_evaluate_id = eeld.apply_evaluate_id " +
                " LEFT JOIN eva_score_result esr ON esr.apply_evaluate_id = eae.apply_evaluate_id " +
                " LEFT JOIN auth_enterprise_base aeb ON aeb.auth_enterprise_id = eae.auth_enterprise_id " +
                " where eeld.evaluate_list_id='"+evaluateListId+"' ");
        return sqlqueryForpage1(sql.toString(), param, PageContext.getPageSize(), PageContext.getOffSet(), orderby);
    }
}
