package jll.reportedData.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.BasicPnformationSubmit.CopyrightInWorks;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class WorkCopyrightDao extends SimpleHibernateTemplate<CopyrightInWorks> {
    /**
     * 添加作品著作权 填报
     */
    public void addWorkCopyright(CopyrightInWorks copyrightInWorks){
        System.out.println("执行作品著作权dao层!");
        this.getSession().merge(copyrightInWorks);
    }

    /**
     * 查询作品著作权 填报
     */
    public List queryWorkCopyright(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append("select * from ent_copyright_works where 1=1 and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }
}
