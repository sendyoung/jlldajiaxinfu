package jll.data_list.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.data_list.FamilyInfo;
import jll.utils.MapTrunPojo;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class FamilyInfoDao extends SimpleHibernateTemplate<FamilyInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 根据员工ID删除家庭成员信息
     * */
    public void deleteFamilyInfoByEmployeeId(String employee_id){
        StringBuffer sql = new StringBuffer();
        sql.append(" select efi.* from ent_family_info efi where 1=1 and employee_id='"+employee_id+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List fiList=query.list();
        if(fiList!=null){
            for(int i=0;i<fiList.size();i++){
                FamilyInfo fi=(FamilyInfo) MapTrunPojo.map2Object((Map)fiList.get(0),FamilyInfo.class);
                this.getSession().delete(fi);
            }
        }
    }
    /**
     * 添加家庭成员信息
     * */
    public void saveFamilyInfo(FamilyInfo familyInfo){
        if(familyInfo.getFamily_info_id()!=null&&!familyInfo.getFamily_info_id().equals("")){
            this.getSession().saveOrUpdate(familyInfo);
        }else{
            this.getSession().save(familyInfo);
        }
    }

}
