package jll.data_list.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import jll.model.data_list.ReportFile;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReportFileDao extends SimpleHibernateTemplate<ReportFile> {
    private static final long serialVersionUID = 1L;

    /**
     * 根据类型查询企业上传的资料
     * */
    public ReportFile queryReportFileByType(String type,String entId){
        StringBuffer sql = new StringBuffer();
        sql.append(" select erf.* from ent_report_file erf where 1=1 and file_type='"+type+"' and ent_id='"+entId+"' order by create_time desc");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List<ReportFile> list=query.list();
        if(list==null){
            return null;
        }
        return (ReportFile)query.list().get(0);
    }
    /**
     * 添加上传的资料
     * */
    public void saveReportFile(ReportFile reportFile){
        this.getSession().save(reportFile);
    }
}
