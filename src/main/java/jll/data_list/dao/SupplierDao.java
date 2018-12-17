package jll.data_list.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.data_list.Supplier;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SupplierDao extends SimpleHibernateTemplate<Supplier> {

    private static final long serialVersionUID = 1L;
    /**
     * redit_no统一信用代码
     * 查询供应商信息
     * */
    public Supplier querySupplierForNo(String entId,String reditNo){
        StringBuffer sql = new StringBuffer();
        sql.append(" select es.* from ent_supplier es where 1=1 and redit_no='"+reditNo+"' and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List<Supplier> list=query.list();
        if(list==null){
            return null;
        }
        return (Supplier)query.list().get(0);
    }

    /**
     * 添加供应商信息
     * */
    public String saveSupplier(Supplier supplier){
        if(supplier.getSupplier_id()!=null&&!supplier.getSupplier_id().equals("")){
            this.getSession().saveOrUpdate(supplier);
        }else{
            this.getSession().save(supplier);
        }
        return supplier.getSupplier_id();
    }

}
