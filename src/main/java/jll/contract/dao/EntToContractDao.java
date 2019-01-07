package jll.contract.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.contract.EntToContract;
import jll.utils.MapTrunPojo;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class EntToContractDao extends SimpleHibernateTemplate<EntToContract> {
    private static final long serialVersionUID = 1L;
    /**
     * 查询企业跟平台签订的合同
     * */
    public EntToContract queryEntToContractByAuthEnterpriseId(String authEnterpriseId,String contractId){
        StringBuffer sql = new StringBuffer();
        sql.append("select to_contract_id,contract_id,auth_enterprise_id from ent_to_contract where auth_enterprise_id='"+authEnterpriseId+"' and  contract_id='"+contractId+"' ");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List list=query.list();
        if(list==null||list.size()==0){
            return null;
        }
        EntToContract etc=(EntToContract)MapTrunPojo.map2Object((Map)list.get(0),EntToContract.class);
        return etc;
    }
    /**
     * 添加合同
     * */
    public void saveEntToContract(EntToContract entToContract){
        this.getSession().save(entToContract);
    }
}
