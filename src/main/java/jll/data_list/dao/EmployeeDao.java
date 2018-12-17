package jll.data_list.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.data_list.Employee;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDao extends SimpleHibernateTemplate<Employee> {

    private static final long serialVersionUID = 1L;
    /**
     *identity_card_no身份证号
     * 查询员工信息
     * */
    public Employee queryEmployeeForNo(String entId,String identityCardNo){
        StringBuffer sql = new StringBuffer();
        sql.append(" select ee.* from ent_employee ee where 1=1 and identity_card_no='"+identityCardNo+"' and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List<Employee> list=query.list();
        if(list==null){
            return null;
        }
        return (Employee)query.list().get(0);
    }

    /**
     * 添加表彰信息
     * */
    public String saveEmployee(Employee employee){
        if(employee.getEmployee_id()!=null&&!employee.getEmployee_id().equals("")){
            this.getSession().saveOrUpdate(employee);
        }else{
            this.getSession().save(employee);
        }
        return employee.getEmployee_id();
    }

}
