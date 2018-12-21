package jll.apply_evaluate.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.apply_evaluate.RedBlackListDetails;
import org.springframework.stereotype.Repository;

@Repository
public class RedBlackListDetailsDao extends SimpleHibernateTemplate<RedBlackListDetails> {
    private static final long serialVersionUID = 1L;
    /**
     * 生成评价榜单结果
     * */
    public void saveRedBlackListDetails(RedBlackListDetails redBlackListDetails){
        this.getSession().save(redBlackListDetails);
    }
}
