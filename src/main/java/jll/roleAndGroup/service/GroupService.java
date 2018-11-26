package jll.roleAndGroup.service;

import java.util.List;

import com.cn.zyzs.hibernate.util.Page;
import jll.model.zyzs_group_bi;

public interface GroupService {

	
	/**
	 * 获取职位List<一句话功能简述> 
	 * <功能详细描述> 
	 * @return 
	 * @creator @KeNan
	 * @see [修改人,修改内容,修改时间]
	 */
	public List<zyzs_group_bi> getGroupList();
	
	
	/**
	 * 获取职位下的人员<一句话功能简述> 
	 * <功能详细描述> 
	 * @return 
	 * @creator @KeNan
	 * @see [修改人,修改内容,修改时间]
	 */
	public Page getGroupIsUserService();
	
	
	/**
	 * 添加用户
	 * <功能详细描述> 
	 * @return 
	 * @creator @KeNan
	 * @see [修改人,修改内容,修改时间]
	 */
	public void addGroup(zyzs_group_bi entity);
	
	/**
	 * 查询管理职位的权限<一句话功能简述> 
	 * <功能详细描述> 
	 * @param id
	 * @return 
	 * @creator @KeNan
	 * @see [修改人,修改内容,修改时间]
	 */
	public List getGroupIsRoleList(String id);
	
}
