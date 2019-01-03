package jll.data_list.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.data_list.SupplierTranstraction;
import jll.utils.MapTrunPojo;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class SupplierTranstractionDao extends SimpleHibernateTemplate<SupplierTranstraction> {

    private static final long serialVersionUID = 1L;

    /**
     * 根据员工ID删除家庭成员信息
     * */
    public void deleteSupplierTranstractionBySupplierId(String supplier_id){
        StringBuffer sql = new StringBuffer();
        sql.append(" select est.* from ent_supplier_transtraction est where 1=1 and supplier_id='"+supplier_id+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List fiList=query.list();
        if(fiList!=null){
            for(int i=0;i<fiList.size();i++){
                SupplierTranstraction st=(SupplierTranstraction)MapTrunPojo.map2Object((Map)fiList.get(0),SupplierTranstraction.class);
                this.getSession().delete(st);
            }
        }
    }
    /**
     * 添加家庭成员信息
     * */
    public void saveSupplierTranstraction(SupplierTranstraction supplierTranstraction){
        if(supplierTranstraction.getSupplier_transtraction_id()!=null&&!supplierTranstraction.getSupplier_transtraction_id().equals("")){
            this.getSession().saveOrUpdate(supplierTranstraction);
        }else{
            this.getSession().save(supplierTranstraction);
        }
    }

}
