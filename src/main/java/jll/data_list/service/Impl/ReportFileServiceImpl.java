package jll.data_list.service.Impl;

import jll.data_list.dao.ReportFileDao;
import jll.data_list.service.ReportFileService;
import jll.model.data_list.ReportFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("reportFileService")
@Transactional
public class ReportFileServiceImpl implements ReportFileService {

    @Autowired
    private ReportFileDao reportFileDao;//企业上传的资料

    @Override
    public ReportFile findReportFileByType(String type, String entId) {
        return reportFileDao.queryReportFileByType(type,entId);
    }

    @Override
    public void editReportFile(ReportFile reportFile) {
        reportFileDao.saveReportFile(reportFile);
    }
}
