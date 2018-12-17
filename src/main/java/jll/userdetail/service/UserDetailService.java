package jll.userdetail.service;

import jll.model.userdetail.UserDetail;
import jll.model.userdetail.UserEducation;
import jll.model.userdetail.UserFamily;
import jll.model.userdetail.UserWorkPlace;
import jll.utils.XinfuResult;

import java.util.List;

public interface UserDetailService {

    //回显个人详情信息
    public UserDetail findPersonalInformationDetails(String userDetailId);
    //回显家庭成员信息
    public List findUserFamilyDetails(String userDetailId);
    //回显教育经历
    public List findUserEducation(String userDetailId);
    //回显工作履历
    public List findUserWorkPlace(String userDetailId);
    //新增或更新个人详情信息
    public XinfuResult saveOrUpdateUserDetails(UserDetail userDetail,String userId);
    //新增或更新家庭成员信息
    public XinfuResult saveOrUpdateUserFamily(List<UserFamily> list,String userDetailId);
    //新增或更新教育经历
    public XinfuResult saveOrUpdateUserEducation(List<UserEducation> list,String userDetailId);
    //新增或更新职场履历
    public XinfuResult saveOrUpdateUserWorkPlace(List<UserWorkPlace> list,String userDetailId);
}
