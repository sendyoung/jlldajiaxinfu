package jll.apply_evaluate.service.impl;

import com.cn.zyzs.hibernate.util.Page;
import com.cn.zyzs.utils.utils.PageContext;
import com.cn.zyzs.utils.utils.PageView;
import jll.account_authentication.dao.EntBasicsDao;
import jll.apply_evaluate.service.AuditDetailsService;
import jll.bad_information.dao.*;
import jll.data_list.dao.*;
import jll.good_information.dao.HonorDao;
import jll.good_information.dao.IndustryInfrastructureDao;
import jll.good_information.dao.OthersCertificateDao;
import jll.good_information.dao.PublicWelfareActivityDao;
import jll.reported_data.dao.*;
import jll.utils.DateUtils;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service("auditDetailsService")
@Transactional
public class AuditDetailsServiceImpl implements AuditDetailsService {

    @Autowired
    private EntBasicsDao entBasicsDao;//工商信息
    @Autowired
    private HonorDao honorDao;//表彰信息
    @Autowired
    private IndustryInfrastructureDao industryInfrastructureDao;//行业基础建设
    @Autowired
    private OthersCertificateDao othersCertificateDao;//其他证书
    @Autowired
    private PublicWelfareActivityDao publicWelfareActivityDao;//公益
    @Autowired
    private AdjudicativeDocumentDao adjudicativeDocumentDao;//裁判文书
    @Autowired
    private AdministrativePublishmentDao administrativePublishmentDao;//行政处罚
    @Autowired
    private AdministrativeSanctionDao administrativeSanctionDao;//海关行政处罚
    @Autowired
    private ContraventionDao contraventionDao;//欠税公告
    @Autowired
    private CourtSessionNoticeDao courtSessionNoticeDao;//开庭公告
    @Autowired
    private DiscreditExecutorDao discreditExecutorDao;//失信被执行人
    @Autowired
    private EnvironmentPunishmentDao environmentPunishmentDao;//环保处罚
    @Autowired
    private ExecutorDao executorDao;//被执行人
    @Autowired
    private JudicialAssistanceDao judicialAssistanceDao;//司法协助
    @Autowired
    private JudicialAuctionDao judicialAuctionDao;//司法拍卖
    @Autowired
    private UnusualBusinessListDao unusualBusinessListDao;//经营异常
    @Autowired
    private BranchOfficeDao branchOfficeDao;//分公司
    @Autowired
    private SubsidiaryCompanyDao subsidiaryCompanyDao;//子公司
    @Autowired
    private IncomeStatementDao incomeStatementDao;//财务利润
    @Autowired
    private CashFlowStatementDao cashFlowStatementDao;//财务现金流量
    @Autowired
    private OffBalanceSheetDao offBalanceSheetDao;//财务资产负债
    @Autowired
    private AdministrativeLicenseDao administrativeLicenseDao;//行政许可信息
    @Autowired
    private AutoConstructionDao autoConstructionDao;//自动化建设信息
    @Autowired
    private BiddingDao biddingDao;//招投标信息
    @Autowired
    private CertificationDao certificationDao;//资质认证
    @Autowired
    private ChangeInformationDao changeInformationDao;//变更记录信息
    @Autowired
    private ChattelMortgageDao chattelMortgageDao;//动产抵押
    @Autowired
    private ContactStaffDao contactStaffDao;//联系人员填报
    @Autowired
    private CreativityDao creativityDao;//创新能力
    @Autowired
    private CreditEvaluationDao creditEvaluationDao;//主体信用评价
    @Autowired
    private CreditHistoryDao creditHistoryDao;//信用记录
    @Autowired
    private CustomsCreditDao customsCreditDao;//海关信用信息
    @Autowired
    private CustomsRegistrationDao customsRegistrationDao;//海关注册信息
    @Autowired
    private DebtfinancingDao debtfinancingDao;//债权融资
    @Autowired
    private DebtInvestmentDao debtInvestmentDao;//债权投资
    @Autowired
    private EnvironmentalCertificationDao environmentalCertificationDao;//环保体系认证
    @Autowired
    private EquityFinancingDao equityFinancingDao;//股权融资
    @Autowired
    private EquityInvestmentDao equityInvestmentDao;//股权投资
    @Autowired
    private EquityRegistrationDao equityRegistrationDao;//股权出质登记信息
    @Autowired
    private ExternalGuaranteeDao externalGuaranteeDao;//对外担保信息
    @Autowired
    private InPropertyRightsDao inPropertyRightsDao;//知识产权出质信息
    @Autowired
    private PatentDao patentDao;//专利信息
    @Autowired
    private ProductDao productDao;//产品信息
    @Autowired
    private PublicNoticeDao publicNoticeDao;//公示催告
    @Autowired
    private ShareholdersInvestmentDao shareholdersInvestmentDao;//股东出资信息
    @Autowired
    private SocialSecurityDao socialSecurityDao;//社保方面
    @Autowired
    private SoftwareCopyrightDao softwareCopyrightDao;//软件著作权
    @Autowired
    private SpotCheckDao spotCheckDao;//检查信息
    @Autowired
    private TaxRatingDao taxRatingDao;//纳税评级
    @Autowired
    private TheActualControllerDao theActualControllerDao;//实际控制人填报
    @Autowired
    private TheProductionStatusDao theProductionStatusDao;//生产情况
    @Autowired
    private TrademarkDao trademarkDao;//商标信息
    @Autowired
    private WebsiteFilingDao websiteFilingDao;//网站备案
    @Autowired
    private WorkCopyrightDao workCopyrightDao;//作品著作权

