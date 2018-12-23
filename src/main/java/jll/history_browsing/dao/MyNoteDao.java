package jll.history_browsing.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.history_browsing.MyNotes;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MyNoteDao extends SimpleHibernateTemplate<MyNotes> {
    //查看笔记
    public List findNoteList(String userId){
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT                                                                                      ");
        sql.append(" 	myNotes.*                                                                              ");
        sql.append(" FROM                                                                                        ");
        sql.append(" 	org_my_notes myNotes                                                                ");
        sql.append(" WHERE                                                                                       ");
        sql.append(" 1 = 1        ");
        sql.append(" AND myNotes.isDelete = '0'                                                                                      ");
        sql.append(" AND myNotes .user_id = '" + userId + "'                                                               ");

        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }

    //添加笔记
    public void addNewNote(MyNotes myNotes){
        this.getSession().save(myNotes);
    }

    //修改笔记
    public int updateMyNote(String note_content,String note_id){
        StringBuffer sql = new StringBuffer();
        sql.append(" UPDATE org_my_notes SET note_content = '" +note_content + "' " );
        sql.append(" WHERE note_id = '" + note_id + "' ");
        Query query = this.getSession().createSQLQuery(sql.toString());
        return query.executeUpdate();
    }

    //删除笔记
    public int deleteMyNote(String note_id){
        StringBuffer sql = new StringBuffer();
        sql.append(" UPDATE org_my_notes SET isDelete = '1' " );
        sql.append(" WHERE note_id = '" + note_id + "' ");
        Query query = this.getSession().createSQLQuery(sql.toString());
        return query.executeUpdate();
    }

}
