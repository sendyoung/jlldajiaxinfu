package jll.reported_data.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.basic_pnformation_submit.ChattelMortgage;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChattelMortgageDao extends SimpleHibernateTemplate<ChattelMortgage>{

    /**
     * 增加动产抵押
     */
    public void addChattelMortgage(ChattelMortgage chattelMortgage){
        System.out.println("执行增加变更记录信息dao层!");
        this.getSession().merge(chattelMortgage);
    }


    /**
     * 查询动产抵押
     */
    public List queryChattelMortgage(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append("select * from ent_chattel_mortgage where 1=1 and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();

    }

}
