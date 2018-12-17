package jll.security;

import com.alibaba.fastjson.JSONObject;
import com.cn.zyzs.utils.base.BaseClass;
import jll.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*import cn.com.llovef.application.role.service.RoleService;
import cn.com.llovef.framework.base.BaseClass;*/

//***********************************//
//*************用 户 登 陆 逻 辑 类***********//
//***********************************//
//***********************************//

/**
 * @author A18ccms a18ccms_gmail_com
 * @ClassName: LoginController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2015年10月30日 下午5:09:55 声明:总统府所有-不经本人允许随意散播到公众平台-本人将追究法律责任-特此声明.
 * Tel:13811348643 email:531677565@qq.com
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
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = {"/"})
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
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = {"/login"})
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
    @CrossOrigin(origins = "*", maxAge = 3600)
    @SuppressWarnings({"rawtypes", "unchecked"})
    @RequestMapping(value = {"/successHandler"})
    @ResponseBody
    public Map successHandler(final ModelMap model,
                              HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        JSONObject json = new JSONObject();
        String username = getDetails().getUsername();
        String password = getDetails().getPassword();
        List result = userservice.findUserRoleList(username, password);
        List user = userservice.findUserByUserName(username);
        Map map = new HashMap();
        map.put("menu", result);
        map.put("user", user);
        return map;
        //return json.toJSONString(result);
    }

    /**
     * 登陆失败,跳转到登录页，提示失败信息
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @SuppressWarnings("unused")
    @RequestMapping(value = {"/failureHandler"})
    @ResponseBody
    public String failureHandler(final ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        JSONObject json = new JSONObject();
        System.out.println("=================登陆失敗================");
        json.put("flag", "0");//0 成功  1失敗
        json.put("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));//0 成功  1失敗
        return json.toJSONString();
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
