package jll.roleAndGroup.controller;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.zyzs.utils.base.BaseClass;
import com.cn.zyzs.utils.utils.PageContext;
import com.cn.zyzs.utils.utils.PageView;
import jll.model.zyzs_group_bi;
import jll.model.zyzs_role_group_bi;
import jll.roleAndGroup.service.GroupService;
import jll.roleAndGroup.service.RGService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
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
@RequestMapping("/groupAndRole")
public class RGController extends BaseClass {
	@Autowired
	private GroupService groupService;

	@Autowired
	private RGService rgservice;
	
	@RequestMapping(value = "/addGR", method = RequestMethod.GET)
	@ResponseBody
	public String addGR(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("444444");
		
		System.out.println("1111");
		
	return null;
			
	}
	
	/**
	 * 角色列表 
	 * <功能详细描述> 
	 * @param request
	 * @param response
	 * @return 
	 * @creator lhj-s
	 * @see [修改人,修改内容,修改时间]
	 */
	@RequestMapping(value = "/groupList")
	@ResponseBody
	public Object groupList(HttpServletRequest request, HttpServletResponse response) {
		@SuppressWarnings({ "unused", "rawtypes" })
		Map parame = getParameters(request);
		
		info("测试请求");
		System.out.println(PageContext.getPageSize()+"========1");
		System.out.println(PageContext.getOffSet()+"=========2");
		Page pagess = groupService.getGroupIsUserService();
		PageView pageView = new PageView(PageContext.getPageSize(), PageContext.getOffSet());
		long lon = pagess.getTotal();
		pageView.setTotalrecord(pagess.getTotal());
		pageView.setRecords(pagess.getItems());
		return pageView;
	}
	
	/**
	 * 添加角色与权限
	 * <功能详细描述> 
	 * @param request
	 * @param response
	 * @return 
	 * @creator lhj-s
	 * @see [修改人,修改内容,修改时间]
	 */
	@RequestMapping(value = "/savaGroupRole")
	@ResponseBody
	public void savaGroupRole(HttpServletRequest request,String[] menu,String[] date ,String[] tb ,String[] roles, HttpServletResponse response) {
		@SuppressWarnings("unused")
		Map parame = getParameters(request);
		zyzs_group_bi group = new zyzs_group_bi();
		group.setGroupNameCh(parame.get("groupName").toString());
		if(null!=parame.get("id") && parame.get("id")!=""){
			group.setId(parame.get("id").toString());
		}
		
		//添加职位
		groupService.addGroup(group);
		
		//=================================
		//权限添加
		if(null!= menu || null!= tb || null!= date || null!= roles ){
			rgservice.delRoleGroup(group.getId());
			if(null!= menu ){
				saveUtil(menu,group.getId());
			}
			
			if(null!= tb){
				saveUtil(tb , group.getId());
			}
			
			if(null!= date){
				saveUtil(date , group.getId());
			}
			
			if(null!= roles){
				saveUtil(roles , group.getId());
			}
		}
		
	}
	
	public void saveUtil(String parame[] ,String groupId ){
		for(int i=0;i<parame.length;i++){
			zyzs_role_group_bi zrg = new zyzs_role_group_bi();
			zrg.setGroupId(groupId);
			zrg.setRoleId(parame[i]);
			rgservice.saveRoleGroup(zrg);
		}
	}
	
	
	/**
	 * 添加用户的下拉 <一句话功能简述> 
	 * <功能详细描述> 
	 * @param request
	 * @param response
	 * @return 
	 * @creator @KeNan
	 * @see [修改人,修改内容,修改时间]
	 */
	@RequestMapping(value = "/getGroup", method = RequestMethod.GET)
	@ResponseBody
	public String getGroup(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("444444");
		List<zyzs_group_bi> groupList = groupService.getGroupList();
		
		String jsonString =null;
		
		System.out.println(jsonString);
		
	return jsonString;
			
	}
	
	
	/**
	 * 职位和员工<一句话功能简述> 
	 * <功能详细描述> 
	 * @param request
	 * @param response
	 * @return 
	 * @creator @KeNan
	 * @see [修改人,修改内容,修改时间]
	 */
	
	/*@RequestMapping(value = "/getGroupIsUsers", method = RequestMethod.GET)
	@ResponseBody
	public String getGroupIsUsers(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		JSONObject jo = new JSONObject();
		JSONArray ja;
		try {
			List<Map> groupIsUsers = groupService.getGroupIsUserService();
			ja = new JSONArray();
			ja.addAll(groupIsUsers);
			map.put("data", ja);
			map.put("mager", "Ok");
			jo.putAll(map);

			return jo.toJSONString();
		} catch (Exception e) {
			e.printStackTrace();
			map.put("mager", "ERROR");
			jo.putAll(map);
			return jo.toJSONString();
		}

	}*/
	
	
}
