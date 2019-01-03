package jll.data_list.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.data_list.BranchOffice;
import jll.utils.MapTrunPojo;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class BranchOfficeDao extends SimpleHibernateTemplate<BranchOffice> {

    private static final long serialVersionUID = 1L;
    /**
     * name公司名称
     * 查询分公司信息
     * */
    public BranchOffice queryBranchOfficeForName(String entId,String name){
        StringBuffer sql = new StringBuffer();
        sql.append(" select ebo.* from ent_branch_office ebo where 1=1 and branch_name='"+name+"' and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List list=query.list();
        if(list==null){
            return null;
        }
        BranchOffice bo=(BranchOffice) MapTrunPojo.map2Object((Map)list.get(0),BranchOffice.class);
        return bo;
    }

    /**
     * 添加分公司信息
     * */
    public void saveBranchOffice(BranchOffice branchOffice){
        if(branchOffice.getBranch_office_id()!=null&&!branchOffice.getBranch_office_id().equals("")){
            this.getSession().saveOrUpdate(branchOffice);
        }else{
            this.getSession().save(branchOffice);
        }
    }
    /**
     * 查询分公司信息
     * */
    public List queryBranchOfficeByEntId(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append(" select ebo.branch_name,ebo.regin_code,pa.full_name,ebo.representative,ebo.claff_sum,ebo.taking " +
                " from ent_branch_office ebo left join public_area pa on pa.code=ebo.regin_code " +
                " where 1=1 and ebo.ent_id='"+entId+"' ");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }

}
