package zkfh.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

public class CustomLoginHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	@SuppressWarnings("unused")
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws ServletException, IOException {
		super.onAuthenticationSuccess(request, response, authentication);
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
		String username = userDetails.getUsername();
		List users = request.getSession().getServletContext().getAttribute("users")==null?null:(List)request.getSession().getServletContext().getAttribute("users");
	    if (users==null) {
			users = new ArrayList();
			users.add(username);
			request.getSession().getServletContext().setAttribute("users", users);
		}else {
			users.add(username);
			request.getSession().getServletContext().setAttribute("users", users);
		}
		System.out.println(userDetails.getPassword()+"==========");
		System.out.println(userDetails.getUsername()+"============");
		//这里可以追加开发人员自己的额外处理
		System.out.println("===============登陆日志=============");
	}

}
