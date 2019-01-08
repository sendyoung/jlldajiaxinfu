package jll.reported_data.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.basic_pnformation_submit.SharePledgeRegistration;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EquityRegistrationDao extends SimpleHibernateTemplate<SharePledgeRegistration> {
    /**
     * 增加股权出质登记信息
     */
    public void addEquityRegistration(SharePledgeRegistration sharePledgeRegistration){
        System.out.println("执行股权投资!");
        this.getSession().merge(sharePledgeRegistration);
    }


    /**
     * 查询股权出质登记信息
     */
    public List queryEquityRegistration(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append("select * from ent_share_pledge_registration where 1=1 and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }
}
