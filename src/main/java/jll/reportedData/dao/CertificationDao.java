package jll.reportedData.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.BasicPnformationSubmit.QualificationAuthentication;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CertificationDao extends SimpleHibernateTemplate<QualificationAuthentication> {

    /**
     * 增加资质认证
     */
    public void addCertification(QualificationAuthentication qualificationAuthentication){
        System.out.println("执行增加自动化建设信息dao层!");
        this.getSession().merge(qualificationAuthentication);
    }

    /**
     * 查询资质认证
     */
    public List queryCertification(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append("select * from ent_aptitudes_authentication where 1=1 and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();

    }
}
