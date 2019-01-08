package jll.reported_data.service;

import jll.model.BasicPnformationSubmit.EnvironmentalProtectionSystemCertification;

import java.util.List;

public interface EnvironmentalCertificationService {

    /**
     * 环保体系认证
     */
    public void addEnvironmentalCertification(List<EnvironmentalProtectionSystemCertification> environmentalProtectionSystemCertification);
    /**
     * 查询环保体系认证
     */
    public List queryEnvironmentalCertification(String entId);
}
