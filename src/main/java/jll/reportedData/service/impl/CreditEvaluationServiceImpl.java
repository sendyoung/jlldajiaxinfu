package jll.reportedData.service.impl;

import jll.model.BasicPnformationSubmit.SubjectCreditEvaluation;
import jll.reportedData.dao.CreditEvaluationDao;
import jll.reportedData.service.CreditEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service()
@Transactional
public class CreditEvaluationServiceImpl implements CreditEvaluationService {
    //调用dao层
    @Autowired
    private CreditEvaluationDao creditEvaluationDao;

    @Override
    public void addCreditEvaluation(List<SubjectCreditEvaluation> subjectCreditEvaluation) {
        for(SubjectCreditEvaluation sh:subjectCreditEvaluation){
            creditEvaluationDao.addCreditEvaluation(sh);
        }
    }

    @Override
    public List queryCreditEvaluation(String entId) {

        List result=creditEvaluationDao.queryCreditEvaluation(entId);
        if(null!=result && result.size()>0){
            return result;
        }
        return null;
    }
}