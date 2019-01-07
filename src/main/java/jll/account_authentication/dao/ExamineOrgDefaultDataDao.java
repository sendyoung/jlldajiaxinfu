package jll.account_authentication.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

//认证通过后默认添加组织机构和职务
@Repository
public class ExamineOrgDefaultDataDao  extends SimpleHibernateTemplate<Object> {

    //添加默认的组织机构
    public String addDefaultStruture(String authOrgId,String pid,String name){
        StringBuffer sql = new StringBuffer();
        String id = UUID.randomUUID().toString().replace("-","");
        sql.append("INSERT INTO org_structure(org_structure_id,auth_org_id,pid,name,isDelete) ");
        sql.append(" VALUES('" + id +"','" + authOrgId + "','" + pid + "','"+ name +"','0')");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.executeUpdate();
        return id;
    }

    //添加默认的职务信息
    public void addDefaultPost(String authOrgId,String post){
        StringBuffer sql = new StringBuffer();
        sql.append("INSERT INTO org_position(post_id,auth_org_id,post,isDelete) ");
        sql.append(" VALUES('" + UUID.randomUUID().toString().replace("-","") +"','" + authOrgId + "','" + post + "','0')");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.executeUpdate();
    }

}
