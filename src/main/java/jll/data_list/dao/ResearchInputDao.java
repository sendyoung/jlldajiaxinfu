package jll.data_list.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.data_list.ResearchInput;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ResearchInputDao extends SimpleHibernateTemplate<ResearchInput> {

    private static final long serialVersionUID = 1L;
    /**
     * period年度
     * 查询研发投入信息
     * */
    public ResearchInput queryResearchInputForPeriod(String entId,Integer period){
        StringBuffer sql = new StringBuffer();
        sql.append(" select eri.* from ent_research_input eri where 1=1 and period='"+period+"' and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List<ResearchInput> list=query.list();
        if(list==null){
            return null;
        }
        return (ResearchInput)query.list().get(0);
    }

    /**
     * 添加研发投入信息
     * */
    public void saveResearchInput(ResearchInput researchInput){
        if(researchInput.getResearch_input_id()!=null&&!researchInput.getResearch_input_id().equals("")){
            this.getSession().saveOrUpdate(researchInput);
        }else{
            this.getSession().save(researchInput);
        }
    }

}
