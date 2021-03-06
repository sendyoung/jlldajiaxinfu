package jll.data_list.service;

import jll.model.data_list.ReportFile;

public interface ReportFileService {
    /**
     * 根据类型查询企业上传的资料
     * */
    public ReportFile findReportFileByType(String type,String entId);


    /**
     * 添加上传的资料
     * */
    public void editReportFile(ReportFile reportFile);
    /**
     * 根据类型查询所有企业上传的未审核的资料
     * */
    public Object findReportFileForAuditStatus(String type,Integer page,Integer rows);
    /**
     * 根据文件ID修改文件审核状态
     * */
    public void editReportFileByReportFileId(String reportFileId,String auditStatus);
}
