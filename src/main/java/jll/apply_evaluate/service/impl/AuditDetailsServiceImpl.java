package jll.apply_evaluate.service.impl;

import jll.account_authentication.dao.EntBasicsDao;
import jll.apply_evaluate.service.AuditDetailsService;
import jll.bad_information.dao.*;
import jll.data_list.dao.*;
import jll.good_information.dao.HonorDao;
import jll.good_information.dao.IndustryInfrastructureDao;
import jll.good_information.dao.OthersCertificateDao;
import jll.good_information.dao.PublicWelfareActivityDao;
import jll.utils.DateUtils;
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


    @Override
    public Object findBasicInformation(String entId) {
        Map map=new HashMap();
        map.put("entBasics",entBasicsDao.queryEntBasicsByEntId(entId));
        return map;
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
}
