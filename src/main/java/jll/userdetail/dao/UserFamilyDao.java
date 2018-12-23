package jll.userdetail.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.userdetail.UserFamily;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserFamilyDao extends SimpleHibernateTemplate<UserFamily> {

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
     * 新增或更新用户家庭成员信息
     */
    public void saveOrUpdateUserFamily(UserFamily userFamily){
        this.getSession().saveOrUpdate(userFamily);
    }

}
