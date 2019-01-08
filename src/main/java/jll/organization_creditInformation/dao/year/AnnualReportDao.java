package jll.organization_creditInformation.dao.year;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.org_organization.AnnualReport;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 组织年报
 */
@Repository
public class AnnualReportDao extends SimpleHibernateTemplate<Object> {
    /**
     * 添加 组织年报
     */
    public void addAnnualReport(AnnualReport annualReport){
        this.getSession().merge(annualReport);
    }


    /**
     * 查询回显
     */
    public List queryAnnualReport(String auth_org_id){


        StringBuffer sq = new StringBuffer();
        sq.append("select * from org_annual_report where 1=1 and auth_org_id='"+auth_org_id+"'");
        Query query = this.getSession().createSQLQuery(sq.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        System.out.println("打印组织年报查询出来的结果:"+query.list());

        return query.list();
    }
}
