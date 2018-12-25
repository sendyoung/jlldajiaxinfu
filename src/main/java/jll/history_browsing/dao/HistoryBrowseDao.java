package jll.history_browsing.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import com.cn.zyzs.hibernate.util.Page;
import com.cn.zyzs.hibernate.util.PageContext;
import jll.model.history_browsing.HistoryBrowsing;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public class HistoryBrowseDao extends SimpleHibernateTemplate<HistoryBrowsing> {

    /**
     * 添加浏览记录
     */
    public void addHistoryBrowsing(HistoryBrowsing historyBrowsing){
        StringBuffer sql = new StringBuffer();
        sql.append("INSERT INTO org_history_browse_records(browse_id,user_id,ent_id,ent_name,create_time)  ");
        sql.append(" VALUES('" + UUID.randomUUID().toString().replace("-","") + "','" + historyBrowsing.getUser_id() + "','" + historyBrowsing.getEnt_id() + "','" + historyBrowsing.getEnt_name() + "',now())" );
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.executeUpdate();
    }

    /**
     * 查看浏览记录列表
     */
    public Page findHistoryList(String userId){
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT browse_id,user_id,ent_id,ent_name,create_time FROM org_history_browse_records WHERE 1=1 AND isDelete = '1' AND user_id = '" + userId + "' ORDER BY create_time DESC");
        return sqlqueryForpage1(sql.toString(), null, PageContext.getPageSize(), PageContext.getOffSet(), null);
    }
}
