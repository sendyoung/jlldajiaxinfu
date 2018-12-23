package jll.public_infomation.controller;

import com.cn.zyzs.utils.utils.PageView;
import jll.model.public_infomation.InfomationPublicty;
import jll.public_infomation.service.PublicInfomationService;
import jll.utils.JsonUtils;
import jll.utils.XinfuResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 信息公示
 */
@Controller
@Scope("prototype")
public class PublicInfomationController {

    @Autowired
    private PublicInfomationService publicInfomationService;

    /**
     * 查看新的公示列表
     * @param authOrgId
     * @param period
     * @param currentPage
     * @param rows
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST},value = {"/newpulictylist"})
    public @ResponseBody PageView findNewPublicInfomationList(String authOrgId, String period , @RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "10") int rows){
        return publicInfomationService.findNewPublicInfomationList(authOrgId,period,currentPage,rows);
    }

    /**
     * 查看新的公示详情中的信用评价榜单
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST},value = {"/newevaluatelist"})
    public @ResponseBody PageView findNewEvaluateList(String evaluateListId, @RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "10") int rows){
        return publicInfomationService.findNewEvaluateList(evaluateListId,currentPage,rows);
    }

    /**
     * 查看新的公示详情中的红黑评价榜单
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST},value = {"/newredblacklist"})
    public @ResponseBody PageView findNewRedBlackList(String redblackListId, @RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "10") int rows){
        return publicInfomationService.findNewRedBlackList(redblackListId,currentPage,rows);
    }


    /**
     * 发布公示
     *  infomationPublicty  公示内容
     *  publicStatus       公示状态1已公示  2未公示
     * @return
     * 发布公示时以下字段必须填
     * 相关榜单的ID(信用评价榜单id,红黑榜id)
     * 公示类型(1红名单2黑名单 3信用评价 4 资料公开)
     * 用户id
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST},value = {"/releasepublicty"})
    public @ResponseBody
    XinfuResult addPublictyInfomation(@RequestBody Map map){
        InfomationPublicty infomationPublicty = JsonUtils.jsonToPojo((String)map.get("infomationPublicty"),InfomationPublicty.class);
        String publicStatus = (String)map.get("publicStatus");
        return publicInfomationService.addPublictyInfomation(infomationPublicty,publicStatus);
    }

    /**
     *  查看历史公示列表
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST},value = {"/historypublicty"})
    public @ResponseBody PageView findHistoryPublicList(String userId, @RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "10") int rows){
        return publicInfomationService.findHistoryPublicList(userId,currentPage,rows);
    }

    /**
     * 查看历史公示中的信用评价榜单
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST},value = {"/historyevaluate"})
    public @ResponseBody PageView findHistoryEvaluateList(String publictyId, @RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "10") int rows){
        return publicInfomationService.findHistoryEvaluateList(publictyId,currentPage,rows);
    }

    /**
     * 查看历史公示中的红黑榜单
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST},value = {"/historyredblack"})
    public @ResponseBody PageView findHistoryRedBlackList(String publictyId, @RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "10") int rows){
        return publicInfomationService.findHistoryRedBlackList(publictyId,currentPage,rows);
    }

    /**
     * 查看历史公示内容的公示内容
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST},value = {"/infomationpublictydetail"})
    public @ResponseBody InfomationPublicty findPublictyInfomation(String publictyId){
        return publicInfomationService.findInfomationPublicty(publictyId);
    }

}
