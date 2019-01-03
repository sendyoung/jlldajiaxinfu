package jll.data_list.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.data_list.CustomerTranstraction;
import jll.utils.MapTrunPojo;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CustomerTranstractionDao extends SimpleHibernateTemplate<CustomerTranstraction> {

    private static final long serialVersionUID = 1L;

    /**
     * 根据员工ID删除家庭成员信息
     * */
    public void deleteCustomerTranstractionByCustomerId(String customer_id){
        StringBuffer sql = new StringBuffer();
        sql.append(" select ect.* from ent_customer_transtraction ect where 1=1 and customer_id='"+customer_id+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List fiList=query.list();
        if(fiList!=null){
            for(int i=0;i<fiList.size();i++){
                CustomerTranstraction ct=(CustomerTranstraction) MapTrunPojo.map2Object((Map)fiList.get(0),CustomerTranstraction.class);
                this.getSession().delete(ct);
            }
        }
    }
    /**
     * 添加家庭成员信息
     * */
    public void saveCustomerTranstraction(CustomerTranstraction customerTranstraction){
        if(customerTranstraction.getCustomer_transtraction_id()!=null&&!customerTranstraction.getCustomer_transtraction_id().equals("")){
            this.getSession().saveOrUpdate(customerTranstraction);
        }else{
            this.getSession().save(customerTranstraction);
        }
    }

}
