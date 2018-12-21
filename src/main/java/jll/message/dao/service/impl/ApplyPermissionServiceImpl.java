package jll.message.dao.service.impl;

import jll.apply_evaluate.dao.ApplyPermissionDao;
import jll.message.dao.service.ApplyPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("applyPermissionService")
@Transactional
public class ApplyPermissionServiceImpl implements ApplyPermissionService {

    @Autowired
    private ApplyPermissionDao applyPermissionDao;//申请评价


    @Override
    public List findApplyPermission() {
        return applyPermissionDao.queryApplyPermission();
    }
}
