package jll.user.service.impl;

import jll.model.User;
import jll.model.User_Role_Middle;
import jll.user.dao.UserDao;
import jll.user.service.UserService;
import jll.utils.MapTrunPojo;
import jll.utils.XinfuResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userdao;

    /**
     * 获取账号信息
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public List getUserUnPw(String username, String password) {
        // TODO Auto-generated method stub
        List result = userdao.queryUserUnPwList(username, password);
        if (null != result && result.size() > 0) {
            return result;
        }
        return null;
    }

    /** {@inheritDoc} */
    /**
     * 获取账号权限信息
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public List findUserRoleList(String username, String password) {
        return userdao.findUserRoleList(username, password);

    }

    /**
     * 注册账号
     *
     * @param user
     * @param user_role_middle
     * @return
     */
    @Override
    public XinfuResult addUser(User user, User_Role_Middle user_role_middle) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
            //随机默认用户昵称
            user.setNickname("JLL" + sdf.format(new Date()));
            //注册后默认是个人用户
            user.setOrg_user_role_middle("1");
            user.setAuthentication_type("0");
            userdao.addUser(user);
            user_role_middle.setRole_id("1");
            user_role_middle.setUser_id(user.getUser_id());
            userdao.addUserRole(user_role_middle);
            return XinfuResult.build(200, "注册成功,请登录");
        } catch (Exception e) {
            e.printStackTrace();
            return XinfuResult.build(400, "注册失败,请重试");
        }
    }

    /**
     * 账号校验
     *
     * @param username
     * @return
     */
    @Override
    public XinfuResult checkData(String username) {
        //根据查询条件查询数据库
        List list = userdao.checkData(username);
        //判断查询结果是否为空
        if (list.isEmpty()) {
            //数据可用
            return XinfuResult.ok(true);
        }
        //否则数据不可用
        return XinfuResult.ok(false);
    }

    /**
     * 修改密码
     *
     * @param username
     * @param newPassWord
     * @param oldPassWord
     * @return
     */
    @Override
    public XinfuResult updatePassWord(String username, String newPassWord, String oldPassWord) {
        try {
            List list = userdao.queryUserUnPwList(username,null);
            //判断列表是否为空
            if (list != null && list.size() > 0) {
                Map map = (Map) list.get(0);
                User user = (User)MapTrunPojo.map2Object(map, User.class);
                //Map user = (Map)list.get(0);
                //***JSONObject.parse
                //String dbPsw = user.get("password").toString();
                String dbPsw = user.getPassword();
                if (dbPsw.equals(oldPassWord)) {
                    if (oldPassWord.equals(newPassWord)) {
                        return XinfuResult.build(300, "新密码不能和旧密码一致");
                    } else {
                        //user.put("password",newPassWord);
                        user.setPassword(newPassWord);
                        userdao.updateUser(user);
                        // 退出登录状态
                        //ShiroUtils.logout();
                        return XinfuResult.build(200, "修改密码成功,请重新登录");
                    }
                } else {
                    return XinfuResult.build(401, "你输入的原密码有误");
                }
            } else {
                return XinfuResult.build(402, "你输入的账号有误");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return XinfuResult.build(400, "修改密码失败");
        }
    }

    /**
     * 更新用户账号信息(个人信息)
     * @param user
     */
    @Override
    public void updateUserAccount(User user) {
        userdao.updateUserAccount(user);
    }

    /**
     * 根据账号查询用户信息
     * @param username
     * @return
     */
    @Override
    public List findUserByUserName(String username) {
        List list = userdao.findUserByUserName(username);
        return list;
    }

    @Override
    public XinfuResult test(User user){
        try {
            user.setUser_id("1");
            user.setEmail("test@test.com");
            user.setNickname("testname");
            int i = userdao.updateUserAccount(user);
            System.out.println("+++++++++++++++++"+i+ "+++++++++++++++++++++++++");
            return XinfuResult.build(200,"测试成功");
        } catch (Exception e) {
            e.printStackTrace();
            return XinfuResult.build(400,"失败");
        }

    }
}
