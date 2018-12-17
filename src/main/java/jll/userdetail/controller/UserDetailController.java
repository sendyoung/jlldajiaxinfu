package jll.userdetail.controller;

import jll.model.userdetail.UserDetail;
import jll.userdetail.service.UserDetailService;
import jll.utils.XinfuResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 个人信息填报
 */
@Controller
@Scope("prototype")
public class UserDetailController {

    @Autowired
    private UserDetailService userDetailService;

    /**
     * 回显个人信息填报基础信息
     * @param userDetailId
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST}, value = "/finduserdetail")
    public @ResponseBody
   UserDetail findPersonalInformationDetails(String userDetailId){
        UserDetail userDetail = userDetailService.findPersonalInformationDetails(userDetailId);
        return userDetail;
    }

    /**
     * 回显家庭成员
     * @param userDetailId
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST}, value = "/finduserfamily")
    public @ResponseBody List findUserFamily(String userDetailId){
        List list = userDetailService.findUserFamilyDetails(userDetailId);
        return list;
    }

    /**
     *回显教育经历
     * @param userDetailId
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST}, value = "/findusereducation")
    public @ResponseBody List findUserEducation(String userDetailId){
        List list = userDetailService.findUserEducation(userDetailId);
        return list;
    }

    /**
     *回显职场履历
     * @param userDetailId
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST}, value = "/finduserworkplace")
    public @ResponseBody List findUserWorkPlace(String userDetailId){
        List list = userDetailService.findUserWorkPlace(userDetailId);
        return list;
    }

    /**
     * 新增或更新个人详情信息
     * @param userDetail
     * @param userId
     * @return
     */
    @CrossOrigin(origins = "*", maxAge=3600)
    public XinfuResult saveOrUpdateUserDetail(UserDetail userDetail,String userId){
        return userDetailService.saveOrUpdateUserDetails(userDetail,userId);
    }

}
