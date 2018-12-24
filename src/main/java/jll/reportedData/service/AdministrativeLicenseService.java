package jll.reportedData.service;

import jll.model.BasicPnformationSubmit.AdministrativeLicensing;

import java.util.List;

public interface AdministrativeLicenseService {
    /**
     * 添加行政许可
     */
    public void addAdministrativeLicense(List<AdministrativeLicensing> administrativeLicensing);

    /**
     * 查询行政许可
     */
    public List queryAdministrativeLicense(String entId);
}
