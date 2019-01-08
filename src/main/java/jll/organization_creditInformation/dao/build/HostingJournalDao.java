package jll.organization_creditInformation.dao.build;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.org_organization.HostingJournal;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 主办期刊
 */
@Repository
public class HostingJournalDao extends SimpleHibernateTemplate<Object> {


    /**
     * 添加 主办期刊
     */
    public void addHostingJournal(HostingJournal hostingJournal){
        this.getSession().merge(hostingJournal);
    }


    /**
     * 查询  主办期刊
     */
    public List queryHostingJournal(String auth_org_id){
        StringBuffer sq = new StringBuffer();
        sq.append("select * from org_hosting_journal where 1=1 and auth_org_id='"+auth_org_id+"'");
        Query query = this.getSession().createSQLQuery(sq.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        System.out.println("打印主办期刊 查询出来的结果:"+query.list());

        return query.list();
    }






}
