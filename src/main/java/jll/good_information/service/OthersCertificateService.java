package jll.good_information.service;

import jll.model.good_information.OthersCertificate;

import java.util.List;

public interface OthersCertificateService {
    /**
     * 获取其他证书
     * */
    public List getOthersCertificate(String entId);
    /**
     * 添加其他证书
     * */
    public void editOthersCertificate(List<OthersCertificate> ocList);
}
