package jll.reported_data.service;


import jll.model.basic_pnformation_submit.CopyrightInWorks;

import java.util.List;

public interface WorkCopyrightService {
    /**
     * 添加作品著作权
     */
    public void addWorkCopyright(List<CopyrightInWorks> copyrightInWorks);

    /**
     * 查询作品著作权
     */
    public List queryWorkCopyright(String entId);


}
