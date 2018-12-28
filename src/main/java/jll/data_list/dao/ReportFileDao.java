package jll.data_list.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import com.cn.zyzs.hibernate.util.Page;
import com.cn.zyzs.utils.utils.PageContext;
import jll.model.data_list.ReportFile;
import jll.utils.MapTrunPojo;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.LinkedHashMap;
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
    /**
     * 根据类型查询所有企业上传的未审核的资料
     * */
    public Page queryReportFileForAuditStatus(String type){
        Map<String, Object> param = new HashMap<String, Object>();
        StringBuffer sql = new StringBuffer();
        LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
        sql.append(" select erf.*,aeb.enterprise_name from ent_report_file erf left join auth_enterprise_base aeb " +
                "on aeb.auth_enterprise_id=erf.ent_id where 1=1 ");
        if(type!=null&&!type.equals("")){
            sql.append(" and file_type='"+type+"' ");
        }
        sql.append(" order by erf.create_time desc ");
        return sqlqueryForpage1(sql.toString(), param, PageContext.getPageSize(), PageContext.getOffSet(), orderby);
    }
    /**
     * 根据文件ID修改文件审核状态
     * */
    public void updateReportFileByReportFileId(String reportFileId,String auditStatus){
        StringBuffer sql = new StringBuffer();
        sql.append("update ent_report_file set audit_status='"+auditStatus+"' where report_file_id='"+reportFileId+"' ");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        query.executeUpdate();
    }
}
