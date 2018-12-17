package jll.bad_information.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.bad_information.AdministrativeSanction;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdministrativeSanctionDao extends SimpleHibernateTemplate<AdministrativeSanction> {

    private static final long serialVersionUID = 1L;
    /**
     *entId企业ID
     * 查询经营异常信息
     * */
    public List queryAdministrativeSanction(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append(" select eas.* from ent_administrative_sanction eas where 1=1 and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }

    /**
     * 添加经营异常信息
     * */
    public void saveAdministrativeSanction(AdministrativeSanction administrativeSanction){
        if(administrativeSanction.getAdministrative_sanction_id()!=null&&!administrativeSanction.getAdministrative_sanction_id().equals("")){
            this.getSession().saveOrUpdate(administrativeSanction);
        }else{
            this.getSession().save(administrativeSanction);
        }
    }

}
