package jll.public_infomation.dao;


import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * 查询数据库
 */
@Repository
public class IndexInfoDao extends SimpleHibernateTemplate<Object> {


    /**
     * 查询
     * @return
     */
    public List queryIndexData(){
        ArrayList list = new ArrayList();
        StringBuffer sq1 = new StringBuffer();
        sq1.append("select * from org_infomation_publicty where 1=1 and publicty_type=1");
        Query query1 = this.getSession().createSQLQuery(sq1.toString());
        query1.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
//        System.out.println("打印查询出来的结果1:"+query1.list());

        StringBuffer sq2 = new StringBuffer();
        sq2.append("select * from org_infomation_publicty where 1=1 and publicty_type=2");
        Query query2 = this.getSession().createSQLQuery(sq2.toString());
        query2.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
//        System.out.println("打印查询出来的结果2:"+query2.list());

        StringBuffer sq3 = new StringBuffer();
        sq3.append("select * from org_infomation_publicty where 1=1 and publicty_type=3");
        Query query3 = this.getSession().createSQLQuery(sq3.toString());
        query3.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
//        System.out.println("打印查询出来的结果3:"+query3.list());

        StringBuffer sq4 = new StringBuffer();
        sq4.append("select * from org_infomation_publicty where 1=1 and publicty_type=4");
        Query query4 = this.getSession().createSQLQuery(sq4.toString());
        query4.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
//        System.out.println("打印查询出来的结果4:"+query4.list());


        list.add(query1.list());
        list.add(query2.list());
        list.add(query3.list());
        list.add(query4.list());

        return list;


    }




}
