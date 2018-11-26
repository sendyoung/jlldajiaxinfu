package jll.framework.base;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.velocity.context.Context;
import org.springframework.context.MessageSource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;




/** 
* @ClassName: BaseClass 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author A18ccms a18ccms_gmail_com 
* @date 2015年6月17日 下午4:33:22 
* 声明:总统府所有-不经本人允许随意散播到公众平台-本人将追究法律责任-特此声明. 
*/

public class BaseClass {
	/* 日志 */
	public Logger logger = Logger.getLogger(getClass());
	
	public JSONObject objectjson;

	public void debug(String message) {
		logger.debug(message);
	}
	public void error(String message) {
		logger.error(message);
	}
	public void info(String message) {
		logger.info(message);
	}
	
	/*提供对 properties 的 复用 */
	private MessageSource messageSource;
	@Resource(name="messageSource")
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	public String getMessage(String key) {
		return this.messageSource.getMessage(key, null, Locale.getDefault());
	}
	

	
	public JSONObject getObjectjson(HttpServletRequest request) {
		JSONObject jsonObject = null;
	    Map paramap = request.getParameterMap();
	    if (!paramap.isEmpty()) {
		      jsonObject = new JSONObject();
		      jsonObject =  JSONObject.parseObject(JSONObject.toJSONString(paramap)); 
		      setObjectjson(jsonObject);
	    }
		return objectjson;
	}
	
	public void setObjectjson(JSONObject objectjson) {
		this.objectjson = objectjson;
	}
	
	/**
	 * 写输出流
	 * @param response
	 * @param msg
	 * @throws IOException
	 */
	public void writeMsg(HttpServletResponse response, String msg) {
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().print(msg);
			response.getWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 取服务器地址
	 * 
	 * @param request
	 * @return
	 */
	protected String getHostUrl(HttpServletRequest request) {
		String host = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
		return host;
	}
	

	protected UserDetails getDetails() {

        Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (obj instanceof UserDetails) {
            return ((UserDetails) obj);
        }else{
        	throw new RuntimeException("获取用户信息失败!");
        }
	}
	
	
	protected String getUrl(String key) {
//        if(UrlMapping.loadUrlMap != null && UrlMapping.loadUrlMap.containsKey(key))
//            return (String)UrlMapping.loadUrlMap.get(key);
//        else
            return "";
    }
	
	protected ModelAndView toView(String path, Map model)
    {
        ModelAndView result = new ModelAndView(path, model);
        result.addAllObjects(model);
        return result;
    }
	
	protected String toView(String path) {
        return path;
    }
	

	/****************************************************************************
	 * 返回的页面中加入公共参数
	 * author:lhj
	 * 2015-12-30晚上10:22
	 * JSONObject
	 * @return
	 *****************************************************************************/
	public JSONObject getJsonObject(){
		JSONObject json = new JSONObject();
		//json.put("imagerUrl", UrlMapping.loadUrlMap.get("imagerUrl"));
		return json;
	}
	/****************************************************************************
	 * 获得页面参数信息，直接放入map
	 * author:lhj
	 * 2015-12-30晚上10:22
	 * Map<String,Object>
	 * 这个方法可以不用,这个方法可以获得页面中提交的所有参数放入map中,也可以用定义get/set方法获得,都可以的
	 * @return
	 *****************************************************************************/
	public Map<String, Object> getParameters(HttpServletRequest request) {
		Map<String, Object> m = new HashMap<String, Object>();
		Enumeration<?> en = request.getParameterNames();
		while (en.hasMoreElements()) {
			Object men = en.nextElement();
			m.put(men.toString(), request.getParameter(men.toString()).trim());
		}
		return m;
	}
	
}
