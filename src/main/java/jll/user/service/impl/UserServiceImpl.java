package jll.user.service.impl;

import java.util.List;
import java.util.Map;

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
	public List  findUserRoleList(String username,String password) {
		return userdao.findUserRoleList( username, password);
		
	}



	
}
