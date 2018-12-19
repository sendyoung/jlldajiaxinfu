package jll.apply_evaluate.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.apply_evaluate.EvaluateListDetails;
import org.springframework.stereotype.Repository;

@Repository
public class EvaluateListDetailsDao extends SimpleHibernateTemplate<EvaluateListDetails> {
    private static final long serialVersionUID = 1L;
    /**
     * 生成评价榜单结果
     * */
    public void saveEvaluateListDetails(EvaluateListDetails evaluateListDetails){
        this.getSession().save(evaluateListDetails);
    }

}
