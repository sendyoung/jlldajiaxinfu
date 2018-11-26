package jll.user.dao;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import jll.model.zyzs_user_bi;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import com.cn.zyzs.hibernate.util.Page;

@Repository
public class UserDao extends SimpleHibernateTemplate<zyzs_user_bi> {

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
	 * <一句话功能简述>用户注册 <功能详细描述>
	 * 
	 * @param user
	 * @creator @KeNan
	 * @see [修改人,修改内容,修改时间]
	 */
	public void userRegistration(zyzs_user_bi entity) {
		if (!"0".equals(entity.getIsDelete()) || entity.getIsDelete().isEmpty()) {
			entity.setIsDelete("0");
		}
	
      this.save(entity);
	}

	/**
	 * <一句话功能简述> 用户禁用 <功能详细描述>
	 * 
	 * @param id
	 * @creator @KeNan
	 * @see [修改人,修改内容,修改时间]
	 */
	public void deleteUser(String id) {
		String sql = "update zyzs_user_bi SET isDelete='1' WHERE id= '" + id + "' ";
		this.getSession().createSQLQuery(sql).executeUpdate();

	}
	
	/**
	 * 更新<一句话功能简述> 
	 * <功能详细描述> 
	 * @param entity 
	 * @creator @KeNan
	 * @see [修改人,修改内容,修改时间]
	 */
		
	public void updateUser(String username,String password){
		String sql = "update zyzs_user_bi SET password='"+password+"' WHERE username= '" + username + "' ";
		this.getSession().createSQLQuery(sql).executeUpdate();
		
	}
	
	
	/**
	 * 首页<一句话功能简述> 
	 * <功能详细描述> 
	 * @param prame 
	 * @creator @KeNan
	 * @see [修改人,修改内容,修改时间]
	 */
	public Page findPageUser(Map<String,Object> prame){
		
		Map<String, Object> param = new HashMap<String, Object>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		StringBuffer sql = new StringBuffer();
		sql.append(" select u.id,u.username,u.name, g.groupNameCH as groupId from zyzs_user_bi u LEFT JOIN zyzs_group_bi g on u.groupid=g.id where 1=1   ");
		if(null!=prame.get("username")&&""!=prame.get("username")){
			sql.append(" and u.username='"+prame.get("username")+"' ");	
		}
		if (null!=prame.get("isDelete")) {
			if ("yes".equals(prame.get("isDelete"))) {
				sql.append(" and u.isDelete='1' ");
			}else{
				sql.append(" and u.isDelete='0' ");
			}
		}else{
			sql.append(" and u.isDelete='0' ");
		}
			
		
		sql.append(" order by u.id desc  ");
		
		return this.sqlqueryForpage(sql.toString(), param, orderby);
		
	}
	
	
	/**
	 * 根据id获取用户信息
	 * <功能详细描述> 
	 * @param prame 
	 * @creator @KeNan
	 * @see [修改人,修改内容,修改时间]
	 */
	public List getUserOne(String userId){
		
		StringBuffer sql = new StringBuffer();
		sql.append("  select * from zyzs_user_bi where isDelete='0' and id=:id ");
		Query query = this.getSession().createSQLQuery(sql.toString());
		query.setParameter("id", userId);
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.list();
		
	}
	
	
	public List findUserRoleList(String userId) {
		StringBuffer sql = new StringBuffer();
		sql.append("  SELECT  ");
		sql.append("  t3.*  ");
		sql.append("  FROM  ");
		sql.append("  zyzs_user_bi t1  ");
		sql.append("  INNER JOIN zyzs_role_group_bi t2 ON t1.groupId = t2.groupId  ");
		sql.append(" INNER JOIN zyzs_role_bi t3 ON t2.roleId = t3.id ");
		sql.append("  where t1.id = '"+userId+"' ");
		sql.append(" order by id asc ");
		Query query = this.getSession().createSQLQuery(sql.toString());
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.list();
		
	}
	
	
	
	
	
	
	

}
