package jll.bad_information.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import com.cn.zyzs.hibernate.util.Page;
import com.cn.zyzs.utils.utils.PageContext;
import jll.model.Statistics;
import jll.model.bad_information.Contravention;
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
public class ContraventionDao extends SimpleHibernateTemplate<Contravention> {

    private static final long serialVersionUID = 1L;
    /**
     *entId企业ID
     * 查询欠税公告信息
     * */
    public List queryContravention(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append(" select ec.* from ent_contravention ec where 1=1 and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }
    /**
     * 分页查询欠税公告信息
     * */
    public Page queryContraventionForPage(String entId){
        Map<String, Object> param = new HashMap<String, Object>();
        StringBuffer sql = new StringBuffer();
        LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
        sql.append(" select ec.* from ent_contravention ec where 1=1 and ent_id='"+entId+"'");
        return sqlqueryForpage1(sql.toString(), param, PageContext.getPageSize(), PageContext.getOffSet(), orderby);
    }

    /**
     * 添加欠税公告信息
     * */
    public void saveContravention(Contravention contravention){
        if(contravention.getContravention_id()!=null&&!contravention.getContravention_id().equals("")){
            this.getSession().saveOrUpdate(contravention);
        }else{
            this.getSession().save(contravention);
        }
    }
    /**
     * 企业欠税公告统计数量
     * */
    public BigInteger queryContraventionForCount(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append(" select count(*) count from ent_contravention where 1=1 and ent_id='"+entId+"'");
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
