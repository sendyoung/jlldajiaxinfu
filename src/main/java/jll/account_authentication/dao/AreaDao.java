package jll.account_authentication.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.Area;
import jll.utils.MapTrunPojo;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 区域信息
 */
@Repository
public class AreaDao extends SimpleHibernateTemplate<Area> {

    /**
     * 查询所有省级地区
     */
    public List<Area> queryAreaForProvince(){
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT code,full_name FROM public_area WHERE right(code,4)='0000' order by code");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List<Area>list=new ArrayList<Area>();
        List l=query.list();
        for(int i=0;i<l.size();i++){
            Area area=(Area)MapTrunPojo.map2Object((Map)l.get(i),Area.class);
            list.add(area);
        }
        return list;
    }
    /**
     * 查询所有市级地区
     * */
    public List<Area> queryAreaForCity(){
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT code,full_name FROM public_area WHERE right(code,2)='00' and right(code,4)!='0000' order by code");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List<Area>list=new ArrayList<Area>();
        List l=query.list();
        for(int i=0;i<l.size();i++){
            Area area=(Area)MapTrunPojo.map2Object((Map)l.get(i),Area.class);
            list.add(area);
        }
        return list;
    }

}
