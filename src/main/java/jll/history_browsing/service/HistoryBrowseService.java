package jll.history_browsing.service;

import com.cn.zyzs.utils.utils.PageView;
import jll.model.history_browsing.HistoryBrowsing;
import jll.utils.XinfuResult;

public interface HistoryBrowseService {

    //添加浏览记录
    public XinfuResult addHistoryBrowsing(HistoryBrowsing historyBrowsing);

    //查看浏览记录列表
    public PageView findHistoryList(String userId,int currentPage,int rows);

}
