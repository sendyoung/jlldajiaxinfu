package jll.public_infomation.service;

import com.cn.zyzs.utils.utils.PageView;
import jll.model.public_infomation.InfomationPublicty;
import jll.utils.XinfuResult;

public interface PublicInfomationService {

    //查看新的公示列表
    public PageView findNewPublicInfomationList(String authOrgId, String period,int currentPage, int rows);
    //查看新的公示详情中的信用评价榜单
    public PageView findNewEvaluateList(String evaluationListId,int currentPage, int rows);
    //查看新的公示详情中的红黑榜单
    public PageView findNewRedBlackList(String redblackListId,int currentPage, int rows);
    //发布公示
    public XinfuResult addPublictyInfomation(InfomationPublicty infomationPublicty,String public_status);


    //查看历史公示列表
    public PageView findHistoryPublicList(String userId,int currentPage,int rows);
    //查看历史公示中的信用评价榜单
    public PageView findHistoryEvaluateList(String publictyId,int currentPage,int rows);
    //查看历史公示中的红黑榜单
    public PageView findHistoryRedBlackList(String publictyId,int currentPage,int rows);
    //查看历史公示中的公示内容
    public InfomationPublicty findInfomationPublicty(String publictyId);
}
