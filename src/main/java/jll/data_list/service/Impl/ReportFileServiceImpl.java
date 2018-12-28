package jll.data_list.service.Impl;

import com.cn.zyzs.hibernate.util.Page;
import com.cn.zyzs.utils.utils.PageContext;
import com.cn.zyzs.utils.utils.PageView;
import jll.data_list.dao.ReportFileDao;
import jll.data_list.service.ReportFileService;
import jll.model.data_list.ReportFile;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

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

    @Override
    public Object findReportFileForAuditStatus(String type, Integer page, Integer rows) {
        try {
            Map param = new HashedMap();
            PageContext.setOffSet(page);
            PageContext.setPageSize(rows);
            Page pages=reportFileDao.queryReportFileForAuditStatus(type);
            PageView pageView = new PageView(PageContext.getPageSize(), PageContext.getOffSet());
            pageView.setTotalpage(pages.getTotal());
            pageView.setRecords(pages.getItems());
            return pageView;
        } catch (Exception e) {
            e.printStackTrace();
            return "500";
        }
    }

    @Override
    public void editReportFileByReportFileId(String reportFileId, String auditStatus) {
        reportFileDao.updateReportFileByReportFileId(reportFileId,auditStatus);
    }
}
