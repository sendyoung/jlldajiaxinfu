package jll.data_list.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.data_list.SubsidiaryCompany;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

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
        List<SubsidiaryCompany> list=query.list();
        if(list==null){
            return null;
        }
        return (SubsidiaryCompany)query.list().get(0);
    }

    /**
     * 添加分公司信息
     * */
    public void saveSubsidiaryCompany(SubsidiaryCompany subsidiaryCompany){
        if(subsidiaryCompany.getSubsidiary_company_id()!=null&&!subsidiaryCompany.getSubsidiary_company_id().equals("")){
            this.getSession().saveOrUpdate(subsidiaryCompany);
        }else{
            this.getSession().save(subsidiaryCompany);
        }
    }

}
