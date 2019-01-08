package jll.reported_data.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.BasicPnformationSubmit.ContactPersonnel;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContactStaffDao extends SimpleHibernateTemplate<ContactPersonnel> {
    /**
     * 增加联系人员填报
     */
    public void addContactStaff(ContactPersonnel contactPersonnel){
        System.out.println("执行增加变更记录信息dao层!");
        this.getSession().merge(contactPersonnel);
    }


    /**
     * 查询联系人员填报
     */
    public List queryContactStaff(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append("select * from ent_contact_personne where 1=1 and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();

    }
}
