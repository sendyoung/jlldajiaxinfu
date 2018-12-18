package jll.user.service;

import jll.model.User;
import jll.model.User_Role_Middle;
import jll.utils.XinfuResult;

import java.util.List;

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
	 * <一句话功能简述> 获取用户权限列表 <功能详细描述>
	 * 
	 * @param username
	 * @param password
	 * @return 
	 * @creator @KeNan
	 */
	public List findUserRoleList(String username , String password );

	/**
	 * 注册用户
	 * @param user
	 * @param user_role_middle
	 * @return
	 */
	public XinfuResult addUser(User user, User_Role_Middle user_role_middle);

	/**
	 * 账号校验
	 * @param username
	 * @return
	 */
	public XinfuResult checkData(String username);

	/**
	 * 修改密码
	 * @param username
	 * @param newPassWord
	 * @param oldPassWord
	 * @return
	 */
	public XinfuResult updatePassWord(String username, String newPassWord, String oldPassWord);

	/**
	 * 更新用户数据
	 * @param user
	 */
	public void updateUserAccount(User user);

	/**
	 * 根据用户名查看用户数据
	 */
	public List findUserByUserName(String username);

	public XinfuResult test(User user);
}
