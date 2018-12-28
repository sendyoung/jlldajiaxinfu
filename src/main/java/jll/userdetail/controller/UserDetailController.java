package jll.userdetail.controller;

import jll.model.userdetail.UserDetail;
import jll.model.userdetail.UserEducation;
import jll.model.userdetail.UserFamily;
import jll.model.userdetail.UserWorkPlace;
import jll.userdetail.service.UserDetailService;
import jll.utils.JsonUtils;
import jll.utils.XinfuResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
     * @return
     */
    @CrossOrigin(origins = "*", maxAge=3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST}, value = "/fillinuserdetail")
    public @ResponseBody XinfuResult saveOrUpdateUserDetail(@RequestBody Map map){
        String userId = (String)map.get("userId");
        UserDetail userDetail = JsonUtils.jsonToPojo((String)map.get("userDetail"),UserDetail.class);
        return userDetailService.saveOrUpdateUserDetails(userDetail,userId);
    }

    /**
     * 新增或更新家庭成员
     * @return
     */
    @CrossOrigin(origins = "*", maxAge=3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST}, value = "/fillinuserfamily")
    public @ResponseBody XinfuResult saveOrUpdateUserFamily(@RequestBody Map map){
        List<UserFamily> list = JsonUtils.jsonToList((String)map.get("familyList"),UserFamily.class);
        String userDetailId = (String)map.get("userDetailId");
        return userDetailService.saveOrUpdateUserFamily(list,userDetailId);
    }

    /**
     * 新增或更新教育经历
     * @return
     */
    @CrossOrigin(origins = "*", maxAge=3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST}, value = "/fillinusereducation")
    public @ResponseBody XinfuResult saveOrUpdateUserEducation(@RequestBody Map map){
        List<UserEducation> list = JsonUtils.jsonToList((String)map.get("educationList"),UserEducation.class);
        String userDetailId = (String)map.get("userDetailId");
        return userDetailService.saveOrUpdateUserEducation(list,userDetailId);
    }

    /**
     * 新增或更新职场履历
     * @return
     */
    @CrossOrigin(origins = "*", maxAge=3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST}, value = "/fillinuserworkplace")
    public @ResponseBody XinfuResult saveOrUpdateUserWorkPlace(@RequestBody Map map){
        List<UserWorkPlace> list = JsonUtils.jsonToList((String)map.get("workplaceList"),UserWorkPlace.class);
        String userDetailId = (String)map.get("userDetailId");
        return userDetailService.saveOrUpdateUserWorkPlace(list,userDetailId);
    }

}
