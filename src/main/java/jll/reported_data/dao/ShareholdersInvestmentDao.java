package jll.reported_data.dao;


import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import com.cn.zyzs.hibernate.util.Page;
import com.cn.zyzs.utils.utils.PageContext;
import jll.model.basic_pnformation_submit.ShareholderContributionInfo;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
    /**
     * 分页查询股东出资信息
     * */
    public Page queryShareholdersInvestmentForPage(String entId){
        Map<String, Object> param = new HashMap<String, Object>();
        StringBuffer sql = new StringBuffer();
        LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
        sql.append("select * from ent_shareholder_contribution where 1=1 and ent_id='"+entId+"'");
        return sqlqueryForpage1(sql.toString(), param, PageContext.getPageSize(), PageContext.getOffSet(), orderby);
    }

}
