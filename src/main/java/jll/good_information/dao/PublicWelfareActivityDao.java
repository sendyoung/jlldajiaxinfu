package jll.good_information.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import com.cn.zyzs.hibernate.util.Page;
import com.cn.zyzs.utils.utils.PageContext;
import jll.model.Statistics;
import jll.model.good_information.PublicWelfareActivity;
import jll.utils.MapTrunPojo;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PublicWelfareActivityDao extends SimpleHibernateTemplate<PublicWelfareActivity> {
    private static final long serialVersionUID = 1L;
    /**
     *entId企业ID
     * 查询公益信息
     * */
    public List queryPublicWelfareActivity(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append(" select epwa.* from ent_public_welfare_activity epwa where 1=1 and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }
    /**
     * 分页查询其他证书信息
     * */
    public Page queryPublicWelfareActivityForPage(String entId){
        Map<String, Object> param = new HashMap<String, Object>();
        StringBuffer sql = new StringBuffer();
        LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
        sql.append(" select epwa.* from ent_public_welfare_activity epwa where 1=1 and ent_id='"+entId+"'");
        return sqlqueryForpage1(sql.toString(), param, PageContext.getPageSize(), PageContext.getOffSet(), orderby);
    }
    /**
     * 添加公益信息
     * */
    public void savePublicWelfareActivity(PublicWelfareActivity pwa){
        if(pwa.getPublic_welfare_activity_id()!=null&&!pwa.getPublic_welfare_activity_id().equals("")){
            this.getSession().saveOrUpdate(pwa);
        }else{
            this.getSession().save(pwa);
        }
    }
    /**
     * 企业行业基础建设统计数量
     * */
    public BigInteger queryPublicWelfareActivityForCount(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append(" select count(*) count from ent_public_welfare_activity where 1=1 and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List list=query.list();
        if(list==null||list.size()==0){
            return null;
        }
        Statistics statistics=(Statistics) MapTrunPojo.map2Object((Map)list.get(0),Statistics.class);
        return statistics.getCount();
    }

}
