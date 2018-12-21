package jll.message.dao.service.impl;

import com.cn.zyzs.hibernate.util.Page;
import com.cn.zyzs.utils.utils.PageContext;
import com.cn.zyzs.utils.utils.PageView;
import jll.apply_evaluate.dao.AuthEnterpriseDao;
import jll.message.dao.service.AuthEnterpriseBaseService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service("authEnterpriseBaseService")
@Transactional
public class AuthEnterpriseBaseServiceImpl implements AuthEnterpriseBaseService {


    @Autowired
    private AuthEnterpriseDao authEnterpriseDao;//申请模块

    @Override
    public Object findAuthEnterpriseBaseByOrgIndustry(String authOrgId, String name, String typesEnterprises,Integer page,Integer rows) {
        try {
            Map param = new HashedMap();
            PageContext.setOffSet(page);
            PageContext.setPageSize(rows);
            Page pages= authEnterpriseDao.queryAuthEnterpriseBaseByOrgIndustry(authOrgId,name,typesEnterprises);
            PageView pageView = new PageView(PageContext.getPageSize(), PageContext.getOffSet());
            pageView.setTotalpage(pages.getTotal());
            pageView.setRecords(pages.getItems());
            return pageView;
        } catch (Exception e) {
            e.printStackTrace();
            return "500";
        }
    }
}
