package jll.history_browsing.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import com.cn.zyzs.hibernate.util.Page;
import com.cn.zyzs.hibernate.util.PageContext;
import org.springframework.stereotype.Repository;

//监控关注的sql
@Repository
public class MonitorFollowDao extends SimpleHibernateTemplate<Object> {

    /**
     * 查看我的监控中的不良信息列表,良好信息列表,新闻舆情列表或者查看我的关注
     * userId用户ID
     * type 1监控 2关注
     * behavior_classification 行为分类 1不良 2良好  3新闻舆情
     */
    public Page findMonitorFollowList(String userId, String type, String behaviorClassification){
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT c.*,e.company_name FROM ");
        sql.append(" (SELECT b.* FROM (SELECT ent_id,max(create_time) m FROM org_monitor_credit_record WHERE date_sub(CURDATE(),interval 7 DAY) <= create_time GROUP BY ent_id) a,org_monitor_credit_record b where a.ent_id = b.ent_id and a.m = b.create_time GROUP BY ent_id) c,ent_basics e,org_monitoring_concern omc ");
        sql.append(" WHERE c.ent_id = e.ent_id AND omc.ent_id = c.ent_id AND omc.user_id = '" + userId + "' AND omc.type = '" + type + "'");
        if(behaviorClassification !=null && !"".equals(behaviorClassification)){
            sql.append( "AND c.behavior_classification = '" + behaviorClassification + "'");
        }
        return sqlqueryForpage1(sql.toString(), null, PageContext.getPageSize(), PageContext.getOffSet(), null);
    }

    /**
     * 查看我的监控中的未变化的企业最近的动态
     */
    public Page findMonitorUnchangedList(String userId){
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT omcr.*,e.company_name  FROM org_monitor_credit_record omcr,ent_basics e,org_monitoring_concern omc WHERE omcr.create_time = (select max(create_time) from org_monitor_credit_record where ent_id = omcr.ent_id) and omcr.ent_id not in " +
                "(SELECT b.ent_id FROM (SELECT ent_id,max(create_time) m FROM org_monitor_credit_record WHERE date_sub(CURDATE(),interval 7 DAY) <= create_time GROUP BY ent_id) a,org_monitor_credit_record b where a.ent_id = b.ent_id and a.m = b.create_time GROUP BY ent_id ) " +
                "AND omcr.ent_id = e.ent_id AND omc.ent_id = omcr.ent_id AND omc.user_id = '" + userId + "' AND omc.type = '1' ");
        //sql.append("AND (omcr.behavior_classification = '1'  or omcr.behavior_classification = '2' or omcr.behavior_classification = '3')");
        return sqlqueryForpage1(sql.toString(), null, PageContext.getPageSize(), PageContext.getOffSet(), null);
    }

    /**
     * 查看我的监控中的未认证的企业数据
     */
    public Page findMonitorUncertified(String userId){
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT entBasics.* FROM org_monitoring_concern o,ent_basics entBasics WHERE o.ent_id = entBasics.ent_id AND o.ent_id not in " +
                " (SELECT e.ent_id FROM auth_enterprise_base auth, org_monitoring_concern omc,ent_basics e where omc.ent_id = e.ent_id AND auth.social_credit_code = e.unified_social_credit_code AND omc.user_id = '" + userId + "') AND o.user_id = '" +userId + "'" );
        return sqlqueryForpage1(sql.toString(), null, PageContext.getPageSize(), PageContext.getOffSet(), null);
    }

}
