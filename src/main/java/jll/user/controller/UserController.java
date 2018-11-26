package jll.user.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.zyzs.utils.utils.PageContext;
import com.cn.zyzs.utils.utils.PageView;
import jll.framework.base.BaseClass;
import jll.model.zyzs_group_bi;
import jll.model.zyzs_user_bi;
import jll.roleAndGroup.service.GroupService;
import jll.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;


import com.cn.zyzs.hibernate.util.Page;



/**
 * 权限管理
 */
@Controller
@Scope("prototype")
@RequestMapping("/user")
public class UserController  extends BaseClass {
	

	@Autowired
    private UserService userservice;
	@Autowired
	private GroupService groupService;
	
	
	/**
	 * 用户首页 列表 
	 * <功能详细描述> 
	 * @param model
	 * @param request
	 * @param response
	 * @return 
	 * @creator lhj
	 * @see [修改人,修改内容,修改时间]
	 */
	@RequestMapping(value = "/UserWebUI")
	
	public String UserWebUI(final ModelMap model , HttpServletRequest request, HttpServletResponse response) {
		//查询底部职位加载:
		List<zyzs_group_bi> list = groupService.getGroupList();
		model.put("res", list);
		
		
		return "user";
	}
	
	/**
	 * 用户首页 列表 
	 * <功能详细描述> 
	 * @param model
	 * @param request
	 * @param response
	 * @return 
	 * @creator lhj
	 * @see [修改人,修改内容,修改时间]
	 */
	@RequestMapping(value = "/modifypwd")
	@ResponseBody
	public String modifypwd(final ModelMap model , HttpServletRequest request, HttpServletResponse response) {
		@SuppressWarnings({ "unused", "rawtypes" })
		Map parame = getParameters(request);
		String username = getDetails().getUsername();
		String result = userservice.updateUser(username , parame.get("oldpassword").toString(),parame.get("newpassword").toString(),parame.get("confpassword").toString());
		String message = "";
		if(result.equals("0")){
			message =  "Succes";
		}else{
			message =  "Error";
		}
		return message;
	}
	
	
	/**
	 * 用户首页 列表 
	 * <功能详细描述> 
	 * @param model
	 * @param request
	 * @param response
	 * @return 
	 * @creator lhj
	 * @see [修改人,修改内容,修改时间]
	 */
	@RequestMapping(value = "/queryUserList")
	@ResponseBody
	public Object queryUserList(final ModelMap model , HttpServletRequest request, HttpServletResponse response) {
		@SuppressWarnings({ "unused", "rawtypes" })
		Map parame = getParameters(request);
		
		
		info("测试请求");
		System.out.println(PageContext.getPageSize()+"========1");
		System.out.println(PageContext.getOffSet()+"=========2");
		//String seachProName = parame.get("seachProName").toString();
		//String seachnumId = parame.get("seachnumId").toString();
		//String seachmanuFacturer = parame.get("seachmanuFacturer").toString();
		//Map parame = new HashMap();
		//parame.put("seachProName", seachProName);
		//parame.put("seachnumId", seachnumId);
		//parame.put("seachmanuFacturer", seachmanuFacturer);
		Page pagess = userservice.findPageUser(parame);

		PageView pageView = new PageView(PageContext.getPageSize(), PageContext.getOffSet());
		long lon = pagess.getTotal();
		pageView.setTotalrecord(pagess.getTotal());
		pageView.setRecords(pagess.getItems());
		
		//zyzs_user_bi zub = new zyzs_user_bi();
		//userservice.userRegistration(zub);
		
		return pageView;
	}
	
	
	@RequestMapping(value = "/savaUser", method = RequestMethod.POST)
	@ResponseBody
	public void getRedDataUI(final ModelMap model , HttpServletRequest request, HttpServletResponse response) {
		@SuppressWarnings("unused")
		Map parame = getParameters(request);
		zyzs_user_bi zub = new zyzs_user_bi();
		if (null!=parame.get("id").toString()&&!"".equals(parame.get("id").toString())) {
			zub.setId(parame.get("id").toString());
		}
		
		zub.setUsername(parame.get("username").toString());
		zub.setPassword(parame.get("password").toString());
		zub.setGroupId(parame.get("groupId").toString());
		zub.setName(parame.get("name").toString());
		userservice.userRegistration(zub);
	}
	
	@RequestMapping(value = "/getUserOne", method = RequestMethod.POST)
	@ResponseBody
	public String getUserOne(final ModelMap model , HttpServletRequest request, HttpServletResponse response) {
		
		@SuppressWarnings("rawtypes")
		Map parame = getParameters(request);
		System.out.println(parame.get("userId")+"============");
		List result = userservice.getUserOne(parame.get("userId").toString());
		return JSON.toJSONString(result);
		
	}
	
	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	@ResponseBody
	public void deleteUser(final ModelMap model , HttpServletRequest request, HttpServletResponse response) {
		
		@SuppressWarnings("rawtypes")
		Map parame = getParameters(request);
		System.out.println(parame.get("userId")+"============");
		userservice.deleteUser(parame.get("userId").toString());
		
	}
	
}
