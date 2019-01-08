package jll.reported_data.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import jll.model.basic_pnformation_submit.*;
import jll.reported_data.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 企业信息填报controller层
 */

@Controller
@Scope("prototype")
@RequestMapping("/enterprise")

public class EnterpriseInformationFillingController {
    @Autowired
    private AdministrativeLicenseService administrativeLicenseService; //行政许可

    @Autowired
    private AutoConstructionService autoConstructionService; //自动化建设

    @Autowired
    private BiddingService biddingService; //招投标信息

    @Autowired
    private CertificationService certificationService; //资质认证

    @Autowired
    private ChangeInformationService changeInformationService; //变更记录

    @Autowired
    private ChattelMortgageService chattelMortgageService; //动产抵押信息

    @Autowired
    private ContactStaffService contactStaffService; //联系人员

    @Autowired
    private CreativityService creativityService; //创新能力

    @Autowired
    private CreditEvaluationService creditEvaluationService; //主体信用评价

    @Autowired
    private CreditHistoryService creditHistoryService; //信用记录

    @Autowired
    private CustomsCreditService customsCreditService; //海关信用信息

    @Autowired
    private CustomsRegistrationService customsRegistrationService; //海关注册信息

    @Autowired
    private DebtfinancingService debtfinancingService; //债权融资

    @Autowired
    private DebtInvestmentService debtInvestmentService; //债权投资

    @Autowired
    private EnvironmentalCertificationService environmentalCertificationService; //环保体系认证

    @Autowired
    private EquityFinancingService equityFinancingService; //股权融资

    @Autowired
    private EquityInvestmentService equityInvestmentService; //股权投资

    @Autowired
    private EquityRegistrationService equityRegistrationService; //股权出质登记信息

    @Autowired
    private ExternalGuaranteeService externalGuaranteeService; //对外担保信息

    @Autowired
    private InPropertyRightsService inPropertyRightsService; //知识产权出质

    @Autowired
    private PatentService patentService; //专利信息

    @Autowired
    private ProductService productService; //产品信息

    @Autowired
    private PublicNoticeService publicNoticeService; //公示催告

    @Autowired
    private ShareholdersInvestmentService shareholdersInvestmentService; //股东出资信息

    @Autowired
    private SocialSecurityService socialSecurityService; //社保方面

    @Autowired
    private SoftwareCopyrightService softwareCopyrightService; //软件著作权

    @Autowired
    private SpotCheckService spotCheckService; //抽查信息

    @Autowired
    private TaxRatingService taxRatingService; //纳税评级

    @Autowired
    private TheActualControllerService theActualControllerService; //实际控制人

    @Autowired
    private TheProductionStatusService theProductionStatusService; //生产情况

    @Autowired
    private TrademarkService trademarkService; //商标信息

    @Autowired
    private WebsiteFilingService websiteFilingService; //网站备案

