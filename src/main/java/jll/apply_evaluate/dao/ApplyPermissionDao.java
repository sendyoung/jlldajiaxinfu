package jll.apply_evaluate.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.apply_evaluate.ApplyModule;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ApplyPermissionDao extends SimpleHibernateTemplate<ApplyModule> {
    private static final long serialVersionUID = 1L;

    /**
     * 查询所有申请模块
     * */
    public List queryApplyPermission(){
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT eap.apply_permission_id,eap.name from eva_apply_permission eap where eap.parent_id=0");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }

}
