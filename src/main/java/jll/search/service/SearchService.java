package jll.search.service;

import jll.utils.XinfuResult;

import java.util.Map;

public interface SearchService {

    //查看列表
    public XinfuResult findEntList(String qName, int currentPage, int rows);

    //public List<User> testUser(String realname);

    //查询基础信用信息
    public Map findBasicsInformation(String entId,int currentPage,int rows);

    //查询社会信用信息
    public Map findSocialCreditInfomation(String entId,int currentPage,int rows);

    //经营信息
    public Map findBusinessInformation(String entId,int currentPage,int rows);

    //金融信用信息
    public Map findFinancialCredit(String entId,int currentPage,int rows);

    //财务信息

}
