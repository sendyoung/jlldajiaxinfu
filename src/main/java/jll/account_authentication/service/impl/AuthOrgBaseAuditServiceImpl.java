package jll.account_authentication.service.impl;

import com.cn.zyzs.utils.utils.PageView;
import jll.account_authentication.dao.AuthOrgBaseDao;
import jll.account_authentication.dao.ExamineOrgDefaultDataDao;
import jll.account_authentication.service.AuthOrgBaseAuditService;
import jll.user.dao.UserDao;
import jll.user.dao.UserRoleMiddleDao;
import jll.utils.HibernatePageUtil;
import jll.utils.XinfuResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//组织认证审核
@Service("authOrgBaseAuditService")
@Transactional
public class AuthOrgBaseAuditServiceImpl implements AuthOrgBaseAuditService {

    @Autowired
    private AuthOrgBaseDao authOrgBaseDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserRoleMiddleDao userRoleMiddleDao;
    @Autowired
    private ExamineOrgDefaultDataDao examineOrgDefaultDataDao;

    //查看待审核的的组织认证列表
    @Override
    public PageView findAuthOrgBaseAuditList(String orgName, String authTime, String creditCode, int currentPage, int rows) {
        return HibernatePageUtil.sqlPageUtil(authOrgBaseDao.findAuthOrgBaseAuditList(orgName,authTime,creditCode),currentPage,rows);
    }

    /**
     * 暂时没有用到
     * ①修改用户信息中的认证类型为(2 企业认证通过 ,4 组织认证通过,5 企业认证驳回,6 组织认证驳回)    根据用户ID
     * ②修改用户信息中的用户类型为2 企业用户 3 组织用户  (不通过则不修改)       根据用户ID
     */
    public XinfuResult updateUserAuthType(String userId,String authType){
        try {
            userDao.updateUserAuthType(userId,authType);
            return XinfuResult.build(200,"修改用户认证类型或用户类型成功");
        } catch (Exception e) {
            e.printStackTrace();
            return XinfuResult.build(400,"修改用户认证类型或用户类型失败");
        }
    }

    /**
     * 没用到
     * 通过审核后修改用户角色(2 企业 3 组织)  根据用户ID
     */
    public XinfuResult updateUserRoleMiddle(String userId,String roleId){
        try {
            userRoleMiddleDao.updateUserRoleMiddle(userId,roleId);
            return XinfuResult.build(200,"修改用户角色信息成功");
        } catch (Exception e) {
            e.printStackTrace();
            return XinfuResult.build(400,"修改用户角色信息失败");
        }
    }

    /**
     * 审核组织认证
     */
    @Override
    public XinfuResult examineOrg(String userId){
        try {

            //通过(组织认证通过状态为4
            //if(authType == "4"){
                //修改认证类型和用户类型
                userDao.updateUserAuthType(userId,"4");
                //修改用户角色
                userRoleMiddleDao.updateUserRoleMiddle(userId,"3");
                return XinfuResult.build(200,"认证通过,恭喜你已成为组织用户");
           // }
            //不通过(组织认证驳回状态为6
            /*if(authType == "6"){
                //修改认证类型为组织已驳回
                userDao.updateUserAuthType(userId,authType);
                return XinfuResult.build(300,"认证不通过,请重新来过");
            }
            return XinfuResult.build(400,"参数异常");*/
        } catch (Exception e) {
            e.printStackTrace();
            return XinfuResult.build(400,"程序运行出现问题了呢");
        }
    }

    /**
     * 添加默认数据
     */
    @Override
    public XinfuResult addDefualtData(String authOrgId) {

        try {
            //添加默认职务
            examineOrgDefaultDataDao.addDefaultPost(authOrgId,"会长");
            examineOrgDefaultDataDao.addDefaultPost(authOrgId,"名誉会长");
            examineOrgDefaultDataDao.addDefaultPost(authOrgId,"副会长");
            examineOrgDefaultDataDao.addDefaultPost(authOrgId,"独立监事");
            //添加默认组织机构
            String first = examineOrgDefaultDataDao.addDefaultStruture(authOrgId,"0","会员代表大会");
            String second = examineOrgDefaultDataDao.addDefaultStruture(authOrgId,first,"理事会");
            String third = examineOrgDefaultDataDao.addDefaultStruture(authOrgId,second,"常务理事会");
            String fourth = examineOrgDefaultDataDao.addDefaultStruture(authOrgId,third,"监事会");
            examineOrgDefaultDataDao.addDefaultStruture(authOrgId,fourth,"分支机构");
            examineOrgDefaultDataDao.addDefaultStruture(authOrgId,fourth,"秘书处");
            examineOrgDefaultDataDao.addDefaultStruture(authOrgId,fourth,"专家委员会");
            return XinfuResult.build(200,"添加默认数据成功");
        } catch (Exception e) {
            e.printStackTrace();
            return XinfuResult.build(400,"添加默认数据失败");
        }

    }
}
