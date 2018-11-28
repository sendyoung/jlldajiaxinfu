package jll.goog_information.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.PublicWelfareActivity;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class PublicWelfareActivityDao extends SimpleHibernateTemplate<PublicWelfareActivity> {
    private static final long serialVersionUID = 1L;
    /**
     *entId企业ID
     * 查询公益信息
     * */
    public List queryPublicWelfareActivity(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append(" select epwa.* from ent_public_welfare_activity epwa where 1=1 and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }

    /**
     * 添加公益信息
     * */
    public void savePublicWelfareActivity(PublicWelfareActivity pwa){
        this.getSession().saveOrUpdate(pwa);
    }
}
