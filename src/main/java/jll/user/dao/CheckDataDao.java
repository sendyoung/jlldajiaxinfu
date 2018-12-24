package jll.user.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.CheckDataCode;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class CheckDataDao extends SimpleHibernateTemplate<CheckDataCode> {

    /**
     * 插入一条随机码
     */
    public String addCheckCode(String codeValue){
        StringBuffer sql = new StringBuffer();
        String codeId = UUID.randomUUID().toString().replace("-","");
        sql.append("INSERT INTO system_check_code(code_id,code_value,create_time,status) ");
        sql.append(" VALUES('" + codeId + "','" + codeValue + "', now(),'1')");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.executeUpdate();
        return codeId;
    }

    /**
     * 根据ID查询校验码
     */
    public List findCodeById(String codeId,String inputCode){
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT code_value FROM system_check_code WHERE code_id = '" + codeId + "' AND code_value = '" + inputCode +"' AND status = '1'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }


}
