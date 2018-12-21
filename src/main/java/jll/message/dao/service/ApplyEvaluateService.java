package jll.message.dao.service;

public interface ApplyEvaluateService {
    /**
     * 查询企业已有关联关系的组织信息
     * */
    public Object findApplyEvaluateForApplyStatus(String entId,Integer page,Integer rows);
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
}
