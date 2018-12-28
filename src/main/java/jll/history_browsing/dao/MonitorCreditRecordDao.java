package jll.history_browsing.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.history_browsing.MonitorCreditRecord;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MonitorCreditRecordDao extends SimpleHibernateTemplate<MonitorCreditRecord> {

    /**
     * 查看良好(或不良)信用记录
     */
    public List findMonitorCreditRecordList(String userId){
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT * FROM org_monitor_credit_redord WHERE 1=1 AND isDelete= '1' AND user_id = '" + userId + "'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }

}
