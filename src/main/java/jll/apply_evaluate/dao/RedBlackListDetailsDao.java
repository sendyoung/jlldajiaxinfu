package jll.apply_evaluate.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.apply_evaluate.RedBlackListDetails;
import jll.utils.MapTrunPojo;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public class RedBlackListDetailsDao extends SimpleHibernateTemplate<RedBlackListDetails> {
    private static final long serialVersionUID = 1L;
    /**
     * 生成评价榜单结果
     * */
    public void saveRedBlackListDetails(RedBlackListDetails redBlackListDetails){
        if(redBlackListDetails.getRed_black_list_details_id()!=null&&!redBlackListDetails.getRed_black_list_details_id().equals("")){
            this.getSession().saveOrUpdate(redBlackListDetails);
        }else{
            redBlackListDetails.setIsDelete("0");
            redBlackListDetails.setCreate_time(new Date());
            this.getSession().save(redBlackListDetails);
        }
    }
    /**
     * 根据榜单ID跟申请评价ID查询榜单详情
     * */
    public RedBlackListDetails queryRedBlackListDetails(String red_black_list_id,String apply_evaluate_id){
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT * from eva_red_black_list_details where red_black_list_id='"+red_black_list_id+"' and apply_evaluate_id='"+apply_evaluate_id+"' ");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List list=query.list();
        if(list==null||list.size()==0){
            return null;
        }
        RedBlackListDetails rbld=(RedBlackListDetails)MapTrunPojo.map2Object((Map)list.get(0),RedBlackListDetails.class);
        return rbld;
    }
}
