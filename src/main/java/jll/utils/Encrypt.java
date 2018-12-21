package jll.utils;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

/**
 * @Description:
 * @Author:			young
 * @Company:		http://www.dajiaxinfu.com
 * @CreateDate:		2018年7月27日
 */
public class Encrypt {
	/*
	 * 散列算法一般用于生成数据的摘要信息，是一种不可逆的算法，一般适合存储密码之类的数据，
	 * 常见的散列算法如MD5、SHA等。一般进行散列时最好提供一个salt（盐），比如加密密码“admin”，
	 * 产生的散列值是“21232f297a57a5a743894a0e4a801fc3”，
	 * 可以到一些md5解密网站很容易的通过散列值得到密码“admin”，
	 * 即如果直接对密码进行散列相对来说破解更容易，此时我们可以加一些只有系统知道的干扰数据，
	 * 如用户名和ID（即盐）；这样散列的对象是“密码+用户名+ID”，这样生成的散列值相对来说更难破解。
	 */
	
	//345-6789-12
	//高强度加密算法,不可逆
	public static String md5(String password, String salt){
		return new Md5PasswordEncoder().encodePassword(password,salt);
	}

}
