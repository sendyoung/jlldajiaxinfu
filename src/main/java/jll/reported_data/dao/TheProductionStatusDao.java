package jll.reported_data.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.BasicPnformationSubmit.ProductionStatus;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class TheProductionStatusDao extends SimpleHibernateTemplate<ProductionStatus> {
    /**
     * 添加生产情况
     */
    public void addTheProductionStatus(ProductionStatus productionStatus){
        System.out.println("执行生产情况dao层!");
        this.getSession().merge(productionStatus);
    }

    /**
     * 查询生产情况
     */
    public List queryTheProductionStatus(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append("select * from ent_production_status where 1=1 and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }


}
