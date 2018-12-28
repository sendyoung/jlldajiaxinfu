package jll.userdetail.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.userdetail.UserDetail;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class UserDetailDao extends SimpleHibernateTemplate<UserDetail> {


    /**
     * 个人信息填报回显
     *
     * 查询org_user_account用户表中是否有user_detail_id,(登录信息中有,前端进行判断)
     * 如果没有则查询用户表中的真实姓名和身份证号(在前端进行判断,登陆后就有这两条数据)
     * 如果有则关联用户表和用户详情信息表的数据进行回显
     */

    /**
     *回显用户详情信息数据
     */
    public List findPersonalInformationDetails(String userDetailId) {
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT                                                                                      ");
        sql.append(" 	userdetail.*                                                                              ");
        sql.append(" FROM                                                                                        ");
        sql.append(" 	org_user_detail userdetail                                                                ");
        sql.append(" WHERE                                                                                       ");
        sql.append(" 1 = 1        ");
        sql.append(" AND userdetail.isDelete = '0'                                                                                      ");
        sql.append(" AND userdetail .user_detail_id = '" + userDetailId + "'                                                               ");

        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }

    /**
     *  新增或更新用户个人信息
     */
    public String saveUserDetails(UserDetail userDetail){
        //this.save(userDetail);
        String id =UUID.randomUUID().toString().replace("-","");
        StringBuffer sql = new StringBuffer();
        sql.append(" INSERT INTO org_user_detail(user_detail_id,sex,corresponding_address,emergency_contact,home_address,contact_email,emergency_contact_tel,registered_residence_address,marriage,political_outlook,social_groups,weight,height,blood_type,nation,birthday,isDelete)");
        sql.append(" VALUES( '" + id + "','" + userDetail.getSex() + "','" +  userDetail.getCorresponding_address() + "','" + userDetail.getEmergency_contact() + "','" + userDetail.getHome_address() + "','" + userDetail.getContact_email() + "','" + userDetail.getEmergency_contact_tel() + "','" + userDetail.getRegistered_residence_address() + "','" + userDetail.getMarriage() + "','" + userDetail.getPolitical_outlook() + "','" + userDetail.getSocial_groups() + "','" + userDetail.getWeight() + "','" + userDetail.getHeight() + "','" + userDetail.getBlood_type() + "','" + userDetail.getNation() + "','" + userDetail.getBirthday() + "','0')");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.executeUpdate();
        return id;
    }
   /* public String saveOrUpdateUserDetails(UserDetail userDetail){
        if(userDetail.getUser_detail_id()!=null && !"".equals(userDetail.getUser_detail_id())){
            //this.getSession().saveOrUpdate(userDetail);
            this.getSession().update(userDetail);
        }else{
            //this.save(userDetail);
            StringBuffer sql = new StringBuffer();
           sql.append(" INSERT INTO org_user_detail(user_detail_id,sex,corresponding_address,emergency_contact,home_address,contact_email,emergency_contact_tel,registered_residence_address,marriage,political_outlook,social_groups,weight,height,blood_type,nation,birthday,isDelete)");
           sql.append(" VALUES( '" +UUID.randomUUID().toString().replace("-","") + "','" + userDetail.getSex() + "','" +  userDetail.getCorresponding_address() + "','" + userDetail.getEmergency_contact() + "','" + userDetail.getHome_address() + "','" + userDetail.getContact_email() + "','" + userDetail.getEmergency_contact_tel() + "','" + userDetail.getRegistered_residence_address() + "','" + userDetail.getMarriage() + "','" + userDetail.getPolitical_outlook() + "','" + userDetail.getSocial_groups() + "','" + userDetail.getWeight() + "','" + userDetail.getHeight() + "','" + userDetail.getBlood_type() + "','" + userDetail.getNation() + "','" + userDetail.getBirthday() + "','0')");

        }
        return userDetail.getUser_detail_id();
    }*/

    /**
     * 更新用户个人信息
     */
    public void updateUserDetails(UserDetail userDetail){
        this.getSession().update(userDetail);
    }

}
