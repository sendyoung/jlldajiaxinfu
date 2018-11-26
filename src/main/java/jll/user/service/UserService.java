package jll.user.service;

import java.util.List;
import java.util.Map;

import com.cn.zyzs.hibernate.util.Page;

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
	 * @param id
	 * @return 
	 * @creator @KeNan
	 * @see [修改人,修改内容,修改时间]
	 */
	public List findUserRoleList(String username , String password );
	

	
	
}
