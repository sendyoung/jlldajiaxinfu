package jll.apply_evaluate.service;

public interface ApplyEvaluateService {
    /**
     * 查询企业已有关联关系的组织信息
     * */
    public Object findApplyEvaluateForApplyStatus(String entId,Integer page,Integer rows);
    /**
     * 根据所属行业查询可申请组织并查询企业关联
     * */
    public Object findApplyEvaluateByIndustry(String authEnterpriseId,String industry,Integer page,Integer rows);
    /**
     * 根据日期查询企业历史申请信息
     * */
    public Object findApplyEvaluateByDate(String entId,Integer page,Integer rows,String date);
    /**
     * 查看历史申请详情
     * */
    public Object findApplyEvaluateDetailByApplyEvaluateId(String applyEvaluateId);
    /**
     * 申请完成
     * */
    public void editApplyEvaluateForAuditStatus(String applyEvaluateId,String[] module);
    /**
     * 查询组织的所有审核
     * */
    public Object findApplyEvaluateForAuditStatus(String authOrgId,Integer page,Integer rows,String name,String date,String type,String status);
    /**
     * 查询组织所有的信用评价
     * */
    public Object findApplyEvaluateForCreditEvaluate(String authOrgId,String name,String date,String level,String auditStatus,Integer page,Integer rows);
    /**
     * 查询组织所有的各审核状态数量
     * */
    public Object findApplyEvaluateByAuditStatusForCount(String authOrgId,String auditStatus);
    /**
     * 添加评价批语
     * */
    public void editApplyEvaluateByRemarks(String applyEvaluateId,String remarks);
    /**
     * 查询企业的所有请求
     * */
    public Object findApplyEvaluateByAuthEnterpriseId(String authEnterpriseId,String date,String level,Integer page,Integer rows);
    /**
     * 查询企业的所有可申诉请求（评价已完成）
     * */
    public Object findApplyEvaluateByAuthEnterpriseIdForAppeal(String authEnterpriseId,String date,String level,Integer page,Integer rows);
    /**
     * 评分完成
     * */
    public void editApplyEvaluateForAuditStatusOrAppealStatus(String applyEvaluateId);
    /**
     *  组织企业建立关系
     * */
    public void authOrgIdApplyEvaluateForApply(String authEnterpriseId,String authOrgId,String status);
}
