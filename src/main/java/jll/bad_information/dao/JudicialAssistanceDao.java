package jll.bad_information.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.bad_information.JudicialAssistance;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JudicialAssistanceDao extends SimpleHibernateTemplate<JudicialAssistance> {

    private static final long serialVersionUID = 1L;
    /**
     *entId企业ID
     * 查询司法协助信息
     * */
    public List queryJudicialAssistance(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append(" select eja.* from ent_judicial_assistance eja where 1=1 and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }

    /**
     * 添加司法协助信息
     * */
    public void saveJudicialAssistance(JudicialAssistance judicialAssistance){
        if(judicialAssistance.getJudicial_assistance_id()!=null&&!judicialAssistance.getJudicial_assistance_id().equals("")){
            this.getSession().saveOrUpdate(judicialAssistance);
        }else{
            this.getSession().save(judicialAssistance);
        }
    }

}
