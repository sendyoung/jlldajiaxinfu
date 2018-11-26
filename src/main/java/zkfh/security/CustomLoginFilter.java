package zkfh.security;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.TextEscapeUtils;

public class CustomLoginFilter extends UsernamePasswordAuthenticationFilter {

	@SuppressWarnings({ "rawtypes", "unused" })
	public Authentication attemptAuthentication(HttpServletRequest request,
			HttpServletResponse response) throws AuthenticationException {

		 if (!request.getMethod().equals("POST")) {
			 throw new AuthenticationServiceException("Authentication method not supported: "+ request.getMethod());
		 }

		    //获取用户名、密码数据  
		    String username = obtainUsername(request);  
		    String password = obtainPassword(request);  
		  
		    if (username == null) {  
		        username = "";  
		    }  
		  
		    if (password == null) {  
		        password = "";  
		    }  
		    
		    username = username.trim();  
		    
		    //这里将原来的UsernamePasswordAuthenticationToken换成我们自定义的CustomAuthenticationToken
			CustomAuthenticationToken authRequest = new CustomAuthenticationToken(username, password, 0, "");
			
		    // Place the last username attempted into HttpSession for views  
		    HttpSession session = request.getSession(false);  
		    //如果session不为空，添加username到session中  
		    if (session != null || getAllowSessionCreation()) {
		        request.getSession().setAttribute("username", TextEscapeUtils.escapeEntities(username));  
		    } 
		    // Allow subclasses to set the "details" property  
		    //设置details，这里就是设置org.springframework.security.web.  
		    //authentication.WebAuthenticationDetails实例到details中  
		    setDetails(request, authRequest);  
		    //通过AuthenticationManager:ProviderManager完成认证任务  
		    return this.getAuthenticationManager().authenticate(authRequest);  
		    
	/*	1、details：额外的认证信息，比如被赋值用户的IP地址

		2、authorities：授权信息，比如被赋值用户的角色信息

		3、authenticated ：是否被验证通过*/
		
	/*	Map map = request.getParameterMap();
		String username = obtainUsername(request).toUpperCase().trim();
		String password = obtainPassword(request);*/
		//获取用户输入的下一句答案 参数
		/*String answer = null;
		//获取问题Id(即: hashTable的key)
		Integer questionId = null; //obtainQuestionId(request);
*/
		

		//这里就将token传到后续验证环节了
		/*setDetails(request, authRequest);
		return this.getAuthenticationManager().authenticate(authRequest);*/
	}

	
}
