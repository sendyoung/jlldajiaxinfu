package jll.userdetail.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.userdetail.UserDetail;
import jll.model.userdetail.UserEducation;
import jll.model.userdetail.UserFamily;
import jll.model.userdetail.UserWorkPlace;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

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
     *回显家庭成员信息
     */
    public List findUserFamilyDetails(String userDetailId){
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT          ");
        sql.append(" userfamily.*              ");
        sql.append(" FROM        ");
        sql.append("  org_user_family_member userfamily  ");
        sql.append( " WHERE       ");
        sql.append( "  1 = 1                ");
        sql.append( " AND userfamily.isDelete = '0'            ");
        sql.append( "AND userfamily.user_detail_id = '" + userDetailId + "'   ");

        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }

    /**
     * 回显教育经历
     */
    public List findUserEducation(String userDetailId){
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT          ");
        sql.append(" usereducation.*              ");
        sql.append(" FROM        ");
        sql.append("  org_user_education usereducation  ");
        sql.append( " WHERE       ");
        sql.append( "  1 = 1                ");
        sql.append( " AND usereducation.isDelete = '0'            ");
        sql.append( "AND usereducation.user_detail_id = '" + userDetailId + "'   ");

        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }

    /**
     * 回显职场履历
     */
    public List findUserWorkPlace(String userDetailId){
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT          ");
        sql.append(" userworkplace.*              ");
        sql.append(" FROM        ");
        sql.append("  org_user_workplace userworkplace  ");
        sql.append( " WHERE       ");
        sql.append( "  1 = 1                ");
        sql.append( " AND userworkplace.isDelete = '0'            ");
        sql.append( "AND userworkplace.user_detail_id = '" + userDetailId + "'   ");

        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }

    /**
     *  新增或更新用户个人信息
     */
    public void saveOrUpdateUserDetails(UserDetail userDetail){
        this.getSession().saveOrUpdate(userDetail);
    }

    /**
     * 新增或更新用户家庭成员信息
     */
    public void saveOrUpdateUserFamily(UserFamily userFamily){
        this.getSession().saveOrUpdate(userFamily);
    }

    /**
     * 新增或更新用户教育经历
     */
    public void saveOrUpdateUserEducation(UserEducation userEducation){
        this.getSession().saveOrUpdate(userEducation);
    }

    /**
     * 新增或更新用户职场履历
     */
    public void saveOrUpdateUserWorkPlace(UserWorkPlace userWorkplace){
        this.getSession().saveOrUpdate(userWorkplace);
    }

    /**
     * 插入或更新用户个人信息以及家庭成员信息
     *
     * 如果org_user_account用户表中没有user_detail_id用户详情信息主键信息(说明没有进行过填报),
     * 提交个人信息填报功能时向用户详情信息表中插入一条数据并将user_detail_id放入用户表中
     *
     * 添加家庭成员信息的时候首先循环家庭成员信息数据集合
     * 判断每条数据中是否有用户详情信息主键,如果有的话则对该条数据执行update语句,
     * 如果没有则插入对应的用户详情信息主键id并执行插入语句
     *
     */



    /**
     *       StringBuffer sql = new StringBuffer();
     *         sql.append("UPDATE org_user_account SET password = ? WHERE username = ?");
     *         Query query = this.getSession().createSQLQuery(sql.toString());
     *         query.setParameter(1,user.getUsername());
     *         query.setParameter(0,user.getPassword());
     *         return query.executeUpdate();
     */

}
