package jll.history_browsing.service;

import com.cn.zyzs.utils.utils.PageView;

public interface MonitorFollowService {

    //查看监控(良好,不良,新闻)或关注的列表
    public PageView findMonitorFollowList(String userId,String type,String behaviorClassification,int currentPage,int rows);

    //查看我的监控未变化的
    public PageView findMonitorUnchangedList(String userId,int currentPage,int rows);

    //查看我的监控未认证的企业
    public PageView findMonitorUncertified(String userId,int currentPage,int rows);

}
