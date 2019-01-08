package jll.reported_data.service;

import jll.model.basic_pnformation_submit.QualificationAuthentication;

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
