package jll.roleAndGroup.dao;

import java.util.List;

import javax.management.RuntimeErrorException;

import jll.model.zyzs_role_group_bi;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;

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
public class GroupAndRoleDao extends SimpleHibernateTemplate<zyzs_role_group_bi> {

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
	 * <一句话功能简述> <功能详细描述>
	 * 
	 * @param list
	 * @creator @KeNan
	 * @see [修改人,修改内容,修改时间]
	 */
	public void addGroupAndRoleBatch(List<zyzs_role_group_bi> list) {

		Session session = this.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		if (null == null || 0 == list.size()) {
				throw new RuntimeErrorException(null, "List 为空!");
		} else {

			for (int i = 0; i < list.size(); i++) {

				session.saveOrUpdate(list.get(i));

				if (i == (list.size() - 1)) {
					session.flush();
					session.clear();
				}
			}

			transaction.commit();
            session.close();
		}
	}
	
	public void delRoleGroup(String groupId) {
		StringBuffer sql = new StringBuffer();
		sql.append(" delete from zyzs_role_group_bi where groupId='"+groupId+"' ");
		Query query = this.getSession().createSQLQuery(sql.toString());
		query.executeUpdate();
	}


	  
	 /** {@inheritDoc} */  
	 
	public void saveRoleGroup(zyzs_role_group_bi entity) {
		
		this.save(entity);
		/*StringBuffer sql = new StringBuffer();
		sql.append(" insert into zyzs_role_group_bi(groupId,roleId) value('"+groupId+"' , '"+roleId+"') ");
		Query query = this.getSession().createSQLQuery(sql.toString());
		query.executeUpdate();*/
		
	}
	
	
}