    @Autowired
    private WorkCopyrightService workCopyrightService; //作品著作权

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/write")
    @ResponseBody
    public String getBarData(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("request : \t"+request.getParameter("entId"));
        //检测企业信息填报当前提交的是哪个表
        System.out.println("此时提交的表是"+request.getParameter("table_name"));
        System.out.println("传递的内容"+request.getParameter("fill_in_information"));
        String submitTableName = request.getParameter("table_name");

        if(submitTableName.equals("ent_administrative_licensing")){
            // 行政许可
            List<AdministrativeLicensing> objectList = JSON.parseArray(request.getParameter("fill_in_information"), AdministrativeLicensing.class);
            administrativeLicenseService.addAdministrativeLicense(objectList);

        }else if(submitTableName.equals("ent_automation_construction")){
            //自动化建设
            List<AutomationConstruction> objectList = JSON.parseArray(request.getParameter("fill_in_information"), AutomationConstruction.class);
            autoConstructionService.addAutoConstruction(objectList);
        }else if(submitTableName.equals("ent_Bidding")){
            //招投标信息
            List<Bidding> objectList = JSON.parseArray(request.getParameter("fill_in_information"), Bidding.class);
            biddingService.addBidding(objectList);
        }else if(submitTableName.equals("ent_aptitudes_authentication")){
            // 资质认证
            List<QualificationAuthentication> objectList = JSON.parseArray(request.getParameter("fill_in_information"), QualificationAuthentication.class);
            certificationService.addCertification(objectList);
        }else if(submitTableName.equals("ent_change_record")){
            // 变更记录
            List<ChangeRecord> objectList = JSONArray.parseArray(request.getParameter("fill_in_information"), ChangeRecord.class);
            changeInformationService.addChangeInformation(objectList);
        }else if(submitTableName.equals("ent_chattel_mortgage")){
            //动产抵押信息
            List<ChattelMortgage> objectList = JSON.parseArray(request.getParameter("fill_in_information"), ChattelMortgage.class);
            chattelMortgageService.addChattelMortgage(objectList);
        }else if(submitTableName.equals("ent_contact_personne")){
            // 联系人员
            List<ContactPersonnel> objectList = JSON.parseArray(request.getParameter("fill_in_information"), ContactPersonnel.class);
            contactStaffService.addContactStaff(objectList);
        }else if(submitTableName.equals("ent_innovation_ability")){
            // 创新能力
            List<InnovationAbility> objectList = JSON.parseArray(request.getParameter("fill_in_information"), InnovationAbility.class);
            creativityService.addTheProductionStatus(objectList);
        }else if(submitTableName.equals("ent_subjectCredit_evaluation")){
            // 主体信用评价
            List<SubjectCreditEvaluation> objectList = JSON.parseArray(request.getParameter("fill_in_information"), SubjectCreditEvaluation.class);
            creditEvaluationService.addCreditEvaluation(objectList);
        }else if(submitTableName.equals("ent_credit_record")){
            // 信用记录
            List<CreditRecord> objectList = JSON.parseArray(request.getParameter("fill_in_information"), CreditRecord.class);
            creditHistoryService.addCreditHistory(objectList);
        }else if(submitTableName.equals("ent_customs_credit")){
            // 海关信用信息
            List<CustomsCreditInformation> objectList = JSON.parseArray(request.getParameter("fill_in_information"), CustomsCreditInformation.class);
            customsCreditService.addCustomsCredit(objectList);
        }else if(submitTableName.equals("ent_customs_registration")){
            // 海关注册信息
            List<CustomsRegistrationInformation> objectList = JSON.parseArray(request.getParameter("fill_in_information"), CustomsRegistrationInformation.class);
            customsRegistrationService.addCustomsRegistration(objectList);
        }else if(submitTableName.equals("ent_bond_financing")){
            // 债权融资
            List<BondFinancing> objectList = JSON.parseArray(request.getParameter("fill_in_information"), BondFinancing.class);
            debtfinancingService.addDebtfinancing(objectList);
        }else if(submitTableName.equals("ent_creditor_rights_investment")){
            // 债权投资
            List<CreditorRightsInvestment> objectList = JSON.parseArray(request.getParameter("fill_in_information"), CreditorRightsInvestment.class);
            debtInvestmentService.addDebtInvestment(objectList);
        }else if(submitTableName.equals("ent_system_certification")){
            // 环保体系认证
            List<EnvironmentalProtectionSystemCertification> objectList = JSON.parseArray(request.getParameter("fill_in_information"), EnvironmentalProtectionSystemCertification.class);
            environmentalCertificationService.addEnvironmentalCertification(objectList);
        }else if(submitTableName.equals("ent_equity_financing")){
            // 股权融资
            List<EquityFinancing> objectList = JSON.parseArray(request.getParameter("fill_in_information"), EquityFinancing.class);
            equityFinancingService.addEquityFinancing(objectList);
        }else if(submitTableName.equals("ent_equity_investment")){
            // 股权投资
            List<EquityInvestment> objectList = JSON.parseArray(request.getParameter("fill_in_information"), EquityInvestment.class);
            equityInvestmentService.addEquityInvestment(objectList);
        }else if(submitTableName.equals("ent_share_pledge_registration")){
            // 股权出质登记信息
            List<SharePledgeRegistration> objectList = JSON.parseArray(request.getParameter("fill_in_information"), SharePledgeRegistration.class);
            equityRegistrationService.addEquityRegistration(objectList);
        }else if(submitTableName.equals("ent_external_guarantee")){
            // 对外担保信息
            List<ExternalGuaranteeInformation> objectList = JSON.parseArray(request.getParameter("fill_in_information"), ExternalGuaranteeInformation.class);
            externalGuaranteeService.addExternalGuarantee(objectList);
        }else if(submitTableName.equals("ent_intellectual_property")){
            // 知识产权出质
            List<IntellectualProperty> objectList = JSON.parseArray(request.getParameter("fill_in_information"), IntellectualProperty.class);
            inPropertyRightsService.addInPropertyRights(objectList);
        }else if(submitTableName.equals("ent_patent_information")){
            // 专利信息
            List<PatentInformation> objectList = JSON.parseArray(request.getParameter("fill_in_information"), PatentInformation.class);
            patentService.addPatent(objectList);
        }else if(submitTableName.equals("ent_product")){
            // 产品信息
            List<ProductInformation> objectList = JSON.parseArray(request.getParameter("fill_in_information"), ProductInformation.class);
            productService.addProduct(objectList);
        }else if(submitTableName.equals("ent_service_by_publication")){
            // 公示催告
            List<ServiceByPublication> objectList = JSON.parseArray(request.getParameter("fill_in_information"), ServiceByPublication.class);
            publicNoticeService.addPublicNotice(objectList);
        }else if(submitTableName.equals("ent_shareholder_contribution")){
            // 股东出资信息
            List<ShareholderContributionInfo> objectList = JSON.parseArray(request.getParameter("fill_in_information"), ShareholderContributionInfo.class);
            shareholdersInvestmentService.addShareholdersInvestment(objectList);
        }else if(submitTableName.equals("ent_social_security")){
            // 社保方面
            List<SocialSecurity> objectList = JSON.parseArray(request.getParameter("fill_in_information"), SocialSecurity.class);
            socialSecurityService.addSocialSecurity(objectList);
        }else if(submitTableName.equals("ent_software_copyright")){
            // 软件著作权
            List<SoftwareCopyright> objectList = JSON.parseArray(request.getParameter("fill_in_information"), SoftwareCopyright.class);
            softwareCopyrightService.addSoftwareCopyright(objectList);
        }else if(submitTableName.equals("ent_check")){
            // 抽查信息
            List<Check> objectList = JSON.parseArray(request.getParameter("fill_in_information"), Check.class);
            spotCheckService.addSpotCheck(objectList);
        }else if(submitTableName.equals("ent_tax_rating")){
            // 纳税评级
            List<TaxRating> objectList = JSON.parseArray(request.getParameter("fill_in_information"), TaxRating.class);
            taxRatingService.addTaxRating(objectList);
        }else if(submitTableName.equals("ent_actual_controller")){
            // 实际控制人
            List<ActualController> objectList = JSON.parseArray(request.getParameter("fill_in_information"), ActualController.class);
            theActualControllerService.addActualController(objectList);
        }else if(submitTableName.equals("ent_production_status")){
            // 生产情况
            List<ProductionStatus> objectList = JSON.parseArray(request.getParameter("fill_in_information"), ProductionStatus.class);
            theProductionStatusService.addTheProductionStatus(objectList);
        }else if(submitTableName.equals("ent_trademark")){
            // 商标信息
            List<Trademark> objectList = JSON.parseArray(request.getParameter("fill_in_information"), Trademark.class);
            trademarkService.addTrademark(objectList);
        }else if(submitTableName.equals("ent_website_records")){
            // 网站备案
            List<WebsiteRecords> objectList = JSON.parseArray(request.getParameter("fill_in_information"), WebsiteRecords.class);
            websiteFilingService.addWebsiteFilingService(objectList);
        }else if(submitTableName.equals("ent_copyright_works")){
            // 作品著作权
            List<CopyrightInWorks> objectList = JSON.parseArray(request.getParameter("fill_in_information"), CopyrightInWorks.class);
            workCopyrightService.addWorkCopyright(objectList);
        }

        //反序列化
//        ShareholderContributionInfo shareholderContributionInfo = JSON.parseObject(request.getParameter("fill_in_information"), ShareholderContributionInfo.class);
//        List<ShareholderContributionInfo> objectList = JSON.parseArray(request.getParameter("fill_in_information"), ShareholderContributionInfo.class);
////        List<ShareholderContributionInfo> objectList = JsonUtils.toList(request.getParameter("fill_in_information"), ShareholderContributionInfo.class);
//        shareholdersInvestmentService.addShareholdersInvestment(objectList);

        System.out.println("新增填报数据到数据库成功!");
        return "ok";
    }

//    @RequestMapping(value = "/query")
//    @ResponseBody
//    public Object queryBarData(HttpServletRequest request){
//        System.out.println("进入回显数据!"+request.getParameter("entId"));
////        Map map=new HashMap();
////        // 查询当前id数据库是否存在数据
////        map.put("entShareHolder",shareholdersInvestmentService.queryShareholdersInvestment(request.getParameter("entId")));
////        System.out.println("输出map!"+map);
////        return map;
//    }

