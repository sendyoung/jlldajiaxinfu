package jll.roleAndGroup.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import jll.model.zyzs_group_bi;
import jll.roleAndGroup.dao.GroupDao;
import jll.roleAndGroup.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.zyzs.hibernate.util.Page;

@Service("groupService")
@Transactional
public class GroupServiceImpl implements GroupService {

	@Autowired
	private GroupDao groupDao;

	@Override
	public List<zyzs_group_bi> getGroupList() {
		

		List<zyzs_group_bi> group = groupDao.getGroup();
		

		return group;

	}

	@Override
	public Page getGroupIsUserService() {
		
		return groupDao.getGroupIsUser();
	}

	  
	 /** {@inheritDoc} */  
	 
	@Override
	public void addGroup(zyzs_group_bi entity) {
		groupDao.addGroup(entity);
		
	}

	@Override
	public List getGroupIsRoleList(String id) {
		// TODO Auto-generated method stub
		return groupDao.getGroupIsRoleList(id);
	}

}
