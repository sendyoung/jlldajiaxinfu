package jll.bad_information.service;

import jll.model.bad_information.Contravention;

import java.util.List;

public interface ContraventionService {

    /**
     *获取欠税公告信息
     * */
    public List getContravention(String entId);
    /**
     * 添加欠税公告信息
     * */
    public void editContravention(List<Contravention> cList);

}
