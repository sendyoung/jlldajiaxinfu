package jll.userdetail.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.userdetail.UserEducation;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserEducationDao extends SimpleHibernateTemplate<UserEducation> {
    /**
     * 回显教育经历
     */
    public List findUserEducation(String userId){
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT          ");
        sql.append(" usereducation.*              ");
        sql.append(" FROM        ");
        sql.append("  org_user_education usereducation  ");
        sql.append( " WHERE       ");
        sql.append( "  1 = 1                ");
        sql.append( " AND usereducation.isDelete = '0'            ");
        sql.append( "AND usereducation.user_id = '" + userId + "'   ");

        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }

    /**
     * 新增或更新用户教育经历
     */
    public void saveOrUpdateUserEducation(UserEducation userEducation){
        if(userEducation.getUser_education_id()!=null&&!"".equals(userEducation.getUser_education_id())){
            this.getSession().update(userEducation);
        }else{
            this.getSession().save(userEducation);
        }
    }

}
