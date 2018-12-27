package jll.history_browsing.service.impl;

import com.cn.zyzs.utils.utils.PageView;
import jll.history_browsing.dao.HistoryBrowseDao;
import jll.history_browsing.service.HistoryBrowseService;
import jll.model.history_browsing.HistoryBrowsing;
import jll.utils.HibernatePageUtil;
import jll.utils.XinfuResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("historyBrowseService")
@Transactional
public class HistoryBrowseServiceImpl implements HistoryBrowseService {

    @Autowired
    private HistoryBrowseDao historyBrowseDao;

    /**
     * 添加浏览记录
     * @param historyBrowsing
     */
    @Override
    public XinfuResult addHistoryBrowsing(HistoryBrowsing historyBrowsing) {
        try {
            historyBrowseDao.addHistoryBrowsing(historyBrowsing);
            return XinfuResult.build(200,"添加浏览记录成功");
        } catch (Exception e) {
            e.printStackTrace();
            return XinfuResult.build(400,"添加浏览记录失败");
        }
    }

    /**
     * 分页查看浏览记录列表
     * @param userId
     * @return
     */
    @Override
    public PageView findHistoryList(String userId,int currentPage,int rows) {
        return HibernatePageUtil.sqlPageUtil(historyBrowseDao.findHistoryList(userId),currentPage,rows);
    }
}
