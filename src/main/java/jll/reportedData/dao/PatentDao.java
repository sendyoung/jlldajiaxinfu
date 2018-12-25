package jll.reportedData.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.BasicPnformationSubmit.PatentInformation;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class PatentDao extends SimpleHibernateTemplate<PatentInformation> {
    /**
     * 增加专利信息
     */
    public void addPatent(PatentInformation patentInformation){
        System.out.println("执行专利信息");
        this.getSession().merge(patentInformation);
    }



    /**
     * 查询专利信息
     */
    public List queryPatent(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append("select * from ent_patent_information where 1=1 and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }
}