    /**
     * 查询所有的企业基础填报信息
     * @param entId
     * @return
     */

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/query",method = { RequestMethod.GET, RequestMethod.POST })

    public @ResponseBody Object queryBarData(@RequestParam String entId){
        System.out.println("查询的企业id是:\t"+entId);
        Map map=new HashMap();

        // 行政许可
        map.put("ent_administrative_licensing",administrativeLicenseService.queryAdministrativeLicense(entId));
        // 自动化建设
        map.put("ent_automation_construction",biddingService.queryBidding(entId));
        // 招投标信息
        map.put("ent_Bidding",autoConstructionService.queryAutoConstruction(entId));
        // 资质认证
        map.put("ent_aptitudes_authentication",certificationService.queryCertification(entId));
        // 变更记录
        map.put("ent_change_record",changeInformationService.queryChangeInformation(entId));
        // 动产抵押信息
        map.put("ent_chattel_mortgage",chattelMortgageService.queryChattelMortgage(entId));
        // 联系人员
        map.put("ent_contact_personne",contactStaffService.queryContactStaff(entId));
        // 创新能力
        map.put("ent_innovation_ability",creativityService.queryTheProductionStatus(entId));
        // 主体信用评价
        map.put("ent_subjectCredit_evaluation",creditEvaluationService.queryCreditEvaluation(entId));
        // 信用记录
        map.put("ent_credit_record",creditHistoryService.queryCreditHistory(entId));
        // 海关信用信息
        map.put("ent_customs_credit",customsCreditService.queryCustomsCredit(entId));
        // 海关注册信息
        map.put("ent_customs_registration",customsRegistrationService.queryCustomsRegistration(entId));
        // 债权融资
        map.put("ent_bond_financing",debtfinancingService.queryDebtfinancing(entId));
        // 债权投资
        map.put("ent_creditor_rights_investment",debtInvestmentService.queryDebtInvestment(entId));
        // 环保体系认证
        map.put("ent_system_certification",environmentalCertificationService.queryEnvironmentalCertification(entId));
        // 股权融资
        map.put("ent_equity_financing",equityFinancingService.queryEquityFinancing(entId));
        // 股权投资
        map.put("ent_equity_investment",equityInvestmentService.queryEquityInvestment(entId));
        // 股权出质登记信息
        map.put("ent_share_pledge_registration",equityRegistrationService.queryEquityRegistration(entId));
        // 对外担保信息
        map.put("ent_external_guarantee",externalGuaranteeService.queryExternalGuarantee(entId));
        // 知识产权出质
        map.put("ent_intellectual_property",inPropertyRightsService.queryInPropertyRights(entId));
        // 专利信息
        map.put("ent_patent_information",patentService.queryPatent(entId));
        // 产品信息
        map.put("ent_product",productService.queryProduct(entId));
        // 公示催告
        map.put("ent_service_by_publication",publicNoticeService.queryPublicNotice(entId));
        // 股东出资信息
        map.put("ent_shareholder_contribution",shareholdersInvestmentService.queryShareholdersInvestment(entId));
        // 社保方面
        map.put("ent_social_security",socialSecurityService.querySocialSecurity(entId));
        // 软件著作权
        map.put("ent_software_copyright",softwareCopyrightService.querySoftwareCopyright(entId));
        // 抽查信息
        map.put("ent_check",spotCheckService.querySpotCheck(entId));
        // 纳税评级
        map.put("ent_tax_rating",taxRatingService.queryTaxRating(entId));
        // 实际控制人
        map.put("ent_actual_controller",theActualControllerService.queryActualController(entId));
        // 生产情况
        map.put("ent_production_status",theProductionStatusService.queryTheProductionStatus(entId));
        // 商标信息
        map.put("ent_trademark",trademarkService.queryTrademark(entId));
        // 网站备案
        map.put("ent_website_records",websiteFilingService.queryWebsiteFilingService(entId));
        // 作品著作权
        map.put("ent_copyright_works",workCopyrightService.queryWorkCopyright(entId));


        System.out.println("输出map!"+map);
        return map;
    }
}
