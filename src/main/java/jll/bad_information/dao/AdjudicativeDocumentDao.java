package jll.bad_information.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.Statistics;
import jll.model.bad_information.AdjudicativeDocument;
import jll.utils.MapTrunPojo;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@Repository
public class AdjudicativeDocumentDao extends SimpleHibernateTemplate<AdjudicativeDocument> {

    private static final long serialVersionUID = 1L;
    /**
     *entId企业ID
     * 查询裁判文书信息
     * */
    public List queryAdjudicativeDocument(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append(" select ead.* from ent_adjudicative_document ead where 1=1 and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }

    /**
     * 添加裁判文书信息
     * */
    public void saveAdjudicativeDocument(AdjudicativeDocument adjudicativeDocument){
        if(adjudicativeDocument.getAdjudicative_document_id()!=null&&!adjudicativeDocument.getAdjudicative_document_id().equals("")){
            this.getSession().saveOrUpdate(adjudicativeDocument);
        }else{
            this.getSession().save(adjudicativeDocument);
        }
    }
    /**
     * 企业裁判文书统计数量
     * */
    public BigInteger queryAdjudicativeDocumentForCount(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append(" select count(*) count from ent_adjudicative_document where 1=1 and ent_id='"+entId+"'");
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
