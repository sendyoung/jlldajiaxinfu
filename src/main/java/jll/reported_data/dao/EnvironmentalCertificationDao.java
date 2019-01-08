package jll.reported_data.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.BasicPnformationSubmit.EnvironmentalProtectionSystemCertification;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EnvironmentalCertificationDao extends SimpleHibernateTemplate<EnvironmentalProtectionSystemCertification> {

    /**
     * 增加环保体系认证
     */
    public void addEnvironmentalCertification(EnvironmentalProtectionSystemCertification environmentalProtectionSystemCertification){
        System.out.println("执行债权投资!");
        this.getSession().merge(environmentalProtectionSystemCertification);
    }


    /**
     * 查询环保体系认证
     */
    public List queryEnvironmentalCertification(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append("select * from ent_system_certification where 1=1 and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }
}
