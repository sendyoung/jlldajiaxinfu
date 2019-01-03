package jll.data_list.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import com.cn.zyzs.hibernate.util.Page;
import com.cn.zyzs.utils.utils.PageContext;
import jll.model.data_list.Supplier;
import jll.utils.MapTrunPojo;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
        List list=query.list();
        if(list==null||list.size()==0){
            return null;
        }
        Supplier s=(Supplier)MapTrunPojo.map2Object((Map)list.get(0),Supplier.class);
        return s;
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
    /**
     * 查询供应商信息
     * */
    public Page querySupplierByEntId(String entId){
        Map<String, Object> param = new HashMap<String, Object>();
        StringBuffer sql = new StringBuffer();
        LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
        sql.append("select supplier_id,name,representative,registered_address from ent_supplier where ent_id='"+entId+"' ");
        return sqlqueryForpage1(sql.toString(), param, PageContext.getPageSize(), PageContext.getOffSet(), orderby);
    }

}
