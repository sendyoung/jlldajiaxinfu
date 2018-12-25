package jll.reportedData.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.BasicPnformationSubmit.Check;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class SpotCheckDao extends SimpleHibernateTemplate<Check> {
    /**
     * 抽查检查信息
     */
    public void addSpotCheck(Check check){
        System.out.println("执行抽查检查信息dao层!");
        this.getSession().merge(check);
    }

    /**
     * 抽查检查信息
     */
    public List querySpotCheck(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append("select * from ent_check where 1=1 and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();

    }
}
