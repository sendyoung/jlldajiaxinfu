package jll.user.service.impl;

import java.util.List;
import java.util.Map;

import jll.model.zyzs_user_bi;
import jll.user.dao.UserDao;
import jll.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cn.zyzs.hibernate.util.Page;




@Service("userService")
@Transactional
public  class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userdao;

	  
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List getUserUnPw( String username , String password ) {
		// TODO Auto-generated method stub
		List result = userdao.queryUserUnPwList( username ,  password);
		if(null!=result && result.size()>0){
			return result;
		}
		return null;
	}


	  
	 /** {@inheritDoc} */  
	 
	@Override
	public void userRegistration(zyzs_user_bi entity) {

		userdao.userRegistration(entity);
	}



	  
	 /** {@inheritDoc} */  
	 
	@Override
	public Page findPageUser(Map parame) {
		
		return userdao.findPageUser(parame);
	}



	  
	 /** {@inheritDoc} */  
	 
	@Override
	public List getUserOne(String userId) {
		return userdao.getUserOne(userId);
	}



	  
	 /** {@inheritDoc} */  
	 
	@Override
	public void deleteUser(String id) {
		 userdao.deleteUser(id);
		 
	}



	  
	 /** {@inheritDoc} */  
	 
	@Override
	public List  findUserRoleList(String userId) {
		return userdao.findUserRoleList(userId);
		
	}



	  
	 /** {@inheritDoc} */  
	 
	@Override
	public String updateUser(String username , String oldpassword,String newpassword ,String confpassword) {
		String flag="0";
		List result = userdao.queryUserUnPwList(username,null);
		Map map = (Map)result.get(0);
		if(oldpassword.equals(map.get("password"))){
			userdao.updateUser(username, newpassword);
			return "0";//密码修改成功
		}else{
			return "1";//原始密码错误
		}
		
		
	}

	
}
