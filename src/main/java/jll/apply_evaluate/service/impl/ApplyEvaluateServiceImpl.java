package jll.apply_evaluate.service.impl;

import com.cn.zyzs.hibernate.util.Page;
import com.cn.zyzs.utils.utils.PageContext;
import com.cn.zyzs.utils.utils.PageView;
import jll.apply_evaluate.dao.ApplyEvaluateDao;
import jll.apply_evaluate.dao.ApplyModuleDao;
import jll.apply_evaluate.service.ApplyEvaluateService;
import jll.model.apply_evaluate.ApplyEvaluate;
import jll.model.apply_evaluate.ApplyModule;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("applyEvaluateService")
@Transactional
public class ApplyEvaluateServiceImpl implements ApplyEvaluateService {

    @Autowired
    private ApplyEvaluateDao applyEvaluateDao;//申请评价

    @Autowired
    private ApplyModuleDao applyModuleDao;//申请模块

    @Override
    public Object findApplyEvaluateForApplyStatus(String entId, Integer page, Integer rows) {
        try {
            Map param = new HashedMap();
            PageContext.setOffSet(page);
            PageContext.setPageSize(rows);
            Page pages=applyEvaluateDao.queryApplyEvaluateForApplyStatus(entId);
            PageView pageView = new PageView(PageContext.getPageSize(), PageContext.getOffSet());
            pageView.setTotalpage(pages.getTotal());
            pageView.setRecords(pages.getItems());
            return pageView;
        } catch (Exception e) {
            e.printStackTrace();
            return "500";
        }
    }

    @Override
    public Object findApplyEvaluateByDate(String entId, Integer page, Integer rows, String date) {
        try {
            Map param = new HashedMap();
            PageContext.setOffSet(page);
            PageContext.setPageSize(rows);
            Page pages=applyEvaluateDao.queryApplyEvaluateByDate(entId,date);
            PageView pageView = new PageView(PageContext.getPageSize(), PageContext.getOffSet());
            pageView.setTotalpage(pages.getTotal());
            pageView.setRecords(pages.getItems());
            return pageView;
        } catch (Exception e) {
            e.printStackTrace();
            return "500";
        }
    }

    @Override
    public Object findApplyEvaluateDetailByApplyEvaluateId(String applyEvaluateId) {
        //查询请求详情
        Object obj=applyEvaluateDao.queryApplyEvaluateDetailByApplyEvaluateId(applyEvaluateId);
        //查询请求模块
        List list=applyModuleDao.queryApplyModuleByApplyEvaluateIdForAll(applyEvaluateId);
        Map map=new HashMap();
        map.put("detail",obj);
        map.put("modules",list);
        return map;
    }

    @Override
    public void editApplyEvaluateForAuditStatus(String applyEvaluateId,String[] module) {
        //申请的审核状态变为1(待审核)申请状态变为4(已完成)
        applyEvaluateDao.updateApplyEvaluateForAuditStatus(applyEvaluateId,"4","1");
        //添加申请模块
        for(String str:module){
            ApplyModule am=new ApplyModule();
            am.setApply_permission_id(str);
            am.setApply_evaluate_id(applyEvaluateId);
            applyModuleDao.saveApplyModule(am);
        }
    }

    @Override
    public Object findApplyEvaluateForAuditStatus(String authOrgId, Integer page, Integer rows,String name,String date,String type,String status) {
        try {
            Map param = new HashedMap();
            PageContext.setOffSet(page);
            PageContext.setPageSize(rows);
            Page pages=applyEvaluateDao.queryApplyEvaluateForAuditStatus(authOrgId,name,date,type,status);
            PageView pageView = new PageView(PageContext.getPageSize(), PageContext.getOffSet());
            pageView.setTotalpage(pages.getTotal());
            pageView.setRecords(pages.getItems());
            return pageView;
        } catch (Exception e) {
            e.printStackTrace();
            return "500";
        }
    }

    @Override
    public Object findApplyEvaluateForCreditEvaluate(String authOrgId, String name, String date, String level, String auditStatus,Integer page,Integer rows) {
        try {
            Map param = new HashedMap();
            PageContext.setOffSet(page);
            PageContext.setPageSize(rows);
            Page pages=applyEvaluateDao.queryApplyEvaluateForCreditEvaluate(authOrgId,name,date,level,auditStatus);
            PageView pageView = new PageView(PageContext.getPageSize(), PageContext.getOffSet());
            pageView.setTotalpage(pages.getTotal());
            pageView.setRecords(pages.getItems());
            return pageView;
        } catch (Exception e) {
            e.printStackTrace();
            return "500";
        }
    }

    @Override
    public Object findApplyEvaluateByAuditStatusForCount(String authOrgId, String auditStatus) {
        return applyEvaluateDao.queryApplyEvaluateByAuditStatusForCount(authOrgId,auditStatus);
    }

    @Override
    public void editApplyEvaluateByRemarks(String applyEvaluateId, String remarks) {
        applyEvaluateDao.updateApplyEvaluateForRemarks(applyEvaluateId,null,remarks);
    }

    @Override
    public Object findApplyEvaluateByAuthEnterpriseId(String authEnterpriseId, String date, String level, Integer page, Integer rows) {
        try {
            Map param = new HashedMap();
            PageContext.setOffSet(page);
            PageContext.setPageSize(rows);
            Page pages=applyEvaluateDao.queryApplyEvaluateByAuthEnterpriseId(authEnterpriseId,date,level);
            PageView pageView = new PageView(PageContext.getPageSize(), PageContext.getOffSet());
            pageView.setTotalpage(pages.getTotal());
            pageView.setRecords(pages.getItems());
            return pageView;
        } catch (Exception e) {
            e.printStackTrace();
            return "500";
        }
    }

    @Override
    public Object findApplyEvaluateByAuthEnterpriseIdForAppeal(String authEnterpriseId, String date, String level, Integer page, Integer rows) {
        try {
            Map param = new HashedMap();
            PageContext.setOffSet(page);
            PageContext.setPageSize(rows);
            Page pages=applyEvaluateDao.queryApplyEvaluateByAuthEnterpriseIdForAppeal(authEnterpriseId,date,level);
            PageView pageView = new PageView(PageContext.getPageSize(), PageContext.getOffSet());
            pageView.setTotalpage(pages.getTotal());
            pageView.setRecords(pages.getItems());
            return pageView;
        } catch (Exception e) {
            e.printStackTrace();
            return "500";
        }
    }

    @Override
    public void editApplyEvaluateForAuditStatusOrAppealStatus(String applyEvaluateId) {
        //申请的审核状态变为1(待审核)申请状态变为4(已完成)
        applyEvaluateDao.updateApplyEvaluateForAuditStatus(applyEvaluateId,"4","4");
        //查询申诉详情
        ApplyEvaluate ae=applyEvaluateDao.queryApplyEvaluateByApplyEvaluateId(applyEvaluateId);
        //如果申诉状态不为空修改申诉状态
        if(ae.getAppeal_status()!=null&&!ae.getAppeal_status().equals("")){
            applyEvaluateDao.updateApplyEvaluateForAppealStatus(applyEvaluateId,"4");
        }
    }
}
