package jll.bad_information.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.Statistics;
import jll.model.bad_information.AdministrativePublishment;
import jll.utils.MapTrunPojo;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

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
     * 添加行政处罚信息
     * */
    public void saveAdministrativePublishment(AdministrativePublishment administrativePublishment){
        if(administrativePublishment.getAdministrative_publishment_id()!=null&&!administrativePublishment.getAdministrative_publishment_id().equals("")){
            this.getSession().saveOrUpdate(administrativePublishment);
        }else{
            this.getSession().save(administrativePublishment);
        }
    }
    /**
     * 企业行政处罚统计数量
     * */
    public BigInteger queryAdministrativePublishmentForCount(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append(" select count(*) count from ent_administrative_publishment where 1=1 and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List list=query.list();
        if(list==null||list.size()==0){
            return null;
        }
        Statistics statistics=(Statistics) MapTrunPojo.map2Object((Map)list.get(0),Statistics.class);
        return statistics.getCount();
    }

}
