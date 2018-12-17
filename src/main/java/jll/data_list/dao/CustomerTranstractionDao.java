package jll.data_list.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.data_list.CustomerTranstraction;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

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
        List<CustomerTranstraction>fiList=query.list();
        if(fiList!=null){
            for(CustomerTranstraction fi:fiList){
                this.getSession().delete(fi);
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
