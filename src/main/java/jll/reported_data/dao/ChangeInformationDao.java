package jll.reported_data.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.BasicPnformationSubmit.ChangeRecord;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 */
@Repository
public class ChangeInformationDao extends SimpleHibernateTemplate<ChangeRecord> {
    /**
     * 增加变更记录信息
     */
    public void addChangeInformation(ChangeRecord changeRecord){


        this.getSession().merge(changeRecord);
//        if (changeRecord.getId()!=null&&changeRecord.getId().equals("")){
//            this.getSession().saveOrUpdate(changeRecord);
//        }else {
//            this.getSession().merge(changeRecord);
//        }
//        System.out.println("执行增加变更记录信息dao层!");
////
//        if(changeRecord.getId()!=null&&!changeRecord.getId().equals("")){
//            this.getSession().saveOrUpdate(changeRecord);
//        }else{
//            this.getSession().save(changeRecord);
//        }

    }



    /**
     * 查询变更记录信息
     */
    public List queryChangeInformation(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append("select * from ent_change_record where 1=1 and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();

    }


}
