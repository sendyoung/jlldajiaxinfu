package jll.user.controller;

import com.cn.zyzs.utils.base.BaseClass;
import jll.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 权限管理
 */
@Controller
@Scope("prototype")
@RequestMapping("/user")
public class UserController  extends BaseClass {
	

	@Autowired
    private UserService userservice;

	
}
