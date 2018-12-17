package jll.data_list.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.data_list.FamilyInfo;
import jll.model.data_list.TrackRecord;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TrackRecordDao extends SimpleHibernateTemplate<TrackRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * 根据员工ID删除履历信息
     * */
    public void deleteTrackRecordByEmployeeId(String employee_id){
        StringBuffer sql = new StringBuffer();
        sql.append(" select etr.* from ent_track_record etr where 1=1 and employee_id='"+employee_id+"'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List<TrackRecord>trList=query.list();
        if(trList!=null){
            for(TrackRecord tr:trList){
                this.getSession().delete(tr);
            }
        }
    }
    /**
     * 添加履历信息
     * */
    public void saveTrackRecord(TrackRecord trackRecord){
        if(trackRecord.getTrack_record_id()!=null&&!trackRecord.getTrack_record_id().equals("")){
            this.getSession().saveOrUpdate(trackRecord);
        }else{
            this.getSession().save(trackRecord);
        }
    }

}
