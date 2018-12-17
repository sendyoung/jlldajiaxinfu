package jll.bad_information.service;

import jll.model.bad_information.JudicialAssistance;

import java.util.List;

public interface JudicialAssistanceService {

    /**
     *获取司法协助信息
     * */
    public List getJudicialAssistance(String entId);
    /**
     * 添加司法协助信息
     * */
    public void editJudicialAssistance(List<JudicialAssistance> jaList);

}
