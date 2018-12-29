package jll.user.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.User_Role_Middle;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserRoleMiddleDao extends SimpleHibernateTemplate<User_Role_Middle> {

    /**
     * 通过审核后修改用户角色(2 企业 3 组织)  根据用户ID
     */
    public void updateUserRoleMiddle(String userId,String roleId){
        StringBuffer sql = new StringBuffer();
        sql.append(" UPDATE org_user_role_middle SET ");
        sql.append(" role_id = '" + roleId + "'");
        sql.append(" WHERE user_id = '" +userId + "'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.executeUpdate();
    }

}
