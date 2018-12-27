package jll.account_authentication.service;

import jll.model.Industry;

import java.util.List;

public interface IndustryService {
    /**
     * 查询行业
     * */
    public List<Industry> findIndustry();
}
