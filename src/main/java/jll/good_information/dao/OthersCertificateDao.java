package jll.good_information.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.good_information.OthersCertificate;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OthersCertificateDao extends SimpleHibernateTemplate<OthersCertificate> {

    private static final long serialVersionUID = 1L;

    /**
     * entId企业ID
     * 查询其他证书信息
     * */
    public List queryOthersCertificate(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append(" select eoc.* from ent_others_certificate eoc where 1=1 and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }
    /**
     *
     * 添加修改其他证书信息
     * */
    public void saveOthersCertificate(OthersCertificate entity) {
        if(entity.getCertificate_id()!=null&&!entity.getCertificate_id().equals("")){
            this.getSession().saveOrUpdate(entity);
        }else{
            this.getSession().save(entity);
        }
    }
}
