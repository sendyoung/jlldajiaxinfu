package jll.apply_evaluate.service.impl;

import jll.apply_evaluate.dao.ScoreRuleDao;
import jll.apply_evaluate.service.ScoreRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("scoreRuleService")
@Transactional
public class ScoreRuleServiceImpl implements ScoreRuleService {

    @Autowired
    private ScoreRuleDao scoreRuleDao;//评分规则


    @Override
    public List findScoreRule(String authOrgId,String applyEvaluateId) {
        List list=scoreRuleDao.queryScoreRuleByAuthOrgId(authOrgId,applyEvaluateId);
        if(list==null||list.size()==0){
            list=scoreRuleDao.queryScoreRuleByAuthOrgId("0",applyEvaluateId);
            if(list==null||list.size()==0){
                list=scoreRuleDao.queryScoreRuleByAuthOrgId("0");
            }
        }
        return list;
    }
}
