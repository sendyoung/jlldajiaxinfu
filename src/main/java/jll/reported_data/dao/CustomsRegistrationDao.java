package jll.reported_data.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.basic_pnformation_submit.CustomsRegistrationInformation;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CustomsRegistrationDao extends SimpleHibernateTemplate<CustomsRegistrationInformation> {
    /**
     * 增加海关注册信息
     */
    public void addCustomsRegistration(CustomsRegistrationInformation customsRegistrationInformation){
        System.out.println("执行增主体增加信用记录!");
        this.getSession().merge(customsRegistrationInformation);
    }


    /**
     * 查询海关注册信息
     */
    public List queryCustomsRegistration(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append("select * from ent_customs_registration where 1=1 and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }
}
