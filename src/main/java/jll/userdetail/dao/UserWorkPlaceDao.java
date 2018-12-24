package jll.userdetail.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.userdetail.UserWorkPlace;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserWorkPlaceDao extends SimpleHibernateTemplate<UserWorkPlace> {
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
     * 新增或更新用户职场履历
     */
    public void saveOrUpdateUserWorkPlace(UserWorkPlace userWorkplace){
        this.getSession().saveOrUpdate(userWorkplace);
    }

}
