package jll.organization_creditInformation.dao.year;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.org_organization.BlueBook;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 蓝皮书
 */
@Repository
public class BlueBookDao extends SimpleHibernateTemplate<Object> {

    /**
     * 添加 蓝皮书
     */
    public void addBlueBook(BlueBook blueBook){
        this.getSession().save(blueBook);
    }

    /**
     * 查询蓝皮书
     */
    public List queryBlueBook(String auth_org_id){
        StringBuffer sq = new StringBuffer();
        sq.append("select * from org_blue_book where 1=1 and auth_org_id='"+auth_org_id+"'");
        Query query = this.getSession().createSQLQuery(sq.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        System.out.println("打印蓝皮书 查询出来的结果:"+query.list());

        return query.list();
    }
}
