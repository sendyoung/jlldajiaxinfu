package jll.apply_evaluate.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.apply_evaluate.EvaluateList;
import jll.utils.MapTrunPojo;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public class EvaluateListDao extends SimpleHibernateTemplate<EvaluateList> {
    private static final long serialVersionUID = 1L;
    /**
     * 生成评价榜单
     * */
    public String saveEvaluateList(EvaluateList evaluateList){
        if(evaluateList.getEvaluate_list_id()!=null&&!evaluateList.getEvaluate_list_id().equals("")){
            this.getSession().saveOrUpdate(evaluateList);
        }else{
            evaluateList.setIsDelete("0");
            evaluateList.setCreate_time(new Date());
            this.getSession().save(evaluateList);
        }
        return evaluateList.getEvaluate_list_id();
    }
    /**
     * 查询组织未作废的榜单（1未作废，2已作废）（1已公示，2未公示）年份
     * */
    public EvaluateList queryEvaluateListForStatus(String authOrgId,String status,String publicStatus,String date){
        StringBuffer sql = new StringBuffer();
        sql.append("select * from eva_evaluate_list where 1=1 and auth_org_id='"+authOrgId+"' ");
        if(status!=null&&!status.equals("")){
            sql.append("and status='"+status+"' ");
        }
        if(publicStatus!=null&&!publicStatus.equals("")){
            sql.append("and public_status='"+publicStatus+"' ");
        }
        if(date!=null&&!date.equals("")){
            sql.append("and date_format(create_time,'%Y')='"+date+"' ");
        }
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List list=query.list();
        if(list==null||list.size()==0){
            return null;
        }
        EvaluateList el=(EvaluateList)MapTrunPojo.map2Object((Map)list.get(0),EvaluateList.class);
        return el;
    }

    /**
     *
     * @Author:Young
     * 发布公示的时候修改列表的公示状态
     * evaluate_list_id榜单id
     * publicStatus榜单公示状态  1已公示  未公示
     */
    public void updateEvaluateListPublicStatus(String evaluate_list_id,String publicStatus){
        StringBuffer sql = new StringBuffer();
        sql.append("UPDATE eva_evaluate_list SET public_status = '" +publicStatus +"' " );
        sql.append(" WHERE evaluate_list_id = '" + evaluate_list_id + "'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.executeUpdate();
    }

}
