package jll.history_browsing.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.history_browsing.MonitoringConcern;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class MonitoringConcernDao extends SimpleHibernateTemplate<MonitoringConcern> {

    /**
     * 添加监控或关注
     */
    public void addMonitoringConcern(MonitoringConcern monitoringConcern){
        StringBuffer sql = new StringBuffer();
        sql.append(" INSERT INTO org_monitoring_concern_list(monitoring_concern_id,user_id,ent_id,type) ");
        sql.append(" VALUES('" + UUID.randomUUID().toString().replace("-","") + "','" + monitoringConcern.getUser_id() + "','" + monitoringConcern.getEnt_id() + "','" + monitoringConcern.getType() + "' ");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.executeUpdate();
    }

    /**
     * 查询监控或关注的企业
     */
   /* public List findMonitoringConcern(String userId){
        return null;
    }*/


}
