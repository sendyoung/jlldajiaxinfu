package jll.user.dao;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import jll.model.User;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import com.cn.zyzs.hibernate.util.Page;

@Repository
public class UserDao extends SimpleHibernateTemplate<User> {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 获取用户的用户名与密码数据 @Title: loginRole @Description:
	 * TODO(这里用一句话描述这个方法的作用) @param @return 设定文件 @return
	 * List<Map<String,Object>> 返回类型 @throws
	 */
	@SuppressWarnings("unchecked")
	public List queryUserUnPwList(String username, String password) {

		StringBuffer sql = new StringBuffer();
		sql.append(" select username,password from org_user_account user where 1=1 and isDelete='0'  ");
		if(!"".equals(username) && null!=username){
			sql.append(" and user.username='"+username+"' ");
		}
		if(!"".equals(password) && null!=password){
			sql.append(" and user.password='"+password+"' ");
		}
		
		
		Query query = this.getSession().createSQLQuery(sql.toString());
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.list();

	}

	/**
	 * 获取用户菜单权限
	 * @param username
	 * @param password
	 * @return
	 */
	public List findUserRoleList(String username , String password ) {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT                                                                                      ");
		sql.append(" 	upermission.*                                                                              ");
		sql.append(" FROM                                                                                        ");
		sql.append(" 	org_user_account USER                                                                      ");
		sql.append(" LEFT JOIN org_user_role_middle urmiddle ON USER .user_id = urmiddle.user_id                 ");
		sql.append(" LEFT JOIN org_user_role_detail usdetail ON urmiddle.role_id = usdetail.role_id              ");
		sql.append(" LEFT JOIN org_role_permission_middle rpmiddle ON usdetail.role_id = rpmiddle.role_id        ");
		sql.append(" LEFT JOIN org_user_permission upermission ON rpmiddle.role_id = upermission.permission_id   ");
		sql.append(" WHERE                                                                                       ");
		sql.append(" 	1 = 1                                                                                      ");
		sql.append(" AND USER .isDelete = '0'                                                                    ");
		sql.append(" AND USER .username = '"+username+"'                                                               ");

		Query query = this.getSession().createSQLQuery(sql.toString());
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.list();
		
	}
	
	
	
	
	
	
	

}
