package jll.data_list.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.data_list.ReportFile;
import jll.utils.MapTrunPojo;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ReportFileDao extends SimpleHibernateTemplate<ReportFile> {
    private static final long serialVersionUID = 1L;

    /**
     * 根据类型查询企业上传的资料
     * */
    public ReportFile queryReportFileByType(String type,String entId){
        StringBuffer sql = new StringBuffer();
        sql.append(" select erf.* from ent_report_file erf where 1=1 and file_type='"+type+"' and ent_id='"+entId+"' order by create_time desc limit 1");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List list=query.list();
        if(list==null||list.size()==0){
            return null;
        }
        ReportFile r=(ReportFile)MapTrunPojo.map2Object((Map)list.get(0),ReportFile.class);
        return r;
    }
    /**
     * 添加上传的资料
     * */
    public void saveReportFile(ReportFile reportFile){
        this.getSession().save(reportFile);
    }
}
