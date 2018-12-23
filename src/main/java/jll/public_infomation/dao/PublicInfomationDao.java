package jll.public_infomation.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.public_infomation.InfomationPublicty;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PublicInfomationDao extends SimpleHibernateTemplate<InfomationPublicty> {

    /**
     * 填写公示内容并提交
     * 不论填不填内容实体类中都要添加榜单id,
     * 榜单公示类型, 1红名单 2黑名单 3 信用评价 4 资料公开
     * 用户ID
     */
    public void addInfomationPublicty(InfomationPublicty infomationPublicty){
        this.getSession().save(infomationPublicty);
    }

    /**
     * 查看历史公示的公示内容
     */
    public List findPublictyInfomationById(String publictyId){
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT * FROM org_infomation_publicty WHERE publicty_id = '" + publictyId + "'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }







}
