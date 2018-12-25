package jll.reportedData.service;

import jll.model.BasicPnformationSubmit.ServiceByPublication;

import java.util.List;

public interface PublicNoticeService {
    /**
     * 添加公示催告
     */
    public void addPublicNotice(List<ServiceByPublication> serviceByPublication);

    /**
     * 查询公示催告
     */
    public List queryPublicNotice(String entId);
}
