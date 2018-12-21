package jll.apply_evaluate.service.impl;

import jll.apply_evaluate.dao.ApplyEvaluateDao;
import jll.apply_evaluate.dao.EvaluateAppealDao;
import jll.apply_evaluate.service.EvaluateAppealService;
import jll.model.apply_evaluate.EvaluateAppeal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
