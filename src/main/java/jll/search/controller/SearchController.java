package jll.search.controller;

import jll.search.service.SearchService;
import jll.utils.XinfuResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@Scope("prototype")
public class SearchController {

    @Autowired
    private SearchService searchService;

    /*@CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/testuser",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody
    List<User> testuser(@RequestParam String realname){
        return searchService.testUser(realname);
    }*/

    /**
     * 根据企业名称模糊匹配结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST},value = {"/entlist"})
    public @ResponseBody
    XinfuResult findEntList(String qName,@RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "10") int rows){
        return searchService.findEntList(qName,currentPage,rows);
    }

    /**
     * 详情页基础信息
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST},value = {"/basicsInformation"})
    public @ResponseBody
    Map findBasicsInformation(String entId, @RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "10") int rows){
        return searchService.findBasicsInformation(entId,currentPage,rows);
    }

    /**
     * 详情页社会信用信息
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST},value = {"/socialCreditInfomation"})
    public @ResponseBody
    Map findSocialCreditInfomation(String entId, @RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "10") int rows){
        return searchService.findSocialCreditInfomation(entId,currentPage,rows);
    }

    /**
     * 经营信息
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST},value = {"/businessInformation"})
    public @ResponseBody
    Map findBusinessInformation(String entId, @RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "10") int rows){
        return searchService.findBusinessInformation(entId,currentPage,rows);
    }

    /**
     * 金融信用信息
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST},value = {"/financialCredit"})
    public @ResponseBody
    Map findFinancialCredit(String entId, @RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "10") int rows){
        return searchService.findFinancialCredit(entId,currentPage,rows);
    }
}
