package jll.history_browsing.service.impl;

import com.cn.zyzs.utils.utils.PageView;
import jll.history_browsing.dao.MonitorFollowDao;
import jll.history_browsing.service.MonitorFollowService;
import jll.utils.HibernatePageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service("monitorFollowService")
@Transactional
public class MonitorFollowServiceImpl implements MonitorFollowService {

    @Autowired
    private MonitorFollowDao monitorFollowDao;

    //查看监控(不良,良好,新闻)或关注的列表
    @Override
    public PageView findMonitorFollowList(String userId, String type, String behaviorClassification,int currentPage,int rows) {
        return HibernatePageUtil.sqlPageUtil(monitorFollowDao.findMonitorFollowList(userId,type,behaviorClassification),currentPage,rows);
    }

    @Override
    public PageView findMonitorUnchangedList(String userId, int currentPage, int rows) {
        return HibernatePageUtil.sqlPageUtil(monitorFollowDao.findMonitorUnchangedList(userId),currentPage,rows);
    }

    @Override
    public PageView findMonitorUncertified(String userId, int currentPage, int rows) {
        return HibernatePageUtil.sqlPageUtil(monitorFollowDao.findMonitorUncertified(userId),currentPage,rows);
    }
}
