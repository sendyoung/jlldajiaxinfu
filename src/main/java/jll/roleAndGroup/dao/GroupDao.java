package jll.roleAndGroup.dao;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import jll.model.zyzs_group_bi;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import com.cn.zyzs.hibernate.util.Page;

/**
 * 职位权限关联Dao <一句话功能简述> <功能详细描述>
 * 
 * @author @KeNan
 * @email 630758702@qq.com
 * @version [版本号, 2018年4月20日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Repository
public class GroupDao extends SimpleHibernateTemplate<zyzs_group_bi> {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * <获取用户权限> <功能详细描述>
	 * 
	 * @param username
	 * @param password
	 * @return
	 * @creator lhj
	 * @see [修改人,修改内容,修改时间]
	 */
	@SuppressWarnings("unchecked")
	public List queryRoleByGroupIdList(String groupId) {

		StringBuffer sql = new StringBuffer();
		sql.append(" select t2.* from zyzs_role_group_bi t1 left join zyzs_role_bi t2 on t1.roleId = t2.id  ");
		sql.append(" where 1=1 ");
		sql.append(" and t1.groupId=:groupId ");
		Query query = this.getSession().createSQLQuery(sql.toString());
		query.setParameter("groupId", groupId);
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.list();

	}

	/**
	 * 添加职位<一句话功能简述> <功能详细描述>
	 * 
	 * @param entity
	 * @creator lhj-s
	 * @see [修改人,修改内容,修改时间]
	 */

	public void addGroup(zyzs_group_bi entity) {
		getSession().saveOrUpdate(entity);
	}

	@SuppressWarnings("unchecked")
	public List<zyzs_group_bi> getGroup() {
		/*
		 * String sql ="Select id,groupNameCH,groupNameEn form zyzs_group_bi ";
		 * 
		 * return
		 * this.getSession().createSQLQuery(sql).addEntity(zyzs_group_bi.class).
		 * list();
		 */

		return (List<zyzs_group_bi>) this.getSession().createQuery(" FROM zyzs_group_bi where 1=1 ").list();

	}

	
	/**
	 * 获取职位list
	 * <功能详细描述> 
	 * @return 
	 * @creator lhj
	 * @see [修改人,修改内容,修改时间]
	 */
	@SuppressWarnings("unchecked")
	public Page getGroupIsUser() {
		
		Map<String, Object> param = new HashMap<String, Object>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		StringBuffer sql = new StringBuffer();
		sql.append("  select g.id,groupNameCH FROM  zyzs_group_bi g  ");
		return this.sqlqueryForpage(sql.toString(), param, orderby);
		
	}

	
	
	
	
	
	public List getGroupIsRoleList(String id){
		
		 String sql=" SELECT\n" +
		            "\trb.id,\n" +
		            "\trb.category,\n" +
		            "\trb.descpt,\n" +
		            "\tg.id,\n" +
		            "\tg.groupNameCH\n" +
		            "FROM\n" +
		            "\tzyzs_group_bi g\n" +
		            "INNER JOIN zyzs_role_group_bi rg ON g.id = rg.groupId\n" +
		            "LEFT JOIN zyzs_role_bi rb ON rg.roleId = rb.id\n" +
		            "WHERE\n" +
		            "\tg.id = '"+id  +"' ";
		
		 return this.getSession().createSQLQuery(sql).list();
		
	}
	
	
}
