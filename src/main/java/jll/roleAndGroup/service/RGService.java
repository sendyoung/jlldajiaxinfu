package jll.roleAndGroup.service;

import jll.model.zyzs_role_group_bi;

import java.util.List;


public interface RGService {

	/**
	 * 根据角色获取用户权限
	* @Title: loginRole 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return    设定文件 
	* @return List<Map<String,Object>>    返回类型 
	* @throws
	 */
	
	public List queryRoleByGroupIdList(String groupId);

	
	
	
	/**
	 * 添加 职位<一句话功能简述> 
	 * <功能详细描述> 
	 * @param entity 
	 * @creator @KeNan
	 * @see [修改人,修改内容,修改时间]
	 */
	/*public void addGroup(zyzs_group_bi entity);*/
	
	
	/**
	 * 删除角色对应的权限
	 * <功能详细描述> 
	 * @param entity 
	 * @creator @KeNan
	 * @see [修改人,修改内容,修改时间]
	 */
	public void delRoleGroup(String groupId);
	
	/**
	 * 保存角色对应的权限
	 * <功能详细描述> 
	 * @param entity 
	 * @creator @KeNan
	 * @see [修改人,修改内容,修改时间]
	 */
	public void saveRoleGroup(zyzs_role_group_bi entity);
	
	
}
