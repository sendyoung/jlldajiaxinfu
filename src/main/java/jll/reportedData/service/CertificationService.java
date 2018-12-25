package jll.reportedData.service;

import jll.model.BasicPnformationSubmit.QualificationAuthentication;

import java.util.List;

public interface CertificationService {

    /**
     * 添加资质认证
     */
    public void addCertification(List<QualificationAuthentication> qualificationAuthentication);


    /**
     * 查询资质认证
     */
    public List queryCertification(String entId);
}