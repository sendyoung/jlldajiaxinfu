package jll.reported_data.service;


import jll.model.basic_pnformation_submit.SoftwareCopyright;

import java.util.List;

public interface SoftwareCopyrightService {

    /**
     * 添加软件著作权
     */
    public void addSoftwareCopyright(List<SoftwareCopyright> softwareCopyright);
    /**
     * 查询软件著作权
     */
    public List querySoftwareCopyright(String entId);
}
