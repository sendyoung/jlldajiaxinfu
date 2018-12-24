package jll.reportedData.service;

import jll.model.BasicPnformationSubmit.SubjectCreditEvaluation;

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
