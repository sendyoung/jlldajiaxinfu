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
}
