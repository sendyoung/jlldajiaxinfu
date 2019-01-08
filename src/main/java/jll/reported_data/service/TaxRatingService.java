package jll.reported_data.service;

import jll.model.BasicPnformationSubmit.TaxRating;

import java.util.List;

public interface TaxRatingService {
    /**
     * 添加纳税评级
     */
    public void addTaxRating(List<TaxRating> taxRating);

    /**
     * 查询纳税评级
     */
    public List queryTaxRating(String entId);
}