    @Override
    public Object findBasicInformation(String entId) {
        return entBasicsDao.queryEntBasicsByEntId(entId);
    }

    @Override
    public Object findBasicInformation(String entId, String info, Integer page, Integer rows) {
        try {
            Map param = new HashedMap();
            PageContext.setOffSet(page);
            PageContext.setPageSize(rows);
            Page pages=new Page();
            if("administrativeLicense".equals(info)){
                pages=administrativeLicenseDao.queryAdministrativeLicenseForPage(entId);//行政许可信息
            }else if("autoConstruction".equals(info)){
                pages=autoConstructionDao.queryAutomationConstructionForPage(entId);
            }else if("bidding".equals(info)){
                pages=biddingDao.queryBiddingForPage(entId);
            }else if("certification".equals(info)){
                pages=certificationDao.queryCertificationForPage(entId);
            }else if("changeInformation".equals(info)){
                pages=changeInformationDao.queryChangeInformationForPage(entId);
            }else if("chattelMortgage".equals(info)){
                pages=chattelMortgageDao.queryChattelMortgageForPage(entId);
            }else if("contactStaff".equals(info)){
                pages=contactStaffDao.queryContactStaffForPage(entId);
            }else if("creativity".equals(info)){
                pages=creativityDao.queryCreativityForPage(entId);
            }else if("creditEvaluation".equals(info)){
                pages=creditEvaluationDao.queryCreditEvaluationForPage(entId);
            }else if("creditHistory".equals(info)){
                pages=creditHistoryDao.queryCreditHistoryForPage(entId);
            }else if("customsCredit".equals(info)){
                pages=customsCreditDao.queryCustomsCreditForPage(entId);
            }else if("customsRegistration".equals(info)){
                pages=customsRegistrationDao.queryCustomsRegistrationForPage(entId);
            }else if("debtfinancing".equals(info)){
                pages=debtfinancingDao.queryDebtfinancingForPage(entId);
            }else if("debtInvestment".equals(info)){
                pages=debtInvestmentDao.queryDebtInvestmentForPage(entId);
            }else if("environmentalCertification".equals(info)){
                pages=environmentalCertificationDao.queryEnvironmentalCertificationForPage(entId);
            }else if("equityFinancing".equals(info)){
                pages=equityFinancingDao.queryEquityFinancingForPage(entId);
            }else if("equityInvestment".equals(info)){
                pages=equityInvestmentDao.queryEquityInvestmentForPage(entId);
            }else if("equityRegistration".equals(info)){
                pages=equityRegistrationDao.queryEquityRegistrationForPage(entId);
            }else if("externalGuarantee".equals(info)){
                pages=externalGuaranteeDao.queryExternalGuaranteeForPage(entId);
            }else if("inPropertyRights".equals(info)){
                pages=inPropertyRightsDao.queryInPropertyRightsForPage(entId);
            }else if("patent".equals(info)){
                pages=patentDao.queryPatentForPage(entId);
            }else if("product".equals(info)){
                pages=productDao.queryProductForPage(entId);
            }else if("publicNotice".equals(info)){
                pages=publicNoticeDao.queryPublicNoticeForPage(entId);
            }else if("shareholdersInvestment".equals(info)){
                pages=shareholdersInvestmentDao.queryShareholdersInvestmentForPage(entId);
            }else if("socialSecurity".equals(info)){
                pages=socialSecurityDao.querySocialSecurityForPage(entId);
            }else if("softwareCopyright".equals(info)){
                pages=softwareCopyrightDao.querySoftwareCopyrightForPage(entId);
            }else if("spotCheck".equals(info)){
                pages=spotCheckDao.querySpotCheckForPage(entId);
            }else if("taxRating".equals(info)){
                pages=taxRatingDao.queryTaxRatingForPage(entId);
            }else if("theActualController".equals(info)){
                pages=theActualControllerDao.queryTheActualControllerForPage(entId);
            }else if("theProductionStatus".equals(info)){
                pages=theProductionStatusDao.queryTheProductionStatusForPage(entId);
            }else if("trademark".equals(info)){
                pages=trademarkDao.queryTrademarkForPage(entId);
            }else if("websiteFiling".equals(info)){
                pages=websiteFilingDao.queryWebsiteFilingForPage(entId);
            }else if("workCopyright".equals(info)){
                pages=workCopyrightDao.queryWorkCopyrightForPage(entId);
            }
            PageView pageView = new PageView(PageContext.getPageSize(), PageContext.getOffSet());
            pageView.setTotalpage(pages.getTotal());
            pageView.setRecords(pages.getItems());
            return pageView;
        } catch (Exception e) {
            e.printStackTrace();
            return "500";
        }
    }

