package jll.user.controller;

import com.cn.zyzs.utils.base.BaseClass;
import jll.model.User;
import jll.model.User_Role_Middle;
import jll.user.service.UserService;
import jll.utils.XinfuResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
     * @param username
     * @param password
     * @return
     */

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = {"/registerUser/{username}/{password}"})
    public @ResponseBody
    XinfuResult registerUser(@PathVariable String username, @PathVariable String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setIsDelete("0");
        user.setIphone(username);
        User_Role_Middle user_role_middle = new User_Role_Middle();
        return userservice.addUser(user, user_role_middle);
    }

    /**
     * 修改密码
     *
     * @param userName
     * @param newPassWord
     * @param oldPassWord
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST}, value = "/changePassWord/{userName}/{newPassWord}/{oldPassWord}")
    public @ResponseBody
    XinfuResult changePassWord(@PathVariable String userName, @PathVariable String newPassWord, @PathVariable String oldPassWord) {
        return userservice.updatePassWord(userName, newPassWord, oldPassWord);
    }

    /**
     * 填写或修改个人账号信息
     *
     * @param user
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/fillinuser")
    public @ResponseBody
    XinfuResult fillInUser(User user) {
        try {
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
    @RequestMapping(value = {"/displayUser"})
    public @ResponseBody
    List displayUserDetail(@RequestParam String username) {
        return userservice.findUserByUserName(username);
    }

}
