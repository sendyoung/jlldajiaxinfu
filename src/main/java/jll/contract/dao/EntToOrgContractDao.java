package jll.contract.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.contract.EntToOrgContract;
import org.springframework.stereotype.Repository;

@Repository
public class EntToOrgContractDao extends SimpleHibernateTemplate<EntToOrgContract> {
    private static final long serialVersionUID = 1L;
    /**
     * 添加合同
     * */
    public void saveEntToContract(EntToOrgContract entToOrgContract){
        this.getSession().save(entToOrgContract);
    }
}
