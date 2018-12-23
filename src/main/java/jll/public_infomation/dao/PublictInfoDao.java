package jll.public_infomation.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import com.cn.zyzs.hibernate.util.Page;
import com.cn.zyzs.hibernate.util.PageContext;
import org.springframework.stereotype.Repository;

@Repository
public class PublictInfoDao extends SimpleHibernateTemplate<Object> {

    /**
     * 分页新的公示列表   内容 标题 时间
     */
    public Page findNewPublicInfomation(String authOrgId, String period){
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT red_black_list_id id,list_name title,type,create_time FROM eva_red_black_list WHERE status = '1' AND period = '" + period + "' AND auth_org_id = '" + authOrgId + "'");
        sql.append("            UNION ALL                  ");
        sql.append(" SELECT evaluate_list_id,title,3 ,create_time FROM eva_evaluate_list WHERE status = '1'  AND auth_org_id = '" + authOrgId + "' ");
        return sqlqueryForpage1(sql.toString(), null, PageContext.getPageSize(), PageContext.getOffSet(), null);
    }

    /**
     * 查看新的公示中的信用评价榜单
     */
    public Page findNewEvaluationList(String evaluateListId){
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT base.enterprise_name,result.level grade,(@sort := @sort+1) AS sort " +
                "FROM eva_evaluate_list list,eva_evaluate_list_details details,eva_apply_evaluate apply,eva_score_result result, auth_enterprise_base base " +
                "WHERE list.evaluate_list_id = details.evaluate_list_id AND details.apply_evaluate_id = apply.apply_evaluate_id " +
                " AND apply.apply_evaluate_id = result.apply_evaluate_id AND apply.auth_enterprise_id = base.auth_enterprise_id " +
                " AND list.evaluate_list_id = '"+ evaluateListId + "' ORDER BY result.score DESC");
        return sqlqueryForpage1(sql.toString(), null, PageContext.getPageSize(), PageContext.getOffSet(), null);
    }

    /**
     * 查看新的公示中的红榜或者黑榜
     */
    public Page findNewRedBlackList(String redblackListId){
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT base.enterprise_name,result.level grade,(@sort := @sort+1) AS sort " +
                " FROM eva_red_black_list list,eva_red_black_list_details details,eva_apply_evaluate apply,eva_score_result result, auth_enterprise_base base " +
                " WHERE list.red_black_list_id = details.red_black_list_id AND details.apply_evaluate_id = apply.apply_evaluate_id " +
                " AND apply.apply_evaluate_id = result.apply_evaluate_id AND apply.auth_enterprise_id = base.auth_enterprise_id " +
                " AND list.red_black_list_id = '" + redblackListId + "' ORDER BY result.score DESC");
        return sqlqueryForpage1(sql.toString(), null, PageContext.getPageSize(), PageContext.getOffSet(), null);
    }

    /**
     * 查看历史公示列表
     */
    public Page findHistoryPublictyList(String userId){
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT oip.create_time time,oip.title,oip.publicty_type type,list.public_status From org_infomation_publicty oip,eva_evaluate_list list WHERE oip.evaluate_list_id = list.evaluate_list_id AND oip.user_id = '" + userId + "'  ");
        sql.append("   UNION ALL  ");
        sql.append("   SELECT oip.create_time time,oip.title,oip.publicty_type type,list.public_status From org_infomation_publicty oip,eva_red_black_list list WHERE oip.red_black_list_id = list.red_black_list_id AND oip.user_id = '" + userId + "'  ");
        return sqlqueryForpage1(sql.toString(), null, PageContext.getPageSize(), PageContext.getOffSet(), null);
    }

    /**
     * 查看历史公示详情榜单(信用评价榜单)
     */
    public Page findDetailsEvaluateList(String publictyId){
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT oip.publicty_id,base.enterprise_name,result.level " +
                " FROM org_infomation_publicty oip,eva_evaluate_list list,eva_evaluate_list_details details,eva_apply_evaluate apply, " +
                "eva_score_result result, auth_enterprise_base base " +
                " WHERE oip.evaluate_list_id = list.evaluate_list_id AND list.evaluate_list_id = details.evaluate_list_id AND " +
                " details.apply_evaluate_id = apply.apply_evaluate_id AND apply.apply_evaluate_id = result.apply_evaluate_id AND " +
                " apply.auth_enterprise_id = base.auth_enterprise_id AND oip.publicty_id = '" + publictyId + "' ORDER BY result.score DESC");
        return sqlqueryForpage1(sql.toString(), null, PageContext.getPageSize(), PageContext.getOffSet(), null);
    }

    /**
     * 查看历史公示详情榜单(红黑榜单)
     */
    public Page findDetailsRedBlackList(String publictyId){
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT oip.publicty_id,base.enterprise_name,result.level " +
                " FROM org_infomation_publicty oip,eva_red_black_list list,eva_red_black_list_details details, " +
                "eva_apply_evaluate apply,eva_score_result result, auth_enterprise_base base " +
                " WHERE oip.red_black_list_id = list.red_black_list_id AND list.red_black_list_id = details.red_black_list_id " +
                " AND details.apply_evaluate_id = apply.apply_evaluate_id AND apply.apply_evaluate_id = result.apply_evaluate_id AND " +
                " apply.auth_enterprise_id = base.auth_enterprise_id AND oip.publicty_id = '"+ publictyId +"' ORDER BY result.score ASC");
        return sqlqueryForpage1(sql.toString(), null, PageContext.getPageSize(), PageContext.getOffSet(), null);
    }


}
