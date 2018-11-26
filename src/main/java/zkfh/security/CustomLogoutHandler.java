package zkfh.security;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.LogoutHandler;

public class CustomLogoutHandler implements LogoutHandler {

	public CustomLogoutHandler() {
	}

	public void logout(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication) {
		System.out.println("退出登录22");
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
		String username = userDetails.getUsername();
		List users = (List) request.getSession().getServletContext().getAttribute("users");
		//在线人数移除
		users.remove(username);
		//初始化session
		HttpSession session = request.getSession(false);
		if (session != null) {
            session.invalidate();
        }
		System.out.println("users="+users.toString());
		System.out.println("CustomLogoutSuccessHandler.logout() is called!");

	}

}
