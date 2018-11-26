package jll.role.dao;

import java.util.List;
import java.util.Map;

import jll.model.zyzs_role_bi;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;

@Repository
public class RoleDao extends SimpleHibernateTemplate<zyzs_role_bi> {

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
		sql.append(" select username,password from zyzs_user_bi user where 1=1 ");
		sql.append(" and user.username=:username ");
		sql.append(" and user.password=:password ");
		Query query = this.getSession().createSQLQuery(sql.toString());
		query.setParameter("username", username);
		query.setParameter("password", password);
		return query.list();

	}

	/**
	 * 权限首页数据<一句话功能简述> <功能详细描述>
	 * 
	 * @return
	 * @creator @KeNan
	 * @see [修改人,修改内容,修改时间]
	 */
	@SuppressWarnings("unchecked")
	public List<zyzs_role_bi> indexPageData(Map parame) {
		return (List<zyzs_role_bi>) this.getSession().createQuery(" From zyzs_role_bi  ").list();
	
	}

}
