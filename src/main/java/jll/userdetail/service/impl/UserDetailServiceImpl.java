package jll.userdetail.service.impl;

import jll.model.User;
import jll.model.userdetail.UserDetail;
import jll.model.userdetail.UserEducation;
import jll.model.userdetail.UserFamily;
import jll.model.userdetail.UserWorkPlace;
import jll.user.dao.UserDao;
import jll.userdetail.dao.UserDetailDao;
import jll.userdetail.service.UserDetailService;
import jll.utils.MapTrunPojo;
import jll.utils.XinfuResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("userDetailService")
@Transactional
public class UserDetailServiceImpl implements UserDetailService {

    @Autowired
    private UserDetailDao userDetailDao;
    @Autowired
    private UserDao userDao;

    //回显个人详情信息
    @Override
    public UserDetail findPersonalInformationDetails(String userDetailId) {
       List list = userDetailDao.findPersonalInformationDetails(userDetailId);
        if (list != null && list.size() > 0) {
            Map map = (Map) list.get(0);
            UserDetail userDetail = (UserDetail) MapTrunPojo.map2Object(map, UserDetail.class);
            return userDetail;
        }
        return null;
    }

    //回显家庭成员信息
    @Override
    public List findUserFamilyDetails(String userDetailId) {
       List list =  userDetailDao.findUserFamilyDetails(userDetailId);
       if(list!=null && list.size()>0){
           List list2 = new ArrayList();
           for (Object obj:list){
               Map map = (Map)obj;
               UserFamily userFamily = (UserFamily)MapTrunPojo.map2Object(map,UserFamily.class);
               list2.add(userFamily);
           }
           return list2;
       }
        return null;
    }

    //回显教育经历
    @Override
    public List findUserEducation(String userDetailId) {
        List list = userDetailDao.findUserEducation(userDetailId);
        if(list!=null && list.size()>0){
            List list2 = new ArrayList();
            for (Object obj:list){
                Map map = (Map)obj;
                UserEducation userEducation = (UserEducation)MapTrunPojo.map2Object(map,UserEducation.class);
                list2.add(userEducation);
            }
            return list2;
        }
        return null;
    }

    //回显职场履历
    @Override
    public List findUserWorkPlace(String userDetailId) {
        List list = userDetailDao.findUserWorkPlace(userDetailId);
        if(list!=null && list.size()>0){
            List list2 = new ArrayList();
            for (Object obj:list){
                Map map = (Map)obj;
                UserWorkPlace userWorkPlace = (UserWorkPlace)MapTrunPojo.map2Object(map,UserWorkPlace.class);
                list2.add(userWorkPlace);
            }
            return list2;
        }
        return null;
    }

    //新增或更新个人详情信息
    @Override
    public XinfuResult saveOrUpdateUserDetails(UserDetail userDetail,String userId){
        try {
            userDetailDao.saveOrUpdateUserDetails(userDetail);
            //将新增后得到的主键存入用户表中
            User user = new User();
            //将当前用户的id存入实体类,根据id将对应的用户详情信息主键存入用户表中
            user.setUser_id(userId);
            user.setUser_detail_id(userDetail.getUser_detail_id());
            userDao.updateUserAccount(user);
            return XinfuResult.build(20,"新增或更新详情信息成功");
        } catch (Exception e) {
            e.printStackTrace();
            return XinfuResult.build(400,"新增或更新详情信息失败");
        }
    }

    //新增或更新家庭成员信息
    @Override
    public XinfuResult saveOrUpdateUserFamily(List<UserFamily> list,String userDetailId){
        try {
            if(list!=null&&list.size()>0){
                for (UserFamily userFamily:list) {
                    userFamily.setUser_detail_id(userDetailId);
                    userDetailDao.saveOrUpdateUserFamily(userFamily);
                }
                return XinfuResult.build(200,"新增或更新家庭成员信息成功");
            }
            return XinfuResult.build(401,"你提交的数据为空,请输入数据后再进行提交");
        } catch (Exception e) {
            e.printStackTrace();
            return XinfuResult.build(400,"新增或更新家庭成员信息失败");
        }
    }
    //新增或更新教育经历
    @Override
    public XinfuResult saveOrUpdateUserEducation(List<UserEducation> list,String userDetailId){
        try {
            if(list!=null&&list.size()>0){
                for (UserEducation userEducation : list){
                    userEducation.setUser_detail_id(userDetailId);
                    userDetailDao.saveOrUpdateUserEducation(userEducation);
                }
                return XinfuResult.build(200,"新增或更新教育经历成功");
            }
            return XinfuResult.build(401,"你提交的数据为空,请输入数据后再进行提交");
        } catch (Exception e) {
            e.printStackTrace();
            return XinfuResult.build(400,"新增或更新教育经历失败");
        }
    }
    //新增或更新职场履历
    @Override
    public XinfuResult saveOrUpdateUserWorkPlace(List<UserWorkPlace> list,String userDetailId){
        try {
            if(list!=null&&list.size()>0){
                for (UserWorkPlace userWorkPlace : list){
                    userWorkPlace.setUser_detail_id(userDetailId);
                    userDetailDao.saveOrUpdateUserWorkPlace(userWorkPlace);
                }
                return XinfuResult.build(200,"新增或更新职场履历成功");
            }
            return XinfuResult.build(401,"你提交的数据为空,清输入数据后在进行提交");

        } catch (Exception e) {
            e.printStackTrace();
            return XinfuResult.build(400,"新增或更新职场履历失败");
        }
    }
}