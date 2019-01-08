package jll.reported_data.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.basic_pnformation_submit.InnovationAbility;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CreativityDao extends SimpleHibernateTemplate<InnovationAbility> {
    /**
     * 增加创新能力
     */
    public void addCreativity(InnovationAbility innovationAbility){
        System.out.println("执行增加变更记录信息dao层!");
        this.getSession().merge(innovationAbility);
    }


    /**
     * 查询创新能力
     */
    public List queryCreativity(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append("select * from ent_innovation_ability where 1=1 and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();

    }
}
