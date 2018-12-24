package jll.apply_evaluate.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.apply_evaluate.RedBlackList;
import jll.utils.MapTrunPojo;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class RedBlackListDao extends SimpleHibernateTemplate<RedBlackList> {
    private static final long serialVersionUID = 1L;

    /**
     * 生成红黑名单
     * */
    public String saveRedBlackList(RedBlackList redBlackList){
        if(redBlackList.getRed_black_list_id()!=null&&!redBlackList.getRed_black_list_id().equals("")){
            this.getSession().saveOrUpdate(redBlackList);
        }else{
            this.getSession().save(redBlackList);
        }
        return redBlackList.getRed_black_list_id();
    }
    /**
     * 查询组织未作废的榜单（1未作废，2已作废）（1已公示，2未公示）年份
     * */
    public RedBlackList queryRedBlackListForStatus(String authOrgId, String status, String publicStatus, String date){
        StringBuffer sql = new StringBuffer();
        sql.append("select * from eva_red_black_list where 1=1 and auth_org_id="+authOrgId+" ");
        if(status!=null&&!status.equals("")){
            sql.append("and status="+status+" ");
        }
        if(publicStatus!=null&&!publicStatus.equals("")){
            sql.append("and public_status="+publicStatus+" ");
        }
        if(date!=null&&!date.equals("")){
            sql.append("and date_format(create_time,'%Y')="+date+" ");
        }
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List list=query.list();
        if(list==null||list.size()==0){
            return null;
        }
        RedBlackList rbl=(RedBlackList)MapTrunPojo.map2Object((Map)list.get(0),RedBlackList.class);
        return rbl;
    }
    /**
     * 查询组织所有红名单
     * */
    public List queryRedBlackListForRedList(String authOrgId){
        StringBuffer sql = new StringBuffer();
        sql.append("select eae.apply_evaluate_id,aeb.enterprise_name,1 count from auth_enterprise_base aeb left join eva_apply_evaluate eae" +
                " on eae.auth_enterprise_id=aeb.auth_enterprise " +
                " left join eva_score_result esr on esr.apply_evaluate_id=eae.apply_evaluate_id" +
                " where 1=1 and eae.auth_org_id="+authOrgId+" and eae.audit_status=4 and esr.level='AAA' ");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }

    /**
     *
     * @Author:Young
     * 发布公示的时候修改列表的公示状态
     * red_black_list_id榜单ID
     * publicStatus榜单公示状态  1已公示  未公示
     */
    public void updateRedBlackListPublicStatus(String red_black_list_id,String publicStatus){
        StringBuffer sql = new StringBuffer();
        sql.append("UPDATE eva_red_black_list SET public_status = '" +publicStatus +"' " );
        sql.append(" WHERE eva_red_black_list_id = '" + red_black_list_id + "'");
    }

}
