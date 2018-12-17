package jll.bad_information.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.bad_information.AdministrativePublishment;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdministrativePublishmentDao extends SimpleHibernateTemplate<AdministrativePublishment> {

    private static final long serialVersionUID = 1L;
    /**
     *entId企业ID
     * 查询行政处罚信息
     * */
    public List queryAdministrativePublishment(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append(" select eap.* from ent_administrative_publishment eap where 1=1 and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }

    /**
     * 添加经营异常信息
     * */
    public void saveAdministrativePublishment(AdministrativePublishment administrativePublishment){
        if(administrativePublishment.getAdministrative_publishment_id()!=null&&!administrativePublishment.getAdministrative_publishment_id().equals("")){
            this.getSession().saveOrUpdate(administrativePublishment);
        }else{
            this.getSession().save(administrativePublishment);
        }
    }

}
