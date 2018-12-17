package jll.bad_information.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.bad_information.CourtSessionNotice;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourtSessionNoticeDao extends SimpleHibernateTemplate<CourtSessionNotice> {

    private static final long serialVersionUID = 1L;
    /**
     *entId企业ID
     * 查询开庭公告信息
     * */
    public List queryCourtSessionNotice(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append(" select ecsn.* from ent_court_session_notice ecsn where 1=1 and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }

    /**
     * 添加开庭公告信息
     * */
    public void saveCourtSessionNotice(CourtSessionNotice courtSessionNotice){
        if(courtSessionNotice.getCourt_session_notice_id()!=null&&!courtSessionNotice.getCourt_session_notice_id().equals("")){
            this.getSession().saveOrUpdate(courtSessionNotice);
        }else{
            this.getSession().save(courtSessionNotice);
        }
    }

}
