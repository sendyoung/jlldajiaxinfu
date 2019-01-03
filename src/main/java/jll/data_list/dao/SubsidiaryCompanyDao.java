package jll.data_list.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.data_list.SubsidiaryCompany;
import jll.utils.MapTrunPojo;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class SubsidiaryCompanyDao extends SimpleHibernateTemplate<SubsidiaryCompany> {

    private static final long serialVersionUID = 1L;
    /**
     * name公司名称
     * 查询分公司信息
     * */
    public SubsidiaryCompany querySubsidiaryCompanyForName(String entId,String name){
        StringBuffer sql = new StringBuffer();
        sql.append(" select esc.* from ent_subsidiary_company esc where 1=1 and branch_name='"+name+"' and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List list=query.list();
        if(list==null||list.size()==0){
            return null;
        }
        SubsidiaryCompany sc=(SubsidiaryCompany)MapTrunPojo.map2Object((Map)list.get(0),SubsidiaryCompany.class);
        return sc;
    }

    /**
     * 添加子公司信息
     * */
    public void saveSubsidiaryCompany(SubsidiaryCompany subsidiaryCompany){
        if(subsidiaryCompany.getSubsidiary_company_id()!=null&&!subsidiaryCompany.getSubsidiary_company_id().equals("")){
            this.getSession().saveOrUpdate(subsidiaryCompany);
        }else{
            this.getSession().save(subsidiaryCompany);
        }
    }
    /**
     * 查询子公司信息
     * */
    public List querySubsidiaryCompanyByEntId(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append(" select esc.branch_name,esc.regin_code,pa.full_name,esc.representative,esc.claff_sum,esc.taking " +
                " from ent_subsidiary_company esc left join public_area pa on pa.code=esc.regin_code " +
                " where 1=1 and esc.ent_id='"+entId+"' ");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }

}
