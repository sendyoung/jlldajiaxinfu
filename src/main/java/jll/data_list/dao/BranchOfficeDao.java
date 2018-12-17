package jll.data_list.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.data_list.BranchOffice;
import jll.model.data_list.Employee;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

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
        List<BranchOffice> list=query.list();
        if(list==null){
            return null;
        }
        return (BranchOffice)query.list().get(0);
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

}
