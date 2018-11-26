package jll.security;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jll.framework.base.BaseClass;
import jll.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/*import cn.com.llovef.application.role.service.RoleService;
import cn.com.llovef.framework.base.BaseClass;*/

//***********************************//
//*************用 户 登 陆 逻 辑 类***********//
//***********************************//
//***********************************//

/**
 * @ClassName: LoginController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author A18ccms a18ccms_gmail_com
 * @date 2015年10月30日 下午5:09:55 声明:总统府所有-不经本人允许随意散播到公众平台-本人将追究法律责任-特此声明.
 *       Tel:13811348643 email:531677565@qq.com
 */
@Controller
@Scope("prototype")
@RequestMapping("/login")
public class LoginController extends BaseClass {

	@Autowired
	private UserService userservice;

	/**
	 * 访问 http://localhost:8080/login 即可跳转到登陆页
	 */

	@RequestMapping(value = { "/" })
	public ModelAndView main(final ModelMap model, HttpServletRequest request,
		HttpServletResponse response) throws Exception {
		System.out.println("=================44444================");
		ModelAndView models = new ModelAndView();
		models.setViewName("login");
		return models;
	}

	/**
	 * 跳转到登陆页
	 */
	@RequestMapping(value = { "/login" })
	public ModelAndView login(final ModelMap model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("=================登陆================");
		ModelAndView models = new ModelAndView();
		models.addObject("title",
				"Welcome - Spring Security Custom login/logout Filter");
		models.addObject("message", "This is welcome page!");
		models.setViewName("login");
		return models;
	}
	
	
	/**
	 * 登陆成功 跳转到登陆页
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = { "/successHandler" })
	public ModelAndView successHandler(final ModelMap model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView models = new ModelAndView();
		String username = getDetails().getUsername();
		String password = getDetails().getPassword();
		Map parame = new HashMap();
		parame.put("username", username);
		HttpSession session = request.getSession();
		session.setAttribute("username", username);
		List roleList = userservice.getUserUnPw(username, password);
		Map map = null;
		for(int i=0;i<roleList.size();i++){
			 map = (Map)roleList.get(i);
		}
		List list = userservice.findUserRoleList(map.get("id").toString());
		model.addAttribute("roleList", roleList);
		model.put("roleList", list);
		models.setViewName("index");
		return models;
	}
	
	/**
	 * 登陆失败,跳转到登录页，提示失败信息
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value = { "/failureHandler" })
	public ModelAndView failureHandler(final ModelMap model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("=================登陆成功11================");
		ModelAndView models = new ModelAndView();
		models.addObject("error",getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
		models.setViewName("login");
		return models;
	}

	private String getErrorMessage(HttpServletRequest request, String key) {
		Exception exception = (Exception) request.getSession()
				.getAttribute(key);
		String error = "";
		if (exception instanceof BadCredentialsException) {
			error = "用户名或密码错误!";
		} else if (exception instanceof BadAnswerException) {
			error = exception.getMessage();
		} else if (exception instanceof LockedException) {
			error = exception.getMessage();
		} else {
			error = "用户名或密码错误!";
		}

		return error;
	}
	

	
}
