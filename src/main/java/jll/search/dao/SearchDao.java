package jll.search.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.enterprise.EntBasics;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SearchDao extends SimpleHibernateTemplate<EntBasics> {

    public List findEntList(String companyName){
        StringBuffer sql = new StringBuffer();
        /**
         * 表名ent_basics
         * 公司logo   company_logo
         * 公司名称   company_name
         * 电话      company_tel
         * 邮箱       company_email
         * 官网       company_website
         * 地址   company_registration_address公司注册地址
         */
        sql.append(" SELECT * FROM ent_basics ");
        sql.append(" WHERE 1=1 ");
        sql.append(" AND isDelete = '0' ");
        
        return null;
    }

}
