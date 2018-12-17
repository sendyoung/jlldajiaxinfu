package jll.bad_information.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.bad_information.Contravention;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContraventionDao extends SimpleHibernateTemplate<Contravention> {

    private static final long serialVersionUID = 1L;
    /**
     *entId企业ID
     * 查询欠税公告信息
     * */
    public List queryContravention(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append(" select ec.* from ent_contravention ec where 1=1 and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }

    /**
     * 添加欠税公告信息
     * */
    public void saveContravention(Contravention contravention){
        if(contravention.getContravention_id()!=null&&!contravention.getContravention_id().equals("")){
            this.getSession().saveOrUpdate(contravention);
        }else{
            this.getSession().save(contravention);
        }
    }

}
