package jll.reportedData.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.BasicPnformationSubmit.SoftwareCopyright;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class SoftwareCopyrightDao extends SimpleHibernateTemplate<SoftwareCopyright> {
    /**
     * 增加软件著作权
     */
    public void addSoftwareCopyright(SoftwareCopyright softwareCopyright){
        System.out.println("执行软件著作权dao层!");
        this.getSession().merge(softwareCopyright);
    }

    /**
     * 查询软件著作权
     */
    public List querySoftwareCopyright(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append("select * from ent_software_copyright where 1=1 and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();

    }

}
