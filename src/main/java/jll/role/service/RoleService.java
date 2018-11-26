package jll.role.service;

import jll.model.zyzs_role_bi;

import java.util.List;
import java.util.Map;


public interface RoleService {

	/**
	 * 获取用户名与密码
	* @Title: loginRole 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return    设定文件 
	* @return List<Map<String,Object>>    返回类型 
	* @throws
	 */
	
	public boolean getUserUnPw(String username, String password);

	
	/**
	 * 权限首页数据<一句话功能简述> 
	 * <功能详细描述> 
	 * @return 
	 * @creator @KeNan
	 * @see [修改人,修改内容,修改时间]
	 */
	public  List<zyzs_role_bi> indexPageDataService(Map parame);
	
}
