package jll.reportedData.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.BasicPnformationSubmit.ProductInformation;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ProductDao extends SimpleHibernateTemplate<ProductInformation> {
    /**
     * 增加产品信息
     */
    public void addProduct(ProductInformation productInformation){
        System.out.println("执行产品信息");
        this.getSession().merge(productInformation);
    }



    /**
     * 查询产品信息
     */
    public List queryProduct(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append("select * from ent_product where 1=1 and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }
}
