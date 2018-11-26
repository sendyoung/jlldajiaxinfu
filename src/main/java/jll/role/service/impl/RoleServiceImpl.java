package jll.role.service.impl;

import java.util.List;
import java.util.Map;

import jll.model.zyzs_role_bi;
import jll.role.dao.RoleDao;
import jll.role.service.RoleService;
import jll.user.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;






@Service("roleService")
@Transactional
public  class RoleServiceImpl implements RoleService {

	@Autowired
	private UserDao userdao;
	@Autowired
	private RoleDao roleDao;

	  
	 /** {@inheritDoc} */  
	 
	@Override
	public boolean getUserUnPw(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}


	

	@Override
	public List<zyzs_role_bi> indexPageDataService(Map parame) {
		
		return  roleDao.indexPageData(parame);
	
		
	}

	  
	
	
	
	
	
	
	
	
	

	
}
