package jll.security;

import jll.user.service.UserService;
import jll.utils.Encrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;


/*import cn.com.llovef.application.role.service.RoleService;
import cn.com.llovef.application.role.service.UserService;*/

public class CustomAuthenticationProvider extends
		AbstractUserDetailsAuthenticationProvider {

	
	@Autowired
    private UserService userservice;
	
	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		System.out.println("==========1=2=3=4=55============");
		// 转换为自定义的token
		CustomAuthenticationToken token = (CustomAuthenticationToken) authentication;
	}
	
	@Override
	protected UserDetails retrieveUser(String username,
			UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		String password = (String) authentication.getCredentials();
		System.out.println("登陆验证用户名"+username);
		System.out.println("登陆验证密码"+password);
		//String[] whiteLists = new String[] { "531677565@QQ.COM", "SUPERVISOR", "JIMMY" };
		String md5Password = Encrypt.md5(password, "junlelian");
		List  result = userservice.getUserUnPw(username, md5Password);
		System.out.println(username+"===================111==============");
		System.out.println(password);
		// 如果用户在白名单里,直接放行(注:仅仅只是演示,千万不要在实际项目中这么干!)
		/*if (Arrays.asList(whiteLists).contains(username)) {
			Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
			UserDetails user = new User("531677565@QQ.COM", "whatever", authorities);
			return user;
		}*/
		
		if(null!=result && result.size()>0){
			Map temp = new HashMap();
			temp.put("username", username);
			//List list = roleservice.queryLoginRoleList(temp);
			List list = null;
			
			Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			if(null!=list && list.size()>0){
				for(int i=0;i<list.size();i++){
					Map t1 = (Map)list.get(i);
					authorities.add(new SimpleGrantedAuthority(t1.get("id").toString()));
				}
			}
			UserDetails user = new User(username, password, authorities);
			return user;
		}
		
		List  userVal = userservice.getUserUnPw(username, null);
		//List  pwdVal = userservice.getUserUnPw(null, password);
		if(null==userVal){
			 throw new BadAnswerException("账号密码错误或已被禁用!");
		}else if(null==result ){
			 throw new BadAnswerException("密码错误1!");
		 }

		return null;
		
	}
	
}
