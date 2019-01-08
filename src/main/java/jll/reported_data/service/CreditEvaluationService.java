package jll.reported_data.service;

import jll.model.basic_pnformation_submit.SubjectCreditEvaluation;

import java.util.List;

public interface CreditEvaluationService {

    /**
     * 主体信用评价
     */
    public void addCreditEvaluation(List<SubjectCreditEvaluation> subjectCreditEvaluation);
    /**
     * 查询主体信用评价
     */
    public List queryCreditEvaluation(String entId);
}
