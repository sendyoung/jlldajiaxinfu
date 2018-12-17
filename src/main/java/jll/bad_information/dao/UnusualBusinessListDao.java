package jll.bad_information.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.bad_information.UnusualBusinessList;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UnusualBusinessListDao extends SimpleHibernateTemplate<UnusualBusinessList> {

    private static final long serialVersionUID = 1L;
    /**
     *entId企业ID
     * 查询经营异常信息
     * */
    public List queryUnusualBusinessList(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append(" select eubl.* from ent_unusual_business_list eubl where 1=1 and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }

    /**
     * 添加经营异常信息
     * */
    public void saveUnusualBusinessList(UnusualBusinessList unusualBusinessList){
        if(unusualBusinessList.getUnusual_business_list_id()!=null&&!unusualBusinessList.getUnusual_business_list_id().equals("")){
            this.getSession().saveOrUpdate(unusualBusinessList);
        }else{
            this.getSession().save(unusualBusinessList);
        }
    }

}
