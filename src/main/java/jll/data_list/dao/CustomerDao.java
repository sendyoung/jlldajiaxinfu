package jll.data_list.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import com.cn.zyzs.hibernate.util.Page;
import com.cn.zyzs.utils.utils.PageContext;
import jll.model.data_list.Customer;
import jll.utils.MapTrunPojo;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
        List list=query.list();
        if(list==null){
            return null;
        }
        Customer c=(Customer) MapTrunPojo.map2Object((Map)list.get(0),Customer.class);
        return c;
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
    /**
     * 查询客户信息
     * */
    public Page queryCustomerByEntId(String entId){
        Map<String, Object> param = new HashMap<String, Object>();
        StringBuffer sql = new StringBuffer();
        LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
        sql.append("select customer_id,name,representative,registered_address from ent_customer where ent_id='"+entId+"' ");
        return sqlqueryForpage1(sql.toString(), param, PageContext.getPageSize(), PageContext.getOffSet(), orderby);
    }

}
