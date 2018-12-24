package jll.user.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.User;
import jll.model.User_Role_Middle;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao extends SimpleHibernateTemplate<User> {

    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = 1L;

    /**
     * 获取用户的用户名与密码数据 @Title: loginRole @Description:
     * TODO(这里用一句话描述这个方法的作用) @param @return 设定文件 @return
     * List<Map<String,Object>> 返回类型 @throws
     */
    @SuppressWarnings("unchecked")
    public List queryUserUnPwList(String username, String password) {

        StringBuffer sql = new StringBuffer();
        sql.append(" select username,password from org_user_account user where 1=1 and isDelete='0'  ");
        sql.append(" and user.username='" + username + "' ");
        sql.append(" and user.password='" + password + "' ");

        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();

    }

    /**
     * 获取用户菜单权限
     *
     * @param username
     * @param password
     * @return
     */
    public List findUserRoleList(String username, String password) {
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT                                                                                      ");
        sql.append(" 	upermission.*                                                                              ");
        sql.append(" FROM                                                                                        ");
        sql.append(" 	org_user_account USER                                                                      ");
        sql.append(" LEFT JOIN org_user_role_middle urmiddle ON USER .user_id = urmiddle.user_id                 ");
        sql.append(" LEFT JOIN org_user_role_detail usdetail ON urmiddle.role_id = usdetail.role_id              ");
        sql.append(" LEFT JOIN org_role_permission_middle rpmiddle ON usdetail.role_id = rpmiddle.role_id        ");
        sql.append(" LEFT JOIN org_user_permission upermission ON rpmiddle.permission_id = upermission.permission_id   ");
        sql.append(" WHERE                                                                                       ");
        sql.append(" 	1 = 1                                                                                      ");
        sql.append(" AND USER .isDelete = '0'                                                                    ");
        sql.append(" AND USER .username = '" + username + "'                                                               ");
        sql.append(" ORDER BY sort ASC ");

        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();

    }

    /**
     * 账号校验
     */
    public List checkData(String username){
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT                                                                                      ");
        sql.append(" 	USER.*                                                                              ");
        sql.append(" FROM                                                                                        ");
        sql.append(" 	org_user_account USER                                                                      ");
        sql.append(" WHERE                                                                                       ");
        sql.append(" 	1 = 1                                                                                      ");
        sql.append(" AND USER .username = '" + username + "'                                                               ");

        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }

    /**
     * 插入用户信息
     *
     * @param user
     */
    public void addUser(User user) {
        this.getSession().saveOrUpdate(user);
    }

    /**
     * 插入默认角色
     *
     * @param user_role_middle
     */
    public void addUserRole(User_Role_Middle user_role_middle) {
        /*StringBuffer sql = new StringBuffer();
        sql.append(" INSERT INTO                                                                                      ");
        sql.append(" 	org_user_role_middle(role_id,user_id)                                                                              ");
        sql.append(" VALUES(" + "1" + "," + user.getUser_id() + ")");
        Query query = this.getSession().createSQLQuery(sql.toString());
        return query.executeUpdate();*/
        this.getSession().saveOrUpdate(user_role_middle);
    }

    /**根据输入的用户名查询用户信息
     * @param username
     * @return
     */
    public List findUserByUserName(String username){
        StringBuffer sql = new StringBuffer();
        sql.append(" select user_id,iphone,username,head_portrait_image,nickname,email,realname,province_id,city_id,area_id,personalSignature,idcard,user_detail_id,authentication_id,authentication_type,org_user_role_middle from org_user_account user where 1=1 and isDelete='0'  ");
        if (!"".equals(username) && null != username) {
            sql.append(" and user.username='" + username + "' ");
        }

        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }

    //更新数据库用户密码
    public int updateUser(User user){
        StringBuffer sql = new StringBuffer();
        sql.append("UPDATE org_user_account SET password = ? WHERE username = ?");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setParameter(1,user.getUsername());
        query.setParameter(0,user.getPassword());
        return query.executeUpdate();
    }

    //修改手机号
    public int updateUserPhone(String phonenum,String userId){
        StringBuffer sql = new StringBuffer();
        sql.append("UPDATE org_user_account SET username = '" + phonenum + "', iphone = '" + phonenum + "' WHERE user_id = '" + userId + "'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        return query.executeUpdate();
    }

    //更新用户信息
    public int updateUserAccount(User user){
        StringBuffer sql = new StringBuffer();
        sql.append("UPDATE org_user_account SET    ");
        if (!"".equals(user.getHead_portrait_image()) && null != user.getHead_portrait_image()) {
            sql.append("head_portrait_image = '"+ user.getHead_portrait_image() + "',");
        }
        if (!"".equals(user.getNickname()) && null != user.getNickname()) {
            sql.append("nickname = '"+user.getNickname()+"',");
        }
        if (!"".equals(user.getEmail()) && null != user.getEmail()) {
            sql.append("email = '"+user.getEmail()+"',");
        }
        if (!"".equals(user.getRealname()) && null != user.getRealname()) {
            sql.append("realname = '"+user.getRealname()+"',");
        }
        if (!"".equals(user.getIdcard()) && null != user.getIdcard()) {
            sql.append("idcard = '"+user.getIdcard()+"',");
        }
        if (!"".equals(user.getProvince_id()) && 0 != user.getProvince_id()) {
            sql.append("province_id = '"+user.getProvince_id()+"',");
        }
        if (!"".equals(user.getCity_id()) && 0 != user.getCity_id()) {
            sql.append("city_id = '"+user.getCity_id()+"',");
        }
        if (!"".equals(user.getArea_id()) && 0 != user.getArea_id()) {
            sql.append("area_id = '"+user.getArea_id()+"',");
        }
        if (!"".equals(user.getPersonalSignature()) && null != user.getPersonalSignature()) {
            sql.append("personalSignature = '"+user.getPersonalSignature()+"',");
        }
        if (!"".equals(user.getUser_detail_id()) && null != user.getUser_detail_id()) {
            sql.append("user_detail_id = '"+user.getUser_detail_id()+"',");
        }
        if (!"".equals(user.getUser_detail_id()) && null != user.getUser_detail_id()) {
            sql.append("user_detail_id = '"+user.getUser_detail_id()+"',");
        }
        if (!"".equals(user.getAuthentication_id()) && null != user.getAuthentication_id()) {
            sql.append("authentication_id = '"+user.getAuthentication_id()+"',");
        }
        if (!"".equals(user.getAuthentication_type()) && null != user.getAuthentication_type()) {
            sql.append("authentication_type = '"+user.getAuthentication_type()+"',");
        }
        if (!"".equals(user.getOrg_user_role_middle()) && null != user.getOrg_user_role_middle()) {
            sql.append("org_user_role_middle = '"+user.getOrg_user_role_middle()+"',");
        }
       sql.replace(sql.length() - 1, sql.length(), "");
        sql.append(" WHERE user_id = '" + user.getUser_id() +"' ");

        Query query = this.getSession().createSQLQuery(sql.toString());
        return query.executeUpdate();

        }

    /**
     * 用户表findUserIdByAuthId
     * 根据认证ID查询用户ID
     */
    public List findUserIdByAuthId(String authId) {
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT                                                                                      ");
        sql.append(" 	u.user_id                                                                             ");
        sql.append(" FROM                                                                                        ");
        sql.append(" 	org_user_account u                                                                      ");
        sql.append(" WHERE                                                                                       ");
        sql.append(" 	1 = 1                                                                                      ");
        sql.append(" AND u .isDelete = '0'                                                                    ");
        sql.append(" AND u .authentication_id = '" + authId + "'                                                               ");

        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();

    }

}
