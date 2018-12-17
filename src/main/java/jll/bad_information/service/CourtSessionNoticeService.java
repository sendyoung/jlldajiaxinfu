package jll.bad_information.service;

import jll.model.bad_information.CourtSessionNotice;

import java.util.List;

public interface CourtSessionNoticeService {

    /**
     *获取开庭公告信息
     * */
    public List getCourtSessionNotice(String entId);
    /**
     * 添加开庭公告信息
     * */
    public void editCourtSessionNotice(List<CourtSessionNotice> csnList);

}
