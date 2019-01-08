package jll.reported_data.dao;


import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.BasicPnformationSubmit.ShareholderContributionInfo;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShareholdersInvestmentDao extends SimpleHibernateTemplate<ShareholderContributionInfo> {

    /**
     * 增加股东出资信息
     */
    public void addShareholdersInvestment(ShareholderContributionInfo ent_shareholder_contribution){
        System.out.println("执行增加股东出资信息dao层!");
        this.getSession().merge(ent_shareholder_contribution);
    }

    /**
     * 查询股东出资信息
     */
    public List queryShareholdersInvestment(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append("select * from ent_shareholder_contribution where 1=1 and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();

    }

}
