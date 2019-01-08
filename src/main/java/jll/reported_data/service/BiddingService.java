package jll.reported_data.service;

import jll.model.basic_pnformation_submit.Bidding;

import java.util.List;

public interface BiddingService {
    /**
     * 添加招投标信息
     */
    public void addBidding(List<Bidding> bidding);

    /**
     * 查询招投标信息
     */
    public List queryBidding(String entId);
}
