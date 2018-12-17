package jll.bad_information.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.bad_information.JudicialAuction;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JudicialAuctionDao extends SimpleHibernateTemplate<JudicialAuction> {

    private static final long serialVersionUID = 1L;
    /**
     *entId企业ID
     * 查询司法拍卖信息
     * */
    public List queryJudicialAuction(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append(" select eja.* from ent_judicial_auction eja where 1=1 and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }

    /**
     * 添加司法拍卖信息
     * */
    public void saveJudicialAuction(JudicialAuction judicialAuction){
        if(judicialAuction.getJudicial_auction_id()!=null&&!judicialAuction.getJudicial_auction_id().equals("")){
            this.getSession().saveOrUpdate(judicialAuction);
        }else{
            this.getSession().save(judicialAuction);
        }
    }

}
