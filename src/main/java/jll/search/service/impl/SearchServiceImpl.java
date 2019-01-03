package jll.search.service.impl;

import jll.search.dao.SearchDao;
import jll.search.dao.SearchDetailDao;
import jll.search.service.SearchService;
import jll.utils.HibernatePageUtil;
import jll.utils.XinfuResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashMap;
import java.util.Map;

@Service("searchService")
@Transactional
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SearchDao searchDao;
    @Autowired
    private SearchDetailDao searchDetailDao;

    /**
     * 根据企业名称模糊匹配结果
     */
    @Override
    public XinfuResult findEntList(String qName, int currentPage, int rows) {
        try {
            if (qName!=null &&!"".equals(qName)){
                return XinfuResult.build(200,"查到相关数据",HibernatePageUtil.sqlPageUtil(searchDao.findEntList(qName),currentPage,rows));
                //return HibernatePageUtil.sqlPageUtil(searchDao.findEntList(qName),currentPage,rows);
            }else{
                return XinfuResult.build(300,"搜索条件不能为空");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return XinfuResult.build(400,"程序出现异常");
        }
    }

   /* @Override
    public List<User> testUser(String realname) {
        return searchDao.testUser(realname);
    }*/

   //基础信息
    @Override
    public Map findBasicsInformation(String entId,int currentPage,int rows) {
        Map map = new LinkedHashMap();
        //工商信息
        map.put("entBasics",searchDetailDao.findEntBasicsByEntId(entId));
        //股东出资信息
        map.put("entShareholder",HibernatePageUtil.sqlPageUtil(searchDetailDao.findEntShareholderList(entId),currentPage,rows));
        //疑似实际控制人
        map.put("entActualController",searchDetailDao.findEntActual(entId));
        //变更记录
        map.put("entChangeRecord",HibernatePageUtil.sqlPageUtil(searchDetailDao.findEntChangeRecordList(entId),currentPage,rows));
        //员工信息
        map.put("entEmployee",HibernatePageUtil.sqlPageUtil(searchDetailDao.findEntEmployeeList(entId),currentPage,rows));
        //分支机构-分公司
        map.put("entBranchOffice",HibernatePageUtil.sqlPageUtil(searchDetailDao.findEntBranchOffice(entId),currentPage,rows));
        //专利信息
        map.put("entPatentInformation",HibernatePageUtil.sqlPageUtil(searchDetailDao.findEntPatentInformation(entId),currentPage,rows));
        //...略
        return map;
    }

    //社会信用信息
    @Override
    public Map findSocialCreditInfomation(String entId,int currentPage,int rows) {
        Map map = new LinkedHashMap();
        //行政许可
        map.put("entAdministrativeLicensing",HibernatePageUtil.sqlPageUtil(searchDetailDao.findEntAdministrativeLicensing(entId),currentPage,rows));
        //...略
        return map;
    }

    //经营信息
    @Override
    public Map findBusinessInformation(String entId,int currentPage,int rows) {
        Map map = new LinkedHashMap();
        //资质认证
        map.put("entAptitudesAuthentication",HibernatePageUtil.sqlPageUtil(searchDetailDao.findEntAptitudesAuthentication(entId),currentPage,rows));
        //...略
        return null;
    }

    //金融信用信息
    @Override
    public Map findFinancialCredit(String entId,int currentPage,int rows) {
        Map map = new LinkedHashMap();
        //股权投资
        map.put("entEquityInvestment",HibernatePageUtil.sqlPageUtil(searchDetailDao.findEntEquityInvestment(entId),currentPage,rows));
        //...略
        return map;
    }
}
