package jll.goog_information.service;

import jll.model.OthersCertificate;

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