    @Override
    public Object findGoodInformationForCount(String entId) {
        Map map=new HashMap();
        map.put("honor",honorDao.queryHonorForCount(entId));
        map.put("industryInfrastructure",industryInfrastructureDao.queryIndustryInfrastructureForCount(entId));
        map.put("othersCertificate",othersCertificateDao.queryOthersCertificateForCount(entId));
        map.put("publicWelfareActivity",publicWelfareActivityDao.queryPublicWelfareActivityForCount(entId));
        return map;
    }

    @Override
    public Object findBadInformationForCount(String entId) {
        Map map=new HashMap();
        map.put("adjudicativeDocument",adjudicativeDocumentDao.queryAdjudicativeDocumentForCount(entId));
        map.put("administrativePublishment",administrativePublishmentDao.queryAdministrativePublishmentForCount(entId));
        map.put("administrativeSanction",administrativeSanctionDao.queryAdministrativeSanctionForCount(entId));
        map.put("contravention",contraventionDao.queryContraventionForCount(entId));
        map.put("courtSessionNotice",courtSessionNoticeDao.queryCourtSessionNoticeForCount(entId));
        map.put("discreditExecutor",discreditExecutorDao.queryDiscreditExecutorForCount(entId));
        map.put("environmentPunishment",environmentPunishmentDao.queryEnvironmentPunishmentForCount(entId));
        map.put("executor",executorDao.queryExecutorForCount(entId));
        map.put("judicialAssistance",judicialAssistanceDao.queryJudicialAssistanceForCount(entId));
        map.put("judicialAuction",judicialAuctionDao.queryJudicialAuctionForCount(entId));
        map.put("unusualBusinessList",unusualBusinessListDao.queryUnusualBusinessListForCount(entId));
        return map;
    }

