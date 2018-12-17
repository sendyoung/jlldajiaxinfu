package jll.data_list.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.data_list.Customer;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDao extends SimpleHibernateTemplate<Customer> {

    private static final long serialVersionUID = 1L;
    /**
     * redit_no统一信用代码
     * 查询客户信息
     * */
    public Customer queryCustomerForNo(String entId,String reditNo){
        StringBuffer sql = new StringBuffer();
        sql.append(" select ec.* from ent_customer ec where 1=1 and redit_no='"+reditNo+"' and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List<Customer> list=query.list();
        if(list==null){
            return null;
        }
        return (Customer)query.list().get(0);
    }

    /**
     * 添加客户信息
     * */
    public String saveCustomer(Customer customer){
        if(customer.getCustomer_id()!=null&&!customer.getCustomer_id().equals("")){
            this.getSession().saveOrUpdate(customer);
        }else{
            this.getSession().save(customer);
        }
        return customer.getCustomer_id();
    }

}
