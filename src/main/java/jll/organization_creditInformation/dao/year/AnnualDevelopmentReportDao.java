package jll.organization_creditInformation.dao.year;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 年度发展报告
 */
@Repository
public class AnnualDevelopmentReportDao extends SimpleHibernateTemplate<Object> {

    /**
     * 添加
     */



    /**
     * 查询回显
     */
    public List queryAnnualDevelopmentReport(String auth_org_id){


        StringBuffer sq = new StringBuffer();
        sq.append("select * from org_annual_development_report where 1=1 and auth_org_id='"+auth_org_id+"'");
        Query query = this.getSession().createSQLQuery(sq.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        System.out.println("打印年度发展报告查询出来的结果:"+query.list());

        return query.list();
    }

}