    @Override
    public Object findManageObjectInformation(String entId) {
        Map map=new HashMap();
        map.put("branchOffice",branchOfficeDao.queryBranchOfficeByEntId(entId));
        map.put("subsidiaryCompany",subsidiaryCompanyDao.querySubsidiaryCompanyByEntId(entId));
        return map;
    }

    @Override
    public Object findFinanceInformation(String entId) {
        String oneYear=DateUtils.getYear(1)+"";
        String twoYear=DateUtils.getYear(2)+"";
        String threeYear=DateUtils.getYear(3)+"";
        Map map=new HashMap();
        map.put("year",DateUtils.getYear(0));
        map.put("incomeStatement",incomeStatementDao.queryIncomeStatementByEntId(entId,oneYear,twoYear,threeYear));
        map.put("cashFlowStatement",cashFlowStatementDao.queryCashFlowStatementByEntId(entId,oneYear,twoYear,threeYear));
        map.put("offBalanceSheet",offBalanceSheetDao.queryOffBalanceSheetByEntId(entId,oneYear,twoYear,threeYear));
        return map;
    }

    @Override
    public Object findGoodInformationForPage(String entId, String info, Integer page, Integer rows) {
        try {
            Map param = new HashedMap();
            PageContext.setOffSet(page);
            PageContext.setPageSize(rows);
            Page pages=new Page();
            if("honor".equals(info)){
                pages=honorDao.queryHonorForPage(entId);
            }else if("industryInfrastructure".equals(info)){
                pages=industryInfrastructureDao.queryIndustryInfrastructureForPage(entId);
            }else if("othersCertificate".equals(info)){
                pages=othersCertificateDao.queryOthersCertificateForPage(entId);
            }else if("publicWelfareActivity".equals(info)){
                pages=publicWelfareActivityDao.queryPublicWelfareActivityForPage(entId);
            }
            PageView pageView = new PageView(PageContext.getPageSize(), PageContext.getOffSet());
            pageView.setTotalpage(pages.getTotal());
            pageView.setRecords(pages.getItems());
            return pageView;
        } catch (Exception e) {
            e.printStackTrace();
            return "500";
        }
    }

    @Override
    public Object findBadInformationForPage(String entId, String info, Integer page, Integer rows) {
        try {
            Map param = new HashedMap();
            PageContext.setOffSet(page);
            PageContext.setPageSize(rows);
            Page pages=new Page();
            if("adjudicativeDocument".equals(info)){
                pages=adjudicativeDocumentDao.queryAdjudicativeDocumentForPage(entId);
            }else if("administrativePublishment".equals(info)){
                pages=administrativePublishmentDao.queryAdministrativePublishmentForPage(entId);
            }else if("administrativeSanction".equals(info)){
                pages=administrativeSanctionDao.queryAdministrativeSanctionForPage(entId);
            }else if("contravention".equals(info)){
                pages=contraventionDao.queryContraventionForPage(entId);
            }else if("courtSessionNotice".equals(info)){
                pages=courtSessionNoticeDao.queryCourtSessionNoticeForPage(entId);
            }else if("discreditExecutor".equals(info)){
                pages=discreditExecutorDao.queryDiscreditExecutorForPage(entId);
            }else if("environmentPunishment".equals(info)){
                pages=environmentPunishmentDao.queryEnvironmentPunishmentForPage(entId);
            }else if("executor".equals(info)){
                pages=executorDao.queryExecutorForPage(entId);
            }else if("judicialAssistance".equals(info)){
                pages=judicialAssistanceDao.queryJudicialAssistanceForPage(entId);
            }else if("judicialAuction".equals(info)){
                pages=judicialAuctionDao.queryJudicialAuctionForPage(entId);
            }else if("unusualBusinessList".equals(info)){
                pages=unusualBusinessListDao.queryUnusualBusinessListForPage(entId);
            }
            PageView pageView = new PageView(PageContext.getPageSize(), PageContext.getOffSet());
            pageView.setTotalpage(pages.getTotal());
            pageView.setRecords(pages.getItems());
            return pageView;
        } catch (Exception e) {
            e.printStackTrace();
            return "500";
        }
    }
}
