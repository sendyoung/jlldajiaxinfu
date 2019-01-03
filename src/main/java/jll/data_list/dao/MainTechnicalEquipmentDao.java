package jll.data_list.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.data_list.MainTechnicalEquipment;
import jll.utils.MapTrunPojo;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class MainTechnicalEquipmentDao extends SimpleHibernateTemplate<MainTechnicalEquipment> {

    private static final long serialVersionUID = 1L;
    /**
     * period年度
     * 查询财务费用信息
     * */
    public MainTechnicalEquipment queryMainTechnicalEquipmentForPeriod(String entId,Integer period){
        StringBuffer sql = new StringBuffer();
        sql.append(" select emte.* from ent__main_technical_equipment emte where 1=1 and period='"+period+"' and ent_id='"+entId+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List list=query.list();
        if(list==null){
            return null;
        }
        MainTechnicalEquipment mte=(MainTechnicalEquipment) MapTrunPojo.map2Object((Map)list.get(0),MainTechnicalEquipment.class);
        return mte;
    }

    /**
     * 添加财务费用信息
     * */
    public void saveMainTechnicalEquipment(MainTechnicalEquipment mainTechnicalEquipment){
        if(mainTechnicalEquipment.getMain_technical_equipment_id()!=null&&!mainTechnicalEquipment.getMain_technical_equipment_id().equals("")){
            this.getSession().saveOrUpdate(mainTechnicalEquipment);
        }else{
            this.getSession().save(mainTechnicalEquipment);
        }
    }

}
