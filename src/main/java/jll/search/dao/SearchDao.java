package jll.search.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import com.cn.zyzs.hibernate.util.Page;
import com.cn.zyzs.utils.utils.PageContext;
import jll.model.enterprise.EntBasics;
import org.springframework.stereotype.Repository;

//搜索
@Repository
public class SearchDao extends SimpleHibernateTemplate<EntBasics> {

    public Page findEntList(String qName){
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
        sql.append(" SELECT ent_id,company_logo,company_name,company_tel,company_email,company_website,company_registration_address FROM ent_basics ");
        sql.append(" WHERE 1=1 ");
        sql.append(" AND isDelete = '0' ");
        sql.append(" AND company_name LIKE '%" + qName + "%'" );

        return sqlqueryForpage1(sql.toString(), null, PageContext.getPageSize(), PageContext.getOffSet(), null);
    }

    //测试
   /* public List<User> testUser(String realname){
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT * FROM org_user_account WHERE realname = '" + realname + "'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.aliasToBean(User.class));
        return query.list();
    }*/

}
