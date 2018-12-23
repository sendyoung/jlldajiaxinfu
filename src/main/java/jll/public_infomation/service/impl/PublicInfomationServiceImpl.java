package jll.public_infomation.service.impl;

import com.cn.zyzs.utils.utils.PageView;
import jll.apply_evaluate.dao.EvaluateListDao;
import jll.apply_evaluate.dao.RedBlackListDao;
import jll.model.public_infomation.InfomationPublicty;
import jll.public_infomation.dao.PublicInfomationDao;
import jll.public_infomation.dao.PublictInfoDao;
import jll.public_infomation.service.PublicInfomationService;
import jll.utils.HibernatePageUtil;
import jll.utils.MapTrunPojo;
import jll.utils.XinfuResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 信息公示
 */
@Service
public class PublicInfomationServiceImpl implements PublicInfomationService {

    @Autowired
    private PublictInfoDao publictInfoDao;
    @Autowired
    private PublicInfomationDao publicInfomationDao;
    @Autowired
    private RedBlackListDao redBlackListDao;
    @Autowired
    private EvaluateListDao evaluateListDao;

    /**
     * 查看新的公示列表
     * @param authOrgId  组织认证ID
     * @param period    年度
     * @param currentPage 当前页
     * @param rows     每页显示的条数
     * @return
     */
    @Override
    public PageView findNewPublicInfomationList(String authOrgId, String period, int currentPage, int rows) {
        return HibernatePageUtil.sqlPageUtil(publictInfoDao.findNewPublicInfomation(authOrgId,period),currentPage,rows);
    }

    /**
     *查看新的公示详情中的信用评价榜单
     * @param evaluateListId 榜单ID
     * @param currentPage    当前页
     * @param rows      每页显示的条数
     * @return
     */
    @Override
    public PageView findNewEvaluateList(String evaluateListId, int currentPage, int rows) {
        return HibernatePageUtil.sqlPageUtil(publictInfoDao.findNewEvaluationList(evaluateListId),currentPage,rows);
    }

    /**
     * 查看新的公示详情中的红黑榜单
     * @param redblackListId  红黑榜单ID
     * @param currentPage
     * @param rows
     * @return
     */
    @Override
    public PageView findNewRedBlackList(String redblackListId, int currentPage, int rows) {
        return HibernatePageUtil.sqlPageUtil(publictInfoDao.findNewRedBlackList(redblackListId),currentPage,rows);
    }

    /**
     * 发布公示
     * @param infomationPublicty  公示内容
     * @param public_status       公示状态1已公示  2未公示
     * @return
     * 发布公示时以下字段必须填
     * 相关榜单的ID(信用评价榜单id,红黑榜id)
     * 公示类型(1红名单2黑名单 3信用评价 4 资料公开)
     * 用户id
     */
    @Override
    public XinfuResult addPublictyInfomation(InfomationPublicty infomationPublicty, String public_status) {
        try {
            if (infomationPublicty.getPublicty_type().equals("1") || infomationPublicty.getPublicty_type().equals("2")) {
                //红黑榜单的
                publicInfomationDao.addInfomationPublicty(infomationPublicty);
                redBlackListDao.updateRedBlackListPublicStatus(infomationPublicty.getRed_black_list_id(), public_status);
            } else if (infomationPublicty.getPublicty_type().equals("3")) {
                //信用评价榜单的
                publicInfomationDao.addInfomationPublicty(infomationPublicty);
                evaluateListDao.updateEvaluateListPublicStatus(infomationPublicty.getEvaluate_list_id(), public_status);
            } else {
                //资料公开
                publicInfomationDao.addInfomationPublicty(infomationPublicty);
            }
            return XinfuResult.build(200, "发布公示成功");
        } catch (Exception e) {
            e.printStackTrace();
            return XinfuResult.build(400, "发布公示失败");
        }
    }

    /**
     * 查看历史公示列表
     * @param userId 用户id
     * @param currentPage 当前页
     * @param rows 每页显示的条数
     * @return
     */
    @Override
    public PageView findHistoryPublicList(String userId, int currentPage, int rows) {
        return HibernatePageUtil.sqlPageUtil(publictInfoDao.findHistoryPublictyList(userId),currentPage,rows);
    }

    /**
     * 查看历史公示中的信用评价榜单
     * @param publictyId
     * @param currentPage
     * @param rows
     * @return
     */
    @Override
    public PageView findHistoryEvaluateList(String publictyId, int currentPage, int rows) {
        return HibernatePageUtil.sqlPageUtil(publictInfoDao.findDetailsEvaluateList(publictyId),currentPage,rows);
    }

    /**
     * 查看历史公示中的红黑榜单
     * @param publictyId
     * @param currentPage
     * @param rows
     * @return
     */
    @Override
    public PageView findHistoryRedBlackList(String publictyId, int currentPage, int rows) {
        return HibernatePageUtil.sqlPageUtil(publictInfoDao.findNewRedBlackList(publictyId),currentPage,rows);
    }

    /**
     * 查看历史中的公示内容
     * @param publictyId
     */
    @Override
    public InfomationPublicty findInfomationPublicty(String publictyId) {
       List list = publicInfomationDao.findPublictyInfomationById(publictyId);
       Map map =  (Map)list.get(0);
       InfomationPublicty infomationPublicty = (InfomationPublicty)MapTrunPojo.map2Object(map,InfomationPublicty.class);
       return infomationPublicty;
    }
}
