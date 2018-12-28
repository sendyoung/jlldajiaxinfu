package jll.account_authentication.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.Industry;
import jll.utils.MapTrunPojo;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 行业信息
 */
@Repository
public class IndustryDao extends SimpleHibernateTemplate<Industry> {

    /**
     * 查询行业
     */
    public List<Industry> queryIndustryByLength(Integer length){
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT code,description FROM public_industry WHERE length(code)="+length+" order by code");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List<Industry>list=new ArrayList<Industry>();
        List l=query.list();
        for(int i=0;i<l.size();i++){
            Industry industry=(Industry)MapTrunPojo.map2Object((Map)l.get(i),Industry.class);
            list.add(industry);
        }
        return list;
    }

}
