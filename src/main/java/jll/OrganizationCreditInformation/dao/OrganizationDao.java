package jll.OrganizationCreditInformation.dao;


import org.springframework.stereotype.Repository;
import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;

@Repository
public class OrganizationDao {


    /**
     * 添加组织机构信息
     */
    public void addOrganization(){

        StringBuffer sql = new StringBuffer();
        sql.append("selector * frome test");
//        this.getSession().createSQLQuery(sql.toString());
//        String result = this.session.createSQLQuery(sql);
//        System.out.println(result);

    }

}
