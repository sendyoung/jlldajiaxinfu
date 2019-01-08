package jll.reported_data.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.BasicPnformationSubmit.AdministrativeLicensing;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class AdministrativeLicenseDao extends SimpleHibernateTemplate<AdministrativeLicensing> {

    /**
     * 增加行政许可信息
     */
    public void addAdministrativeLicense(AdministrativeLicensing administrativeLicensing){

        this.getSession().merge(administrativeLicensing);



    }

    /**
     * 查询行政许可信息
     */
    public List queryAdministrativeLicense(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append("select * from ent_administrative_licensing where 1=1 and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();

    }

}
