package jll.good_information.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.Statistics;
import jll.model.good_information.IndustryInfrastructure;
import jll.utils.MapTrunPojo;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@Repository
public class IndustryInfrastructureDao extends SimpleHibernateTemplate<IndustryInfrastructure> {

    private static final long serialVersionUID = 1L;
    /**
     *entId企业ID
     * 查询行业基础建设信息
     * */
    public List queryIndustryInfrastructure(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append(" select eii.* from ent_industry_infrastructure eii where 1=1 and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }

    /**
     * 添加行业基础建设信息
     * */
    public void saveIndustryInfrastructure(IndustryInfrastructure industryInfrastructure){
        if(industryInfrastructure.getIndustry_infrastructure_id()!=null&&!industryInfrastructure.getIndustry_infrastructure_id().equals("")){
            this.getSession().saveOrUpdate(industryInfrastructure);
        }else{
            this.getSession().save(industryInfrastructure);
        }
    }
    /**
     * 企业行业基础建设统计数量
     * */
    public BigInteger queryIndustryInfrastructureForCount(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append(" select count(*) count from ent_industry_infrastructure where 1=1 and ent_id='"+entId+"'");
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
