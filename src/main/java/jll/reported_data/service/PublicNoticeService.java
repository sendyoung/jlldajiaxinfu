package jll.reported_data.service;

import jll.model.basic_pnformation_submit.ServiceByPublication;

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
