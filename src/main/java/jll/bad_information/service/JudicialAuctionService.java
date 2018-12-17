package jll.bad_information.service;

import jll.model.bad_information.JudicialAuction;

import java.util.List;

public interface JudicialAuctionService {

    /**
     *获取司法拍卖信息
     * */
    public List getJudicialAuction(String entId);
    /**
     * 添加司法拍卖信息
     * */
    public void editJudicialAuction(List<JudicialAuction> jaList);

}
