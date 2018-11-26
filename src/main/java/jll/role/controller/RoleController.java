package jll.role.controller;


import com.cn.zyzs.utils.base.BaseClass;
import com.cn.zyzs.utils.utils.PageContext;
import jll.model.zyzs_role_bi;
import jll.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

import static com.alibaba.druid.sql.dialect.mysql.ast.clause.MySqlFormatName.JSON;

/**
 * 权限管理
 */
@Controller
@Scope("prototype")
@RequestMapping("/role")
public class RoleController extends BaseClass {

	@Autowired
	private RoleService roleService;

	@RequestMapping(value = "/roleUI", method = RequestMethod.GET)
	public String roleUI(final ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		// roleService.indexPageDataService();
		Map parame = getParameters(request);
		List<zyzs_role_bi> res = roleService.indexPageDataService(parame);
		
		model.put("res", res);

		return "user_rights";
	}

	@RequestMapping(value = "/roleList")
	@ResponseBody
	public Object roleList(HttpServletRequest request, HttpServletResponse response) {
		@SuppressWarnings({ "unused", "rawtypes" })
		Map parame = getParameters(request);

		info("测试请求");
		System.out.println(PageContext.getPageSize() + "========1");
		System.out.println(PageContext.getOffSet() + "=========2");
		List result = roleService.indexPageDataService(parame);
		return null;
	}

}
