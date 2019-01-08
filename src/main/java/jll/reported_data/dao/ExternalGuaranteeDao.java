package jll.reported_data.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.basic_pnformation_submit.ExternalGuaranteeInformation;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ExternalGuaranteeDao extends SimpleHibernateTemplate<ExternalGuaranteeInformation> {
    /**
     * 增加对外担保信息
     */
    public void addExternalGuarantee(ExternalGuaranteeInformation externalGuaranteeInformation){
        System.out.println("执行股权投资!");
        this.getSession().merge(externalGuaranteeInformation);
    }



    /**
     * 查询对外担保信息
     */
    public List queryExternalGuarantee(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append("select * from ent_external_guarantee where 1=1 and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }
}
