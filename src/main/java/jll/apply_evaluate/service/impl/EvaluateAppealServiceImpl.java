package jll.apply_evaluate.service.impl;

import com.cn.zyzs.hibernate.util.Page;
import com.cn.zyzs.utils.utils.PageContext;
import com.cn.zyzs.utils.utils.PageView;
import jll.apply_evaluate.dao.ApplyEvaluateDao;
import jll.apply_evaluate.dao.EvaluateAppealDao;
import jll.apply_evaluate.service.EvaluateAppealService;
import jll.model.apply_evaluate.EvaluateAppeal;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service("evaluateAppealService")
@Transactional
public class EvaluateAppealServiceImpl implements EvaluateAppealService {

    @Autowired
    private EvaluateAppealDao evaluateAppealDao;//评价申诉

    @Autowired
    private ApplyEvaluateDao applyEvaluateDao;//申请评价

    @Override
    public void editEvaluateAppeal(EvaluateAppeal evaluateAppeal) {
        //添加申诉
        evaluateAppealDao.saveEvaluateAppeal(evaluateAppeal);
        //请求评价申诉状态为已申诉
        applyEvaluateDao.updateApplyEvaluateForAppealStatus(evaluateAppeal.getApply_evaluate_id(),"1");
    }

    @Override
    public Object findEvaluateAppealHistory(String authEnterpriseId, String appealStype, String appealCreateTime, String appealStatus, Integer page, Integer rows) {
        try {
            Map param = new HashedMap();
            PageContext.setOffSet(page);
            PageContext.setPageSize(rows);
            Page pages=evaluateAppealDao.queryEvaluateAppealHistory(authEnterpriseId,appealStype,appealCreateTime,appealStatus);
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
    public Object findEvaluateAppealByApplyEvaluateId(String applyEvaluateId) {
        return evaluateAppealDao.queryEvaluateAppealByApplyEvaluateId(applyEvaluateId);
    }

    @Override
    public Object findEvaluateAppealByAuthOrgId(String authOrgId, String stype, String appealTime, String appealStatus, String name, Integer page, Integer rows) {
        try {
            Map param = new HashedMap();
            PageContext.setOffSet(page);
            PageContext.setPageSize(rows);
            Page pages=evaluateAppealDao.queryEvaluateAppealByAuthOrgId(authOrgId,stype,appealTime,appealStatus,name);
            PageView pageView = new PageView(PageContext.getPageSize(), PageContext.getOffSet());
            pageView.setTotalpage(pages.getTotal());
            pageView.setRecords(pages.getItems());
            return pageView;
        } catch (Exception e) {
            e.printStackTrace();
            return "500";
        }
    }
}
