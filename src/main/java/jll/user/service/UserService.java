package jll.user.service;

import java.util.List;
import java.util.Map;

import com.cn.zyzs.hibernate.util.Page;
import jll.model.zyzs_user_bi;

public interface UserService {

	/**
	 * 获取用户名与密码
	* @Title: loginRole 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return    设定文件 
	* @return List<Map<String,Object>>    返回类型 
	* @throws
	 */
	
	public List getUserUnPw(String username, String password);

	/**
	 * 保存用户信息
	* @Title: loginRole 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return    设定文件 
	* @return List<Map<String,Object>>    返回类型 
	* @throws
	 */
	public void userRegistration(zyzs_user_bi entity) ;
	
	
	/**
	 * @return 
	 * 用户列表
	* @Title: loginRole 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return    设定文件 
	* @return List<Map<String,Object>>    返回类型 
	* @throws
	 */
	public Page findPageUser(Map parame) ;
	
	/**
	 * 根据id获取用户信息
	 * <功能详细描述>
	 * @param prame
	 * @creator @KeNan
	 * @see [修改人,修改内容,修改时间]
	 */
	public List getUserOne(String userId);
	
	
	/**
	 * <一句话功能简述> 用户禁用 <功能详细描述>
	 * 
	 * @param id
	 * @creator @KeNan
	 * @see [修改人,修改内容,修改时间]
	 */
	public void deleteUser(String id);
	
	
	/**
	 * <一句话功能简述> 获取用户权限列表 <功能详细描述>
	 * 
	 * @param id
	 * @return 
	 * @creator @KeNan
	 * @see [修改人,修改内容,修改时间]
	 */
	public List findUserRoleList(String userId);
	
	
	/**
	 * <一句话功能简述> 更新用户 <功能详细描述>
	 * 
	 * @param id
	 * @return 
	 * @creator @KeNan
	 * @see [修改人,修改内容,修改时间]
	 */
	public String updateUser(String username, String oldpassword, String newpassword, String confpassword);
	
	
	
}
