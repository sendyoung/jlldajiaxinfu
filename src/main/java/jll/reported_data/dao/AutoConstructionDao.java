package jll.reported_data.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.BasicPnformationSubmit.AutomationConstruction;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AutoConstructionDao extends SimpleHibernateTemplate<AutomationConstruction> {

    /**
     * 增加自动化建设信息
     */
    public void addAutoConstruction(AutomationConstruction automationConstruction){
        System.out.println("执行增加自动化建设信息dao层!");
        this.getSession().merge(automationConstruction);
    }

    /**
     * 查询自动化建设信息
     */
    public List queryAutoConstruction(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append("select * from ent_automation_construction where 1=1 and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();

    }

}
