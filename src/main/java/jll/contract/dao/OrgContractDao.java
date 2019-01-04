package jll.contract.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.contract.OrgContract;
import jll.utils.MapTrunPojo;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class OrgContractDao extends SimpleHibernateTemplate<OrgContract> {
    private static final long serialVersionUID = 1L;
    /**
     * 查询组织合同
     * */
    public OrgContract queryOrgContractByAuthOrgId(String authOrgId,String type){
        StringBuffer sql = new StringBuffer();
        sql.append("select org_contract_id,auth_org_id,content,url,type from ent_org_contract where auth_org_id='"+authOrgId+"'  ");
        if(type!=null&&!type.equals("")){
            sql.append(" and type='"+type+"' ");
        }
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List list=query.list();
        if(list==null||list.size()==0){
            return null;
        }
        OrgContract contract=(OrgContract)MapTrunPojo.map2Object((Map)list.get(0),OrgContract.class);
        return contract;
    }
}
