package jll.apply_evaluate.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import com.cn.zyzs.hibernate.util.Page;
import com.cn.zyzs.utils.utils.PageContext;
import jll.model.apply_evaluate.CreditFile;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CreditFileDao extends SimpleHibernateTemplate<CreditFile> {
    private static final long serialVersionUID = 1L;

    /**
     * 添加信用档案
     * */
    public void saveCreditFile(CreditFile creditFile){
        creditFile.setIsDelete("0");
        creditFile.setCreate_time(new Date());
        this.getSession().save(creditFile);
    }
    /**
     * 回显企业档案
     * */
    public Object queryCreditFileByAuthEnterpriseId(String authEnterpriseId){
        StringBuffer sql = new StringBuffer();
        sql.append("select aeb.enterprise_name,aeb.enterprise_logo,aeb.enterprise_tel,aeb.enterprise_email " +
                ",aeb.enterprise_website,aeb.enterprise_address,aeb.enterprise_introduction,ecf.doc_name,ecf.doc_url " +
                "from auth_enterprise_base aeb left join eva_credit_file ecf " +
                "on ecf.auth_enterprise_id=ecf.auth_enterprise_id " +
                "where aeb.auth_enterprise_id='" +authEnterpriseId+"' "+
                "order by ecf.create_time desc limit 1");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List list=query.list();
        if(list==null||list.size()==0){
            return null;
        }
        return list.get(0);
    }
    /**
     * 历史档案
     * */
    public Page queryHistoryCreditFile(String authEnterpriseId,String name,String date){
        Map<String, Object> param = new HashMap<String, Object>();
        StringBuffer sql = new StringBuffer();
        LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
        sql.append("select * from eva_credit_file where auth_enterprise_id='"+authEnterpriseId+"' ");
        if(date!=null&&!date.equals("")){
            sql.append("and date_format(create_time,'%Y-%c-%d')='"+date+"' ");
        }
        if(name!=null&&!name.equals("")){
            sql.append("and doc_name='"+name+"' ");
        }
        sql.append("order by create_time desc");
        return sqlqueryForpage1(sql.toString(), param, PageContext.getPageSize(), PageContext.getOffSet(), orderby);
    }

}
