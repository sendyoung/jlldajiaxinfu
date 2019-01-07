package jll.good_information.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import com.cn.zyzs.hibernate.util.Page;
import com.cn.zyzs.utils.utils.PageContext;
import jll.model.Statistics;
import jll.model.good_information.OthersCertificate;
import jll.utils.MapTrunPojo;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
     * 分页查询其他证书信息
     * */
    public Page queryOthersCertificateForPage(String entId){
        Map<String, Object> param = new HashMap<String, Object>();
        StringBuffer sql = new StringBuffer();
        LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
        sql.append(" select eoc.* from ent_others_certificate eoc where 1=1 and ent_id='"+entId+"'");
        return sqlqueryForpage1(sql.toString(), param, PageContext.getPageSize(), PageContext.getOffSet(), orderby);
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
    /**
     * 企业其他证书统计数量
     * */
    public BigInteger queryOthersCertificateForCount(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append(" select count(*) count from ent_others_certificate where 1=1 and ent_id='"+entId+"'");
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
