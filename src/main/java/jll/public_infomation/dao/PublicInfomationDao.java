package jll.public_infomation.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.public_infomation.InfomationPublicty;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class PublicInfomationDao extends SimpleHibernateTemplate<InfomationPublicty> {

    /**
     * 填写公示内容并提交
     * 不论填不填内容实体类中都要添加榜单id,
     * 榜单公示类型, 1红名单 2黑名单 3 信用评价 4 资料公开
     * 用户ID
     */
    public void addInfomationPublicty(InfomationPublicty infomationPublicty){
//        this.getSession().save(infomationPublicty);
        StringBuffer sql = new StringBuffer();
        sql.append(" INSERT INTO org_infomation_publicty(publicty_id,user_id,title,introduction,publicty_type,start_time,end_time,upload_data,evaluate_list_id,red_black_list_id,create_time,public_status,isDelete) ");
        sql.append(" VALUES('" + UUID.randomUUID().toString().replace("-","") + "','" + infomationPublicty.getUser_id() + "','" + infomationPublicty.getTitle() + "','" + infomationPublicty.getIntroduction() + "','" + infomationPublicty.getPublicty_type() + "','" + infomationPublicty.getStart_time() + "','" + infomationPublicty.getEnd_time() + "','" + infomationPublicty.getUpload_data() + "','" + infomationPublicty.getEvaluate_list_id() + "','" + infomationPublicty.getRed_black_list_id() + "',now(),'" + infomationPublicty.getPublic_status() + "','0')");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.executeUpdate();
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

    /**
     * 修改公示内容
     */
    public void updatepublictyInfomation(InfomationPublicty infomationPublicty){
        StringBuffer sql = new StringBuffer();
        sql.append("UPDATE org_infomation_publicty SET  ");
        if (!"".equals(infomationPublicty.getTitle()) && null != infomationPublicty.getTitle()) {
            sql.append("title = '"+infomationPublicty.getTitle()+"',");
        }
        if (!"".equals(infomationPublicty.getIntroduction()) && null != infomationPublicty.getIntroduction()) {
            sql.append("introduction = '"+infomationPublicty.getIntroduction()+"',");
        }
        if (!"".equals(infomationPublicty.getStart_time()) && null != infomationPublicty.getStart_time()) {
            sql.append("start_time = '"+infomationPublicty.getStart_time()+"',");
        }
        if (!"".equals(infomationPublicty.getEnd_time()) && null != infomationPublicty.getEnd_time()) {
            sql.append("end_time = '"+infomationPublicty.getEnd_time()+"',");
        }
        if (!"".equals(infomationPublicty.getPublic_status()) && null != infomationPublicty.getPublic_status()) {
            sql.append("public_status = '"+infomationPublicty.getPublic_status()+"',");
        }
        if (!"".equals(infomationPublicty.getUpload_data()) && null != infomationPublicty.getUpload_data()) {
            sql.append("upload_data = '"+infomationPublicty.getUpload_data()+"',");
        }
        sql.replace(sql.length() - 1, sql.length(), "");
        sql.append(" WHERE publicty_id = '" + infomationPublicty.getPublicty_id() +"' ");

        Query query = this.getSession().createSQLQuery(sql.toString());
        query.executeUpdate();
    }

    /**
     * 修改公示状态
     */
    public void updatePublicStatus(String publictyId,String publicStatus){
        StringBuffer sql = new StringBuffer();
        sql.append("UPDATE org_infomation_publicty SET ");
        sql.append(" public_status = '" + publicStatus + "'  ");
        sql.append(" WHERE publicty_id = '" + publictyId +"' ");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.executeUpdate();
    }

}
