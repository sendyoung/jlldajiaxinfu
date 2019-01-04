package jll.contract.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.contract.Contract;
import jll.utils.MapTrunPojo;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ContractDao extends SimpleHibernateTemplate<Contract> {
    private static final long serialVersionUID = 1L;
    /**
     * 查询平台合同
     * */
    public Contract queryContractByContractId(String contractId){
        StringBuffer sql = new StringBuffer();
        sql.append("select contract_id,content,url from ent_contract where 1=1  ");
        if(contractId!=null&&!contractId.equals("")){
            sql.append(" and contract_id='"+contractId+"' ");
        }
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List list=query.list();
        if(list==null||list.size()==0){
            return null;
        }
        Contract contract=(Contract)MapTrunPojo.map2Object((Map)list.get(0),Contract.class);
        return contract;
    }
}
