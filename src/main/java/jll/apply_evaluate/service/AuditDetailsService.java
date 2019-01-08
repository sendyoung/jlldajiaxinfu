package jll.apply_evaluate.service;

public interface AuditDetailsService {

    /**
     * 查询工商信息
     * */
    public Object findBasicInformation(String entId);
    public Object findBasicInformation(String entId,String info,Integer page,Integer rows);
    /**
     * 统计良好信息
     * */
    public Object findGoodInformationForCount(String entId);
    /**
     * 统计不良信息
     * */
    public Object findBadInformationForCount(String entId);
    /**
     * 管理对象信息
     * */
    public Object findManageObjectInformation(String entId);
    /**
     * 查询财务信息
     * */
    public Object findFinanceInformation(String entId);
    /**
     * 查询良好信息
     * */
    public Object findGoodInformationForPage(String entId,String info,Integer page,Integer rows);
    /**
     * 查询不良信息
     * */
    public Object findBadInformationForPage(String entId,String info,Integer page,Integer rows);
}
