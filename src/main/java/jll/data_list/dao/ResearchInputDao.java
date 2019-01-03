package jll.data_list.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.data_list.ResearchInput;
import jll.utils.MapTrunPojo;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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
        List list=query.list();
        if(list==null||list.size()==0){
            return null;
        }
        ResearchInput ri=(ResearchInput)MapTrunPojo.map2Object((Map)list.get(0),ResearchInput.class);
        return ri;
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
