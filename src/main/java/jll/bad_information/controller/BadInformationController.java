package jll.bad_information.controller;

import com.alibaba.fastjson.JSONArray;
import com.cn.zyzs.utils.base.BaseClass;
import jll.bad_information.service.*;
import jll.model.bad_information.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Scope("prototype")
@RequestMapping("/BadInformation")
public class BadInformationController extends BaseClass {

    @Autowired
    private UnusualBusinessListService unusualBusinessListService;//经营异常

    @Autowired
    private AdministrativePublishmentService administrativePublishmentService;//行政处罚

    @Autowired
    private EnvironmentPunishmentService environmentPunishmentService;//环保处罚

    @Autowired
    private AdministrativeSanctionService administrativeSanctionService;//海关行政处罚

    @Autowired
    private ContraventionService contraventionService;//欠税公告

    @Autowired
    private ExecutorService executorService;//被执行人

    @Autowired
    private DiscreditExecutorService discreditExecutorService;//失信被执行人

    @Autowired
    private AdjudicativeDocumentService adjudicativeDocumentService;//裁判文书

    @Autowired
    private CourtSessionNoticeService courtSessionNoticeService;//开庭公告

    @Autowired
    private JudicialAssistanceService judicialAssistanceService;//司法协助

    @Autowired
    private JudicialAuctionService judicialAuctionService;//司法拍卖

    /**
     * entId企业ID
     * 获取不良信息
     * */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/FindBadInformation",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Object findBadInformation(@RequestParam String entId){
        Map map=new HashMap();
        //经营异常
        map.put("unusualBusinessList",unusualBusinessListService.getUnusualBusinessList(entId));
        //行政处罚
        map.put("administrativePublishment",administrativePublishmentService.getAdministrativePublishment(entId));
        //环保处罚
        map.put("environmentPunishment",environmentPunishmentService.getEnvironmentPunishment(entId));
        //海关行政处罚
        map.put("administrativeSanction",administrativeSanctionService.getAdministrativeSanction(entId));
        //欠税公告
        map.put("contravention",contraventionService.getContravention(entId));
        //被执行人
        map.put("executor",executorService.getExecutor(entId));
        //失信被执行人
        map.put("discreditExecutor",discreditExecutorService.getDiscreditExecutor(entId));
        //裁判文书
        map.put("adjudicativeDocument",adjudicativeDocumentService.getAdjudicativeDocument(entId));
        //开庭公告
        map.put("courtSessionNotice",courtSessionNoticeService.getCourtSessionNotice(entId));
        //司法协助
        map.put("judicialAssistance",judicialAssistanceService.getJudicialAssistance(entId));
        //司法拍卖
        map.put("judicialAuction",judicialAuctionService.getJudicialAuction(entId));
        return map;
    }

    /**
     * type不良信息的分类
     * content内容
     *添加不良信息
     * */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/EditBadInformation",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Object editBadInformation(@RequestParam String type,@RequestParam String content){
        System.out.println(type+"----------------"+content);
        if("unusualBusinessList".equals(type)){
            //经营异常
            List<UnusualBusinessList> ublList=JSONArray.parseArray(content,UnusualBusinessList.class);
            unusualBusinessListService.editUnusualBusinessList(ublList);
        }else if("administrativePublishment".equals(type)){
            //行政处罚
            List<AdministrativePublishment> apList =JSONArray.parseArray(content,AdministrativePublishment.class);
            administrativePublishmentService.editAdministrativePublishment(apList);
        }else if("environmentPunishment".equals(type)){
            //环保处罚
            List<EnvironmentPunishment> epList=JSONArray.parseArray(content,EnvironmentPunishment.class);
            environmentPunishmentService.editEnvironmentPunishment(epList);
        }else if("administrativeSanction".equals(type)){
            //海关行政处罚
            List<AdministrativeSanction> asList=JSONArray.parseArray(content,AdministrativeSanction.class);
            administrativeSanctionService.editAdministrativeSanction(asList);
        }else if("contravention".equals(type)){
            //欠税公告
            List<Contravention> cList=JSONArray.parseArray(content,Contravention.class);
            contraventionService.editContravention(cList);
        }else if("executor".equals(type)){
            //被执行人
            List<Executor>eList=JSONArray.parseArray(content,Executor.class);
            executorService.editExecutor(eList);
        }else if("discreditExecutor".equals(type)){
            //失信被执行人
            List<DiscreditExecutor>deList=JSONArray.parseArray(content,DiscreditExecutor.class);
            discreditExecutorService.editDiscreditExecutor(deList);
        }else if("adjudicativeDocument".equals(type)){
            //裁判文书
            List<AdjudicativeDocument>adList=JSONArray.parseArray(content,AdjudicativeDocument.class);
            adjudicativeDocumentService.editAdjudicativeDocument(adList);
        }else if("courtSessionNotice".equals(type)){
            //开庭公告
            List<CourtSessionNotice>csnList=JSONArray.parseArray(content,CourtSessionNotice.class);
            courtSessionNoticeService.editCourtSessionNotice(csnList);
        }else if("judicialAssistance".equals(type)){
            //司法协助
            List<JudicialAssistance>jaList=JSONArray.parseArray(content,JudicialAssistance.class);
            judicialAssistanceService.editJudicialAssistance(jaList);
        }else if("judicialAuction".equals(type)){
            //司法拍卖
            List<JudicialAuction>jaList=JSONArray.parseArray(content,JudicialAuction.class);
            judicialAuctionService.editJudicialAuction(jaList);
        }
        return "success";
    }

}
