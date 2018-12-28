package jll.user.controller;

import com.cn.zyzs.utils.base.BaseClass;
import jll.model.User;
import jll.model.User_Role_Middle;
import jll.user.service.UserService;
import jll.utils.Encrypt;
import jll.utils.JsonUtils;
import jll.utils.XinfuResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 权限管理
 */
@Controller
@Scope("prototype")
@RequestMapping("/user")
public class UserController extends BaseClass {

    @Autowired
    private UserService userservice;

    /**
     * 注册时校验账号是否可用(false不可用,true可用)
     *
     * @param username
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.POST}, value = "/checkData")
    public @ResponseBody
    XinfuResult checkData(String username) {
        return userservice.checkData(username);
    }

    /**
     * 注册账号
     *
     * @return
     */

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.POST},value = {"/registerUser"})
    public @ResponseBody
    XinfuResult registerUser(@RequestBody Map map) {
        String username = (String)map.get("username");
        String password = (String)map.get("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(Encrypt.md5(password,"junlelian"));
        user.setIsDelete("0");
        user.setIphone(username);
        User_Role_Middle user_role_middle = new User_Role_Middle();
        return userservice.addUser(user, user_role_middle);
    }


    /**
     * 修改密码
     *
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST}, value = "/changePassWord")
    public @ResponseBody
    XinfuResult changePassWord(@RequestBody Map map) {
        String userName = (String)map.get("username");
        String newPassWord = (String)map.get("newpassword");
        String newpw = Encrypt.md5(newPassWord, "junlelian");
        String oldPassWord = (String)map.get("oldpassword");
        String oldpw = Encrypt.md5(oldPassWord, "junlelian");
        return userservice.updatePassWord(userName, newpw, oldpw);
    }

    /**
     * 填写或修改个人账号信息
     *
     * @param map
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST},value = "/fillinuser")
    public @ResponseBody
    XinfuResult fillInUser(@RequestBody Map map) {
        try {
            User user = JsonUtils.jsonToPojo((String)map.get("user"),User.class);
            userservice.updateUserAccount(user);
            return XinfuResult.build(200, "填写或修改数据成功");
        } catch (Exception e) {
            e.printStackTrace();
            return XinfuResult.build(400, "填写或修改数据失败");
        }
    }

    /**
     * 回显账号信息个人信息
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST},value = {"/displayUser"})
    public @ResponseBody
    List displayUserDetail(@RequestParam String username) {
        return userservice.findUserByUserName(username);
    }


    //测试更新账号方法
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = {"/test"})
    public @ResponseBody
    XinfuResult test(User user) {
        return userservice.test(user);
    }

    //根据用户id 查询认证ID
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = {"/authidbyuser"})
    public @ResponseBody
    String findAuthIdByUserId(@RequestParam String userId) {
        return userservice.findAuthIdByUserId(userId);
    }

}
