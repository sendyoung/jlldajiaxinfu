package jll.data_list.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import com.cn.zyzs.hibernate.util.Page;
import com.cn.zyzs.utils.utils.PageContext;
import jll.model.data_list.Employee;
import jll.utils.MapTrunPojo;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
        List list=query.list();
        if(list==null){
            return null;
        }
        Employee e=(Employee) MapTrunPojo.map2Object((Map)list.get(0),Employee.class);
        return e;
    }

    /**
     * 添加员工信息
     * */
    public String saveEmployee(Employee employee){
        if(employee.getEmployee_id()!=null&&!employee.getEmployee_id().equals("")){
            this.getSession().saveOrUpdate(employee);
        }else{
            this.getSession().save(employee);
        }
        return employee.getEmployee_id();
    }
    /**
     * 查询各员工类型的信息
     * */
    public Page queryEmployeeByStype(String entId,String stype){
        Map<String, Object> param = new HashMap<String, Object>();
        StringBuffer sql = new StringBuffer();
        LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
        sql.append("select name,gender,birth_date,edu_background,duty,work_date,join_date,work_industry_year" +
                " from ent_employee where 1=1 and ent_id='"+entId+"' and stype='"+stype+"' ");
        return sqlqueryForpage1(sql.toString(), param, PageContext.getPageSize(), PageContext.getOffSet(), orderby);
    }

}
