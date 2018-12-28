package jll.reportedData.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.BasicPnformationSubmit.ActualController;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class TheActualControllerDao extends SimpleHibernateTemplate<ActualController> {
    /**
     * 添加实际控制人填报
     */
    public void addTheActualController(ActualController actualController){
        System.out.println("执行纳税评级dao层!");
        this.getSession().merge(actualController);
    }

    /**
     * 查询实际控制人填报
     */
    public List queryTheActualController(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append("select * from ent_actual_controller where 1=1 and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();

    }



}
