package jll.roleAndGroup.service.impl;

import java.util.List;

import jll.model.zyzs_role_group_bi;
import jll.roleAndGroup.dao.GroupAndRoleDao;
import jll.roleAndGroup.dao.GroupDao;
import jll.roleAndGroup.service.RGService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;





@Service("rGService")
@Transactional
public  class RUServiceImpl implements RGService {

	@Autowired
	private GroupAndRoleDao rgdao;
    @Autowired
    private GroupDao groupDao;
    
	
	  
	/** {@inheritDoc} */  
	@Override
	public List queryRoleByGroupIdList(String groupId) {
		// TODO Auto-generated method stub
		return rgdao.queryRoleByGroupIdList(groupId);
		
	}


	
	/*public void addGroup(zyzs_group_bi entity) {
		return rgdao.addGroupAndRoleBatch(list);
		
	}*/


	  
	 /** {@inheritDoc} */  
	 
	@Override
	public void delRoleGroup(String groupId) {
		rgdao.delRoleGroup(groupId);
		
	}


	  
	 /** {@inheritDoc} */  
	 
	@Override
	public void saveRoleGroup(zyzs_role_group_bi entity) {
		rgdao.saveRoleGroup(entity);
	}
	

	
}
